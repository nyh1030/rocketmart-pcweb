package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/any/member")
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private MemberSvc memberSvc;

    @PostMapping("/signup")
    public String execSignup(MemberDto memberDto) {

        memberSvc.saveOneForMemInfo(memberDto);

        return "redirect:/login/signin";
    }



}

