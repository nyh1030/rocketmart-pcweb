package com.rocketmart.pcweb.biz.ctl.web.any;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/any/member")
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @GetMapping("/login")
    public String loginForm(
            @RequestParam(value = "gbn", required = false, defaultValue = "login") String gbn
    ) {
        return prefixPath.concat("/member/login");
    }


}

