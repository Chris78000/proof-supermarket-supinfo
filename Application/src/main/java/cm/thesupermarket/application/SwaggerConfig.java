/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author ryank
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket clientApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cm.thesupermarket.controllers"))
                .paths(regex("/client.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {

        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Client Micro Service",
                "1.0",
                "Terms of service",
                new Contact("Karl", "https://github.com/Chris78000/proof-supermarket-supinfo", "304964@supinfo.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

        return apiInfo;

    }
}
