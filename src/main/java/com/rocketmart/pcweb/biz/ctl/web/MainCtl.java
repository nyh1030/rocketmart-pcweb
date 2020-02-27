package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtl {

    @Autowired
    private MemberSvc memberSvc;

    private String prefixPath = "fragments/content";

    @GetMapping("/")
    public String main(){
        return "/index";
    }

    // 회사정보
    @GetMapping("/company_info")
    public String company_info(Model model) {

        // 회사정보 조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo("admin"));

        return prefixPath.concat("/mypage/seller_detail");
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

    // contact us > 등록
    @GetMapping("/product_register")
    public String product_register() {
        return prefixPath.concat("/mypage/product_register");
    }
}

