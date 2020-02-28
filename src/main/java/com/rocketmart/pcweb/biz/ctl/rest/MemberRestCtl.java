package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestCtl {

    @Autowired
    private MemberSvc memberSvc;

    /**
     * 회원중복 체크
     * @param memId
     * @return int
     *
     * Y면 중복아이디 존재, N이면 중복아이디 없음(회원가입가능)
     */
    @PostMapping("/any/restMember/idOverLapChk")
    public boolean idOverLapChk(@RequestBody String memId) {
        return memberSvc.idOverLapChk(memId);
    }

}
