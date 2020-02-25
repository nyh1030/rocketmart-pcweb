package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

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

        MemberDto temp = null;

        temp = this.memberSvc.findOneForMemInfo("admin");

        System.out.println(" :: " + temp.toString());
        System.out.println(" :: " + temp.getMemId());


        model.addAttribute("mmbr", temp);

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

