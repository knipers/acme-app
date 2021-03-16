package com.moacirknipers.app.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfigurations {

    private static String API_NAME = "Acme Producer REST API service";
    private static String API_DESCRIPTION = "AP company List of services";
    private static String API_VERSION = "1.0";
    private static String URL_TERMS_AND_LICENSE = "https://google.com";
    private static String API_LICENSE = "API License";
    private static String CONTACT_NAME = "moacir.rafael@gmail.com";

    @Bean
    public springfox.documentation.spring.web.plugins.Docket docket() {
        Docket docket = new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2);
        return docket.apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        @SuppressWarnings("deprecation")
        ApiInfo apiInfo = new ApiInfo(API_NAME, API_DESCRIPTION, API_VERSION,
                URL_TERMS_AND_LICENSE, CONTACT_NAME, API_LICENSE, URL_TERMS_AND_LICENSE);
        return apiInfo;
    }

}
