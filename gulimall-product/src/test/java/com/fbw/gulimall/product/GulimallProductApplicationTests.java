package com.fbw.gulimall.product;

import com.fbw.gulimall.product.entity.BrandEntity;
import com.fbw.gulimall.product.service.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("huawei");

        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}
