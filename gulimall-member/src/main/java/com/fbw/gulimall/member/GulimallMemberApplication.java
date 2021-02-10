package com.fbw.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
    想要远程调用别的服务
    1. 引入open-Feign
    2. 编写一个借口，告诉springcloud这个接口需要调用远程服务
        1）声明接口里的每一个方法都是调用哪个远程服务的那个请求
    3. 开启远程调用功能 @EnableFeignClients
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.fbw.gulimall.member.feign")//指定远程调用接口的包名
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
