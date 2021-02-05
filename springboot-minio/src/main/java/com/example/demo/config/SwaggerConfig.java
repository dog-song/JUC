package com.example.demo.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("MinIO文档")
    private String title;

    @Value("SpringBoot整合MinIO接口文档")
    private String description;

    @Value("1.0")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(title)
                //创建人、个人门户网站、邮箱
                .contact(new Contact("Domi","www.domisong.com","1211590625@qq.com"))
                //描述
                .description(description)
                //版本号
                .version(version)
                .build();
    }

    private List<ResponseMessage> responseMessages(){
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        Map<String, Header> headers = new HashMap<>(4);
        headers.put("token",new Header("token","jwt令牌",new ModelRef("string")));
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("ok").headersWithDescription(headers).build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求参数错误").responseModel(new ModelRef("MessageResponse")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未授权/授权失败").responseModel(new ModelRef("MessageResponse")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("路由不存在").responseModel(new ModelRef("MessageResponse")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(405).message("不支持的请求方法").responseModel(new ModelRef("MessageResponse")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("MessageResponse")).build());
        return responseMessageList;
    }
}