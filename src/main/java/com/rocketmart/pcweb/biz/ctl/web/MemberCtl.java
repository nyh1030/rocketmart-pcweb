package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberCtl {

    @Autowired
    private MemberSvc memberSvc;
    @Autowired
    private ProductSvc productSvc;

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
    public String execSignup(TbMemMstRecord memberRecord, MultipartFile file, RedirectAttributes attributes) {
        Map<String, ?> resultMap = memberSvc.saveOneForMemInfo(memberRecord, file);
        attributes.addFlashAttribute("resultMsg", resultMap.get("resultMsg"));

        return "redirect:/any/signin";
    }

    /**
     * 판매자 정보조회
     * @param model
     * @param memId
     * @param principal
     * @return String
     */
    @RequestMapping("/seller/seller_detail")
    public String getSellerDetail(HttpServletRequest request, Model model, String memId, Principal principal) {

        Map<String, ?> fMap = null;

        if(memId == null || memId.isEmpty()) {

            fMap = RequestContextUtils.getInputFlashMap(request);

            if(fMap == null) {
                memId = principal.getName();
            }else {
                memId = String.valueOf(fMap.get("memId"));
            }
        }

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(memId));

        return prefixPath.concat("/mypage/seller_detail");
    }

    /**
     * 구매자 정보조회
     * @param model
     * @param memId
     * @param principal
     * @return String
     */
    @RequestMapping("/buyer/buyer_detail")
    public String getBuyerDetail(HttpServletRequest request, Model model, String memId, Principal principal) {

        Map<String, ?> fMap = null;

        if(memId == null || memId.isEmpty()) {

            fMap = RequestContextUtils.getInputFlashMap(request);

            if(fMap == null) {
                memId = principal.getName();
            }else {
                memId = String.valueOf(fMap.get("memId"));
            }
        }

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(memId));

        return prefixPath.concat("/mypage/buyer_detail");
    }

    /**
     * 판매자 수정화면
     * @param model
     * @param memId
     * @return String
     */
    @RequestMapping("/seller/seller_modify")
    public String modifySellerInfo(Model model, String memId) {

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(memId));

        return prefixPath.concat("/mypage/seller_modify");
    }

    /**
     * 구매자 수정화면
     * @param model
     * @param memId
     * @return String
     */
    @RequestMapping("/buyer/buyer_modify")
    public String modifyBuyerInfo(Model model, String memId) {

        // 회원 정보조회
        model.addAttribute("mmbr", this.memberSvc.findOneForMemInfo(memId));

        return prefixPath.concat("/mypage/buyer_modify");
    }

    /**
     * 판매자 정보수정 처리
     * @param request
     * @param file
     * @param mmbrRcrd
     * @param nwPw
     * @param principal
     * @return String
     */
    @PostMapping("/seller/execSellerModify")
    public String execSellerModify(HttpServletRequest request, MultipartFile file,
                                   TbMemMstRecord mmbrRcrd, String nwPw, Principal principal) {

        FlashMap fMap = null;

        // 수정자 아이디 저장
        mmbrRcrd.setUpdUsrId(principal.getName());
        // 판매자 정보수정
        memberSvc.execModifySellerInfo(file, mmbrRcrd, nwPw);

        fMap = RequestContextUtils.getOutputFlashMap(request);
        fMap.put("memId", mmbrRcrd.getMemId());

        return "redirect:/seller/seller_detail";
    }

    /**
     * 구매자 정보수정 처리
     * @param file
     * @param mmbrRcrd
     * @param nwPw
     * @param principal
     * @return String
     */
    @PostMapping("/buyer/execBuyerModify")
    public String execBuyerModify(HttpServletRequest request, MultipartFile file,
                                  TbMemMstRecord mmbrRcrd, String nwPw, Principal principal) {

        FlashMap fMap = null;

        // 수정자 아이디 저장
        mmbrRcrd.setUpdUsrId(principal.getName());
        // 구매자 정보수정
        memberSvc.execModifyBuyerInfo(file, mmbrRcrd, nwPw);

        fMap = RequestContextUtils.getOutputFlashMap(request);
        fMap.put("memId", mmbrRcrd.getMemId());

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
        model.addAttribute("role", tbMemMstRecord.getRole());
        model.addAttribute("approvalYn", tbMemMstRecord.getApprovalYn());
        model.addAttribute("companyNm", tbMemMstRecord.getCompanyNm());

        return prefixPath.concat("/mypage/member_list");
    }
}