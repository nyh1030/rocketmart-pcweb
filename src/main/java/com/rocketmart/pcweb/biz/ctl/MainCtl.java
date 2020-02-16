package com.rocketmart.pcweb.biz.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtl {

    private String prefixPath = "fragments/content";

    @GetMapping("/main")
    public String main(){
        return "index";
    }

    @GetMapping("/brand_detail")
    public String brand_detail() {
        return prefixPath.concat("/mypage/brand_detail");
    }

    @GetMapping("/product_info01")
    public String product_info01() {
        return prefixPath.concat("/mypage/product_info01");
    }
}

