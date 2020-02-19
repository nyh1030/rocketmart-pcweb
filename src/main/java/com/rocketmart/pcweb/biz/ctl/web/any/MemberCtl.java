package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/any/member")
public class MemberCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private MemberSvc memberSvc;

    // 내 정보 페이지
    @GetMapping("/myinfo")
    public String dispMyInfo() {
        return prefixPath.concat("/mypage/myinfo");
    }


}

