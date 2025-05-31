package com.manong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.manong.mapper")
public class AuthoritySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthoritySystemApplication.class, args);
    }

}