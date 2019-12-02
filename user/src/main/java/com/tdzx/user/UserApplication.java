package com.tdzx.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource(value = "file:C:/data/sxc/config/conf.properties",ignoreResourceNotFound = true)
//@PropertySource(value = "file:D:/config/conf.properties",ignoreResourceNotFound = true)
@PropertySource(value = "file:/usr/local/tdzx/config/conf.properties",ignoreResourceNotFound = true)
@EnableSwagger2
@EnableScheduling
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
