// package com.example.demo.until;
//
// import com.cloudwise.gaia.common.service.IFileHandler;
// import io.minio.*;
// import io.minio.errors.*;
// import io.minio.messages.DeleteError;
// import io.minio.messages.DeleteObject;
// import lombok.extern.slf4j.Slf4j;
// import org.apache.commons.lang3.exception.ExceptionUtils;
//
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.OutputStream;
// import java.security.InvalidKeyException;
// import java.security.NoSuchAlgorithmException;
// import java.util.LinkedList;
// import java.util.List;
//
// /**
//  * @author domisong.
//  * @description: TODO
//  * @date 2021/4/22.
//  */
// @Slf4j
// public class MinIOFileHandler implements IFileHandler {
//
//     public static final String bucket = "docc";
//
//     private MinioClient minioClient;
//
//     public MinIOFileHandler(MinioClient minioClient) {
//
//         this.minioClient = minioClient;
//     }
//
//     @Override
//     public void upload(String name, InputStream inputStream) {
//
//         name = transObjectName(name);
//
//         try {
//             minioClient.putObject(
//                     PutObjectArgs.builder().bucket(bucket).object(name).stream(inputStream, -1, 10485760).build());
//         } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IllegalArgumentException
//                 | IOException e) {
//
//             log.error(ExceptionUtils.getStackTrace(e));
//         } finally {
//
//             if (inputStream != null) {
//
//                 try {
//                     inputStream.close();
//                 } catch (IOException e) {
//                     log.error(ExceptionUtils.getStackTrace(e));
//                 }
//             }
//         }
//     }
//     @Override
//     public void uploadFdf(String name, InputStream inputStream) {
//
//         name = transObjectName(name);
//
//         try {
//             minioClient.putObject(
//                     PutObjectArgs.builder().bucket(bucket).object(name).stream(inputStream, -1, 10485760).build());
//
//         } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IllegalArgumentException
//                 | IOException e) {
//
//             log.error(ExceptionUtils.getStackTrace(e));
//         }
//     }
//
//     @Override
//     public void download(String name, OutputStream outputStream) {
//
//         name = transObjectName(name);
//
//         InputStream inputStream = null;
//
//         try {
//             inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(name).build());
//
//             byte[] buf = new byte[4096];
//             int line = 0;
//             while ((line = inputStream.read(buf)) != -1) {
//                 outputStream.write(buf, 0, line);
//             }
//
//         } catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//                 | InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//                 | IllegalArgumentException | IOException e) {
//
//             log.error(ExceptionUtils.getStackTrace(e));
//         } finally {
//
//             if (outputStream != null) {
//
//                 try {
//                     outputStream.flush();
//                 } catch (IOException e) {
//                     log.error(ExceptionUtils.getStackTrace(e));
//                 }
//
//                 try {
//                     outputStream.close();
//                 } catch (IOException e) {
//                     log.error(ExceptionUtils.getStackTrace(e));
//                 }
//             }
//
//             if (inputStream != null) {
//
//                 try {
//                     inputStream.close();
//                 } catch (IOException e) {
//                     log.error(ExceptionUtils.getStackTrace(e));
//                 }
//
//             }
//         }
//     }
//
//     @Override
//     public void remove(String name) {
//
//         name = transObjectName(name);
//         try {
//
//             minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(name).build());
//
//         } catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//                 | InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//                 | IllegalArgumentException | IOException e) {
//
//             log.error(ExceptionUtils.getStackTrace(e));
//         }
//     }
//
//     @Override
//     public void removeAll(List<String> names) {
//
//         if (names == null || names.size() == 0) {
//
//             return;
//         }
//
//         List<DeleteObject> objects = new LinkedList<>();
//
//         if (names != null && names.size() > 0) {
//
//             for (String name : names) {
//
//                 name = transObjectName(name);
//
//                 objects.add(new DeleteObject(name));
//             }
//
//         }
//         Iterable<Result<DeleteError>> results = minioClient
//                 .removeObjects(RemoveObjectsArgs.builder().bucket(bucket).objects(objects).build());
//
//         for (Result<DeleteError> result : results) {
//             try {
//
//                 DeleteError error = result.get();
//
//                 log.error(error.message());
//
//             } catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
//                     | InternalException | InvalidResponseException | NoSuchAlgorithmException | ServerException
//                     | XmlParserException | IOException e) {
//
//                 log.error(ExceptionUtils.getStackTrace(e));
//             }
//         }
//     }
//
//     @Override
//     public boolean exists(String name) {
//
//         try {
//
//             name = transObjectName(name);
//
//             StatObjectResponse objectStat = minioClient
//                     .statObject(StatObjectArgs.builder().bucket(bucket).object(name).build());
//
//             if (objectStat != null) {
//                 return true;
//             }
//
//         } catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//                 | InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//                 | IllegalArgumentException | IOException e) {
//
//             if (e instanceof ErrorResponseException) {
//
//                 ErrorResponseException ere = (ErrorResponseException) e;
//
//                 if ("NoSuchKey".equals(ere.errorResponse().code())) {
//
//                     return false;
//                 } else {
//
//                     log.error(ExceptionUtils.getStackTrace(e));
//                 }
//             }
//         }
//
//         return false;
//     }
//
//     private String transObjectName(String name) {
//
//         return name.replace(".", "_").replaceAll("/", "@");
//     }
//
// }
