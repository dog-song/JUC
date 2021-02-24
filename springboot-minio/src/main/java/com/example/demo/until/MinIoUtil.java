package com.example.demo.until;

import com.example.demo.config.MinIoConfig;
import io.minio.*;
import io.minio.http.Method;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by Domi on 2021/02/04.
 */
@Slf4j
@Component
public class MinIoUtil {

    @Autowired
    MinIoConfig minIoConfig;

    @Autowired
    private /*static*/ MinioClient minioClient;

    /**
     * 初始化minio配置
     *
     * @param :
     * @return: void
     */
    /*@PostConstruct
    public void init() {
        try {
            minioClient = MinioClient.builder().endpoint(minIoConfig.getUrl()).credentials(minIoConfig.getAccessKey(), minIoConfig.getSecretKey()).build();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("初始化minio配置异常: 【{}】", e.fillInStackTrace());
        }
    }*/

    /**
     * 文件上传
     *
     * @param bucketName:
     *            桶名
     * @param multipartFile:
     *            文件
     * @return: java.lang.String : 文件url地址
     */
    public /*static*/ String upload(String bucketName, MultipartFile multipartFile) {
        final String fileName = multipartFile.getOriginalFilename();
        String contentType = multipartFile.getContentType();
        try (InputStream inputStream = multipartFile.getInputStream()) {
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName)
                    .object(fileName)
                    .stream(inputStream, multipartFile.getSize(), -1)
                    .contentType(contentType).build()
            );
            log.info("附件上传成功, fileName: {}, contentType: {}, size(Byte): {}", fileName, contentType, multipartFile.getSize());
        } catch (Exception e) {
            log.error("附件上传失败, fileName: {}, contentType: {}, size(Byte): {}", fileName, contentType, multipartFile.getSize());
        }

        return getFileUrl(bucketName, fileName);
    }

    /**
     * 删除文件
     *
     * @param bucketName:
     *            桶名
     * @param fileName:
     *            文件名
     * @return: void
     */
    public /*static*/ void deleteFile(String bucketName, String fileName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build());
            log.info("附件: {}, 删除成功!", fileName);
        } catch (Exception e) {
            log.error("附件: {}, 删除失败...", fileName);
            log.error(String.valueOf(e.getStackTrace()));
        }
    }

    /**
     * 下载文件
     *
     * @param bucketName:
     *            桶名
     * @param fileName:
     *            文件名
     * @param httpServletResponse:
     * @return: void
     */
    public /*static*/ void download(String bucketName, String fileName, HttpServletResponse httpServletResponse) {
        try {
            StatObjectResponse statObjectResponse = minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(fileName).build());
            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            httpServletResponse.setContentType(statObjectResponse.contentType());
            httpServletResponse.setCharacterEncoding("UTF-8");
            InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
            IOUtils.copy(inputStream, httpServletResponse.getOutputStream());
        } catch (Exception e) {
            log.error("附件下载失败, fileName: {}, bucketName: {}", fileName, bucketName);
            log.error(String.valueOf(e.getStackTrace()));
        }
    }

    /**
     * 获取minio文件的下载地址
     *
     * @param bucketName:
     *            桶名
     * @param fileName:
     *            文件名
     * @return: java.lang.String
     */
    public /*static*/ String getFileUrl(String bucketName, String fileName) {
        String fileUrl = "";
        try{
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(fileName).build());
            fileUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucketName).object(fileName).build());
        } catch (Exception e){
            log.error("获取预览URL失败, fileUrl: {}", fileUrl);
        }
        return fileUrl;
    }

}

