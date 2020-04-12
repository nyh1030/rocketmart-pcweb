package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbInquiryMstRecord;
import com.rocketmart.jooq.tables.records.TbPrdMstRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.biz.svc.OtherSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OtherCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private OtherSvc otherSvc;

    @Autowired
    private ProductSvc productSvc;

    @Autowired
    private MemberSvc memberSvc;

    /**
     * ContactUs 목록(어드민)
     * @param tbContactUsRecord
     * @param model
     * @return String
     */
    @RequestMapping("/admin/contactus/list")
    public String dispContactusList(TbContactUsRecord tbContactUsRecord, Model model) {

        model.addAttribute("contactusList", otherSvc.findAllForContactUsInfo(tbContactUsRecord));
        model.addAttribute("usrNm", tbContactUsRecord.getUsrNm());
        model.addAttribute("companyNm", tbContactUsRecord.getCompanyNm());
        model.addAttribute("subject", tbContactUsRecord.getSubject());

        return prefixPath.concat("/mypage/contactus_list");
    }

    /**
     * ContactUs 상세정보 조회(어드민)
     * @param contactSeq
     * @param model
     * @return String
     */
    @GetMapping("/admin/contactus/detail/{contactSeq}")
    public String dispContactusDetail(@PathVariable("contactSeq") int contactSeq, Model model) {

        // ContactUs 상세정보 조회
        model.addAttribute("contactusInfo", this.otherSvc.findOneForContactUsInfo(contactSeq));
        return prefixPath.concat("/mypage/contactus_detail");
    }

    /**
     * WishList 목록 조회
     * @param tbWishMstRecord
     * @param model
     * @return String
     */
    @RequestMapping("/any/wishlist/list")
    public String dispWishList(TbWishMstRecord tbWishMstRecord, Principal principal, Model model) {
        if(!"admin".equals(principal.getName())){
            tbWishMstRecord.setRegUsrId(principal.getName());
        }else{
            tbWishMstRecord.setRegUsrId("");
        }

        model.addAttribute("wishList", otherSvc.findAllForWishInfo(tbWishMstRecord));

        return prefixPath.concat("/mypage/wish_list");
    }

    /**
     * Inquiry 목록 조회
     * @param tbInquiryMstRecord
     * @param model
     * @return String
     */
    @RequestMapping("/any/inquiry/list")
    public String dispInquiryList(TbInquiryMstRecord tbInquiryMstRecord
            , @RequestParam(value = "schMemId", required = false) String schMemId
            , @RequestParam(value = "schMemNm", required = false) String schMemNm
            , Principal principal
            , Model model) {
        if(!"admin".equals(principal.getName())){
            tbInquiryMstRecord.setRegUsrId(principal.getName());
        }

        model.addAttribute("inquiryList", otherSvc.findAllForInquiryInfo(tbInquiryMstRecord, schMemId, schMemNm));
        model.addAttribute("memInfo", memberSvc.findOneForMemInfo(principal.getName()));

        return prefixPath.concat("/mypage/inquiry_list");
    }

    /**
     * Inquiry 등록 화면
     * @param productSeq
     * @param returnGbn
     * @param model
     * @return String
     */
    @PostMapping("/any/inquiry/register")
    public String dispInquiryRegister(@RequestParam(value = "productSeq") String productSeq, @RequestParam(value = "returnGbn") String returnGbn, Model model) {
        List<Integer> productSeqs = Arrays.stream(productSeq.split(",", -1))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        model.addAttribute("productList", productSvc.findAllForProductInfo(productSeqs));
        model.addAttribute("returnGbn", returnGbn);
        model.addAttribute("returnSeq", productSeq);

        return prefixPath.concat("/other/inquiry_register");
    }

    /**
     * Inquiry 상세정보 조회
     * @param inquirySeq
     * @param model
     * @return String
     */
    @GetMapping("/any/inquiry/detail/{inquirySeq}")
    public String dispInquiryDetail(@PathVariable("inquirySeq") int inquirySeq, Model model) {

        // Inquiry 상세정보 조회_마스터
        model.addAttribute("inquiryInfo", this.otherSvc.findOneForInquiryMstInfo(inquirySeq));
        // Inquiry 상세정보 조회_상세
        model.addAttribute("productList", this.otherSvc.findAllForInquiryDtlInfo(inquirySeq));

        return prefixPath.concat("/mypage/inquiry_detail");
    }

}

