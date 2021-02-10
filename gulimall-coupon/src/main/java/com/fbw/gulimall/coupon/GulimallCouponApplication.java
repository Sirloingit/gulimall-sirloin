package com.fbw.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
    如何使用nacos配置中心统一管理配置
    1）引入依赖
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
    2）创建一个bootstrap.properties
        spring.application.name=gulimall-coupon
        spring.cloud.nacos.config.server-addr=localhost:8848
    3）需要给配置中心默认添加一个数据集 gulimall-coupon.properties。默认规则： 应用名.properties
    4）给 应用名.properties 添加任何配置
    5）动态获取配置
        @RefreshScope : 动态获取并刷新配置
        @Value("${配置项名}")：给属性赋值
        如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的数据。

    细节：
        1）命名空间：配置隔离
            默认：public ; 默认新增的所有配置都在public空间。
            1、开发、测试、生产 不同配置 不同的命名空间, 利用命名空间来做环境隔离
                注意：要在bootstrap.properties 中配置需要哪个命名空间
                    spring.cloud.nacos.config.namespace=51c27425-f80e-4759-b420-3f194b52eec4
            2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置

        2）配置集：所有配置的集合

        3）配置集ID：类似配置文件名 Data ID

        4）配置分组: 默认所有的配置集都属于：DEFAULT_GROUP
             1111\618  可以在bootstrap.properties 中指定分组 spring.cloud.nacos.config.group=dev

项目中使用：每个微服务创建自己的命名空间，使用配置分组区分环境：test dev prod

    同时加载多个配置集
    1) 微服务任何配置文件都可以放在配置中心中
    2）需要在bootstrap.properties 说明加载配置中心中哪些配置文件即可
           spring.cloud.nacos.config.ext-config[0].data-id=datasource.yml
           spring.cloud.nacos.config.ext-config[0].group=dev
           spring.cloud.nacos.config.ext-config[0].refresh=true
    3）@Value @ConfigurationProperties。。。
            以前springboot任何方法从配置中心中获取值，都可以使用。配置中心有的优先使用
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
