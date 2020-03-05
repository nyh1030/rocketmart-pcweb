package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     * @return boolean
     *
     * Y면 중복아이디 존재, N이면 중복아이디 없음(회원가입가능)
     */
    @PostMapping("/any/rest/member/idOverLapChk")
    public boolean idOverLapChk(@RequestBody String memId) {
        return memberSvc.idOverLapChk(memId);
    }

    /**
     * 회원 승인 처리
     * @param mmbrId
     * @param apprvlYn
     * @return String
     */
    @PostMapping("/any/rest/member/execApproval")
    public String execApproval(String mmbrId, String apprvlYn) {

        String msg = "";

        // 회원 승인 처리
        msg = memberSvc.execApprovalMember(mmbrId, apprvlYn);

        return msg;
    }
}
