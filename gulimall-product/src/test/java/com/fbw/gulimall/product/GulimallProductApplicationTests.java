package com.fbw.gulimall.product;


import com.fbw.gulimall.product.entity.BrandEntity;
import com.fbw.gulimall.product.service.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;
//
//    @Autowired
//    OSSClient ossClient;
//
//    @Test
//    public void uploadTest() throws FileNotFoundException {
////        // Endpoint以杭州为例，其它Region请按实际情况填写。
////        String endpoint = "oss-cn-shanghai.aliyuncs.com";
////        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
////        String accessKeyId = "LTAI4G5aaAyWWi9LrZ6jrR1M";
////        String accessKeySecret = "tJTmEIhhCZKF1jVPSH5a0EIbISEOlk";
////
////        // 创建OSSClient实例。
////        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 上传文件流。
//        InputStream inputStream = new FileInputStream("C:\\Users\\Lenovo\\Pictures\\11.png");
//        ossClient.putObject("gulimall-sirloin", "屏幕截图(1).png", inputStream);
//
//// 关闭OSSClient。
//        ossClient.shutdown();
//
//        System.out.println("上传完成。。。");
//    }

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("huawei");

        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}
