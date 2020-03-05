package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class MemberCtl {

    @Autowired
    private MemberSvc memberSvc;

    private String prefixPath = "fragments/content";

    /**
     * 회원가입 페이지
     * @return String
     */
    @GetMapping("/any/signup")
    public String dispSignup() {
        return prefixPath.concat("/user/signup");
    }

    /**
     * 이용약관 페이지
     * @return String
     */
    @GetMapping("/any/privacyPolicy")
    public String dispPrivacyPolicy() {
        return prefixPath.concat("/user/privacyPolicy");
    }

    /**
     * 개인정보동의 페이지
     * @return String
     */
    @GetMapping("/any/termsConditions")
    public String dispTermsConditions() {
        return prefixPath.concat("/user/termsConditions");
    }

    /**
     * 회원가입 처리
     * @param memberRecord
     * @return String
     */
    @PostMapping("/any/member/signup")
    public String execSignup(TbMemMstRecord memberRecord) {

        memberSvc.saveOneForMemInfo(memberRecord);

        return "redirect:/user/signin";
    }

    /**
     * 판매자 정보조회
     * @param model
     * @param mmbrId
     * @return String
     */
    @PostMapping("/seller/seller_detail")
    public String getSellerDetail(Model model, String mmbrId) {

        if(mmbrId.isEmpty()) {
            mmbrId = "123123123@asd.com";
        }

        System.out.println(" ::: " + mmbrId);

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo("123123123@asd.com"));

        return prefixPath.concat("/mypage/seller_detail");
    }

    /**
     * 구매자 정보조회
     * @param model
     * @param mmbrId
     * @return String
     */
    @PostMapping("/buyer/buyer_detail")
    public String getBuyerDetail(Model model, String mmbrId) {

        if(mmbrId.isEmpty()) {
            mmbrId = "buyer@buyer.com";
        }

        System.out.println(" ::: " + mmbrId);

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(mmbrId));

        return prefixPath.concat("/mypage/buyer_detail");
    }

    /**
     * 판매자 수정화면
     * @param model
     * @param mmbrId
     * @return String
     */
    @PostMapping("/seller/seller_modify")
    public String modifySellerInfo(Model model, String mmbrId) {

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(mmbrId));

        return prefixPath.concat("/mypage/seller_modify");
    }

    /**
     * 구매자 수정화면
     * @param model
     * @param mmbrId
     * @return String
     */
    @PostMapping("/buyer/buyer_modify")
    public String modifyBuyerInfo(Model model, String mmbrId) {

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(mmbrId));

        return prefixPath.concat("/mypage/buyer_modify");
    }

    /**
     * 판매자 정보수정 처리
     * @param mmbrRcrd
     * @param nwPw
     * @return String
     */
    @PostMapping("/seller/execSellerModify")
    public String execSellerModify(TbMemMstRecord mmbrRcrd, String nwPw, Principal principal) {
        mmbrRcrd.setUpdUsrId(principal.getName());
        // 판매자 정보수정
        memberSvc.execModifySellerInfo(mmbrRcrd, nwPw);

        return "redirect:/seller/seller_detail";
    }

    /**
     * 구매자 정보수정 처리
     * @param mmbrRcrd
     * @param nwPw
     * @return String
     */
    @PostMapping("/buyer/execBuyerModify")
    public String execBuyerModify(TbMemMstRecord mmbrRcrd, String nwPw, Principal principal) {
        mmbrRcrd.setUpdUsrId(principal.getName());
        // 구매자 정보수정
        memberSvc.execModifyBuyerInfo(mmbrRcrd, nwPw);

        return "redirect:/buyer/buyer_detail";
    }

    /**
     * 회원 목록 조회(어드민)
     * @param tbMemMstRecord
     * @param model
     * @return String
     */
    @RequestMapping("/admin/member/list")
    public String dispMemberList(TbMemMstRecord tbMemMstRecord, Model model) {

        model.addAttribute("memList", memberSvc.findAllForMemInfo(tbMemMstRecord));
        model.addAttribute("memNm", tbMemMstRecord.getMemNm());
        model.addAttribute("approvalYn", tbMemMstRecord.getApprovalYn());
        model.addAttribute("companyNm", tbMemMstRecord.getCompanyNm());

        return prefixPath.concat("/mypage/member_list");
    }
}