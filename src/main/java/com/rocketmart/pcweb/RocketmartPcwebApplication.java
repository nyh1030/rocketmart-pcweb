package com.rocketmart.pcweb;

import com.rocketmart.pcweb.biz.dao.BrandDto;
import com.rocketmart.pcweb.biz.svc.BrandService;
import com.rocketmart.pcweb.common.file.FileUploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({
        FileUploadProperties.class
})
public class RocketmartPcwebApplication implements CommandLineRunner {

    @Autowired
    private BrandService brandService;

    public static void main(String[] args) {
        SpringApplication.run(RocketmartPcwebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int resultCount = brandService.insertBrandInfo(BrandDto.builder().brandId("nike").brandName("나이키").build());
        log.info("resultCount ::: {}", resultCount);

        List<BrandDto> resultList = brandService.findAll();
        log.info("resultList ::: {}", resultList.toString());
    }
}
