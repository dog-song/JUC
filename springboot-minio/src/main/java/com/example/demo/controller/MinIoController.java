package com.example.demo.controller;

import com.example.demo.config.MinIoConfig;
import com.example.demo.until.MinIoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Domi on 2021/02/04.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/minio")
@Api(tags = {"MinIO接口文档"})
public class MinIoController {

    @Autowired
    MinIoConfig minIoConfig;

    @Autowired
    MinIoUtil minIoUtil;

    @ApiOperation(value = "上传文件")
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        String fileUrl = minIoUtil.upload(minIoConfig.getBucketName(), file);
        log.info("文件下载地址：" +fileUrl );
        return "文件下载地址：" + fileUrl;
    }

    @ApiOperation(value = "下载文件")
    @GetMapping(value = "/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        minIoUtil.download(minIoConfig.getBucketName(), fileName, response);
    }

    @ApiOperation(value = "删除文件")
    @GetMapping(value = "/delete")
    public String delete(@RequestParam("fileName") String fileName){
        minIoUtil.deleteFile(minIoConfig.getBucketName(), fileName);
        return "删除成功";
    }
}
