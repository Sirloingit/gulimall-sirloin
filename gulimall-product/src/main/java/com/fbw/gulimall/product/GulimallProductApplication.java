package com.fbw.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
    1\ 整合MybatisPlus
        导入依赖：
         <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.2.0</version>
        </dependency>

    2、 配置
        1. 配置数据源
            1）导入数据库mysql驱动
            2) 在application.yml配置数据源相关信息
        2. 配置mybatisplus
            1）使用@MapperScan注解
            2）告诉MybatisPlus，sql映射文件在哪

 */
@MapperScan("com.fbw.gulimall.product.dao")
@EnableDiscoveryClient//开启服务注册与发现功能
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
