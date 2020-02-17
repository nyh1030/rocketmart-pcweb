package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.dao.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/any/member")
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private MemberService memberService;

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin() {
        return prefixPath.concat("/member/login");
    }

    // 로그인 결과 페이지
    @GetMapping("/login/result")
    public String dispLoginResult() {
        return prefixPath.concat("/member/loginSuccess");
    }

    // 로그아웃 결과 페이지
    @GetMapping("/logout/result")
    public String dispLogout() {
        return prefixPath.concat("/member/logout");
    }

    // 접근 거부 페이지
    @GetMapping("/denied")
    public String dispDenied() {
        return prefixPath.concat("/member/denied");
    }

    // 회원가입 처리
   @PostMapping("/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 내 정보 페이지
    @GetMapping("/myinfo")
    public String dispMyInfo() {
        return prefixPath.concat("/mypage/myinfo");
    }


}

