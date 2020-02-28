package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private MemberSvc memberSvc;

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return prefixPath.concat("/user/signup");
    }

    //회원가입 처리
    @PostMapping("/any/member/signup")
    public String execSignup(TbMemMstRecord memberRecord) {

        memberSvc.saveOneForMemInfo(memberRecord);

        return "redirect:/user/signin";
    }



}

