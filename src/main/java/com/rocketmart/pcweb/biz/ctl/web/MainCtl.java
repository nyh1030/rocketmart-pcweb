package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainCtl {

    @Autowired
    private CategorySvc categorySvc;

    @Autowired
    private ProductSvc productSvc;

    @Autowired
    private BrandSvc brandSvc;

    private String prefixPath = "fragments/content";

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("categoryList", categorySvc.findAll());
        model.addAttribute("productList", productSvc.findAllForLastestOrder());

        List<Map<String, Object>> brandList = brandSvc.findAll();
        Collections.shuffle(brandList);
        model.addAttribute("brandList", brandList);

        model.addAttribute("cate101_productList", productSvc.findProductListByCateCd("101"));
        model.addAttribute("cate102_productList", productSvc.findProductListByCateCd("102"));
        model.addAttribute("cate103_productList", productSvc.findProductListByCateCd("103"));
        model.addAttribute("cate104_productList", productSvc.findProductListByCateCd("104"));
        model.addAttribute("cate105_productList", productSvc.findProductListByCateCd("105"));
        model.addAttribute("cate106_productList", productSvc.findProductListByCateCd("106"));
        model.addAttribute("cate107_productList", productSvc.findProductListByCateCd("107"));

        model.addAttribute("cate201_productList", productSvc.findProductListByCateCd("201"));
        model.addAttribute("cate202_productList", productSvc.findProductListByCateCd("202"));
        model.addAttribute("cate203_productList", productSvc.findProductListByCateCd("203"));
        model.addAttribute("cate204_productList", productSvc.findProductListByCateCd("204"));
        model.addAttribute("cate205_productList", productSvc.findProductListByCateCd("205"));

        model.addAttribute("cate301_productList", productSvc.findProductListByCateCd("301"));
        model.addAttribute("cate302_productList", productSvc.findProductListByCateCd("302"));
        model.addAttribute("cate303_productList", productSvc.findProductListByCateCd("303"));
        model.addAttribute("cate304_productList", productSvc.findProductListByCateCd("304"));
        model.addAttribute("cate305_productList", productSvc.findProductListByCateCd("305"));

        model.addAttribute("cate401_productList", productSvc.findProductListByCateCd("401"));
        model.addAttribute("cate402_productList", productSvc.findProductListByCateCd("402"));
        model.addAttribute("cate403_productList", productSvc.findProductListByCateCd("403"));

        model.addAttribute("cate501_productList", productSvc.findProductListByCateCd("501"));
        model.addAttribute("cate502_productList", productSvc.findProductListByCateCd("502"));

        return "/index";
    }


    /**
     * 메인 > ContactUs 등록 페이지
     * @return Stringhomepage-5.html
     */
    @GetMapping("/any/contactus/register")
    public String dispContactUs() {
        return prefixPath.concat("/other/contactus_register");
    }
}

