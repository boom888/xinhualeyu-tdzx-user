package com.tdzx.user.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${spring.profiles.active}")
    private String env;

    @Bean
    public Docket createRestApi(){
        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        if ("prod".equals(env)){
            return  apiSelectorBuilder
                    .paths(PathSelectors.none())
                    .build();
        }else {
            return  apiSelectorBuilder
                    .paths(PathSelectors.any())
                    .build();
        }
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("User模块")
                .contact("boom")
                .version("1.0")
                .build();
    }
}
