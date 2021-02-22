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


     Mybatis-Plus 逻辑删除
     1、配置全局的逻辑删除规则
     2、低版本mybatisplus要配置逻辑删除组件Bean
     3、给Bean加上逻辑删除注解 @TableLogic

    3. JSR303数据校验
        1) 给Bean添加校验注解，javax.validation.constraints.* 并定义自己的message提示
        2）开启校验功能 @Valid 检验错误后会有默认的响应
        3）给校验的Bean后面紧跟一个BindingResult， 就可以获取到校验的结果
        4）分组校验 给校验注解标注 groups
            使用前 @Validate({xxx.class})
            默认没有指定分组的校验注解在分组校验情况下不生效
        5）自定义校验
            编写自定义的校验注解 和 校验器

    4. 统一的异常处理
        @ControllerAdvice
        1）编写异常处理类
        2）使用@ExceptionHandler标注方法可以处理的异常类
 */
@MapperScan("com.fbw.gulimall.product.dao")
@EnableDiscoveryClient//开启服务注册与发现功能
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
