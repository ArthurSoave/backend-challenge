package com.soave.backendchallenge.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Value("${spring.application.version}")
    private String version;

    @Value("${spring.application.description}")
    private String description;

    @Bean
    public Docket apiV1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soave.backendchallenge.api.v1"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder()
                        .version(version)
                        .contact(contact())
                        .title("API de validação de senhas")
                        .description(description)
                        .build());
    }

    private Contact contact(){
        return new Contact(
                "Arthur Soave",
                "https://github.com/ArthurSoave",
                "atrpaula@gmail.com");
    }
}
