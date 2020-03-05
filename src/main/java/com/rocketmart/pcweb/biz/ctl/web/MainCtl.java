package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtl {

    private String prefixPath = "fragments/content";

    @GetMapping("/")
    public String main(){
        return "/index";
    }


    /**
     * 메인 > ContactUs 등록 페이지
     * @return String
     */
    @GetMapping("/any/contactus/register")
    public String dispContactUs() {
        return prefixPath.concat("/other/contactus_register");
    }

    /**
     * 메인 > 상품상세페이지
     * @return String
     */
    @GetMapping("/any/product/detail")
    public String dispProductDetail() {
        return prefixPath.concat("/product_detail");
    }
}

