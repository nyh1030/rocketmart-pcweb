package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 판매자 정보조회
     * @param model
     * @return String
     */
    @GetMapping("/seller/seller_detail")
    public String seller_info(Model model) {

        // 회사정보 조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo("123123123@asd.com"));
        return prefixPath.concat("/mypage/seller_detail");
    }

    /**
     * 판매자 수정화면
     * @param model
     * @param mmbrId
     * @return String
     */
    @PostMapping("/seller/seller_modify")
    public String seller_modify(Model model, String mmbrId) {


        System.out.println(" ::: " + mmbrId);
        // 회사정보 조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(mmbrId));

        return prefixPath.concat("/mypage/seller_modify");
    }

    /**
     * 판매자 정보수정
     * @param mmbrRcrd
     * @return String
     */
    @PostMapping("/seller/execSellerModify")
    public String execSellerModify(TbMemMstRecord mmbrRcrd) {

        int ret = 0;

        // 판매자 정보수정
        ret = memberSvc.execModifySellerInfo(mmbrRcrd);

        return "redirect:/seller/seller_detail";
    }
}

