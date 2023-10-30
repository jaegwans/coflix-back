package com.example.coflix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.coflix.mapper")
public class CoflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoflixApplication.class, args);
    }

}
