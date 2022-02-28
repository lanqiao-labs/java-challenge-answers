package org.lanqiao;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.lanqiao.mapper"})
@EnableDubbo // 启动 dubbo
public class ProviderStudentApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderStudentApp.class, args);
    }

}