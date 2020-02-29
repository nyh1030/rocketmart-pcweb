package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private MemberSvc memberSvc;

    // 회원가입 페이지
    @GetMapping("/any/signup")
    public String dispSignup() {
        return prefixPath.concat("/user/signup");
    }

    //회원가입 처리
    @PostMapping("/any/member/signup")
    public String execSignup(TbMemMstRecord memberRecord) {

        memberSvc.saveOneForMemInfo(memberRecord);

        return "redirect:/any/signin";
    }

    //회원목록(어드민)
    @PostMapping("/admin/member/list")
    public String dispMemberList(Model model) {

        model.addAttribute("memList", memberSvc.findAllForMemInfo());

        return prefixPath.concat("/mypage/member_list");
    }

}

