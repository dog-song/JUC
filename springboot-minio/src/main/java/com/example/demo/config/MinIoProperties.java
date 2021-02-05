package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Domi on 2021/02/04.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinIoProperties {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucketName;

}
