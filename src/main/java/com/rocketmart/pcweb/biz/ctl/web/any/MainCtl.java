package com.rocketmart.pcweb.biz.ctl.web.any;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtl {

    private String prefixPath = "fragments/content";

    @GetMapping("/")
    public String main(){
        return "/index";
    }


    // 제품정보 > 브랜드 추가
    @GetMapping("/brand_add")
    public String brand_add() {
        return prefixPath.concat("/mypage/brand_add");
    }

    // 제품정보 > 브랜드 등록
    @GetMapping("/brand_register")
    public String brand_register() {
        return prefixPath.concat("/mypage/brand_register");
    }

    // 제품정보 > 브랜드 상세
    @GetMapping("/brand_detail")
    public String brand_detail() {
        return prefixPath.concat("/mypage/brand_detail");
    }

    // 회사정보
    @GetMapping("/company_info")
    public String company_info() {
        return prefixPath.concat("/mypage/company_info");
    }

    // contact us > 조회
    @GetMapping("/contact_list")
    public String contact_list() {
        return prefixPath.concat("/admin/contact_list");
    }

    // contact us > 등록
    @GetMapping("/contact_register")
    public String contact_register() {
        return prefixPath.concat("/admin/contact_register");
    }
}

