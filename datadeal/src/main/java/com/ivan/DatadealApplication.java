package com.ivan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.ivan.mapper")
@SpringBootApplication
public class DatadealApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatadealApplication.class, args);
    }

}
