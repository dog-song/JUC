package com.example.demo.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Domi on 2021/02/04.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinIoConfig {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucketName;


    /**
     * 初始化 MinIO Client
     *
     * @return
     */
    @Bean
    public MinioClient initMinioClient () {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }
}
