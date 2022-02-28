package org.lanqiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务注册功能
@MapperScan(basePackages = {"org.lanqiao.mapper"})
public class ProviderEmpApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderEmpApp.class, args);
    }

}