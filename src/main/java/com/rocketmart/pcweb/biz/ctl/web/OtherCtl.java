package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.OtherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private OtherSvc otherSvc;

    // contactUs 등록 페이지
    @GetMapping("/any/contactus/register")
    public String dispContactUs() {
        return prefixPath.concat("/other/contactUs_register");
    }

}

