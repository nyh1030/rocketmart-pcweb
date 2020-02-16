package com.rocketmart.pcweb.biz.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @PostMapping("/member")
    public String saveOneForMem() {
        return prefixPath.concat("/main");
    }

}

