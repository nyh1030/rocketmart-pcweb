package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.*;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.biz.svc.OtherSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import com.rocketmart.pcweb.common.Pagination.Pagination;
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

    @Autowired
    private BrandSvc brandSvc;

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
     * @param tbInquiryDtlRecord
     * @param model
     * @return String
     */
    @RequestMapping("/any/inquiry/list")
    public String dispInquiryList(TbInquiryDtlRecord tbInquiryDtlRecord
            , @RequestParam(value = "schMemId", required = false) String schMemId
            , @RequestParam(value = "schMemNm", required = false) String schMemNm
            , @RequestParam(value = "schProductNm", required = false) String schProductNm
            , Principal principal
            , Model model) {
        if(!"admin".equals(principal.getName())){
            tbInquiryDtlRecord.setRegUsrId(principal.getName());
        }

        model.addAttribute("inquiryList", otherSvc.findAllForInquiryInfo(tbInquiryDtlRecord, schMemId, schMemNm, schProductNm, principal.getName()));
        model.addAttribute("memInfo", memberSvc.findOneForMemInfo(principal.getName()));
        model.addAttribute("memId", schMemId);
        model.addAttribute("memNm", schMemNm);
        model.addAttribute("productNm", schProductNm);

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
     * @param productSeq
     * @param model
     * @return String
     */
    @RequestMapping("/any/inquiry/detail/{productSeq}/{regUsrId}")
    public String dispInquiryDetail(@PathVariable("productSeq") int productSeq, @PathVariable("regUsrId") String regUsrId, Principal principal, Model model) {
        if(!"admin".equals(principal.getName())){
            regUsrId = principal.getName();
        }else if("admin".equals(principal.getName())){

        }

        // Inquiry 상세정보 조회_마스터
        //model.addAttribute("inquiryInfo", this.otherSvc.findOneForInquiryMstInfo(inquirySeq));
        // Inquiry 상세정보 조회_상세
        model.addAttribute("inquiryInfoList", this.otherSvc.findAllForInquiryDtlInfo(productSeq, regUsrId));

        return prefixPath.concat("/mypage/inquiry_detail");
    }

    /**
     * Click Log 목록(어드민)
     * @param tbPrdFobHstRecord
     * @param model
     * @return String
     */
    @RequestMapping("/admin/clicklog/list")
    public String dispContactusList(TbPrdFobHstRecord tbPrdFobHstRecord
            , @RequestParam(value = "schMemId", required = false) String schMemId
            , @RequestParam(value = "schProductNm", required = false) String schProductNm
            , Model model) {

        model.addAttribute("clicklogList", otherSvc.findAllForClickLogInfo(tbPrdFobHstRecord, schMemId, schProductNm));
        model.addAttribute("schMemId", schMemId);
        model.addAttribute("schProductNm", schProductNm);

        return prefixPath.concat("/mypage/clicklog_list");
    }

    /**
     * 브랜드 목록(어드민)
     * @param tbBrandMstRecord
     * @param model
     * @return String
     */
    @RequestMapping("/admin/brand/list")
    public String dispContactusList(TbBrandMstRecord tbBrandMstRecord
            , @RequestParam(value = "schCompanyNm", required = false) String schCompanyNm
            , @RequestParam(value = "schMemId", required = false) String schMemId
            , @RequestParam(value = "schBrandNm", required = false) String schBrandNm
            , @RequestParam(defaultValue = "1") int page
            , Model model) {

        int totalCnt = brandSvc.findAllCnt(schCompanyNm, schMemId, schBrandNm);

        // 생성인자로  총 게시물 수, 현재 페이지를 전달
        Pagination pagination = new Pagination(totalCnt, page);

        // DB select start index
        int startIndex = pagination.getStartIndex();
        // 페이지 당 보여지는 게시글의 최대 개수
        int pageSize = pagination.getPageSize();

        model.addAttribute("adminBrandList", brandSvc.findAllForAdminBrandInfo(schCompanyNm, schMemId, schBrandNm, startIndex, pageSize));
        model.addAttribute("pagination", pagination);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("schCompanyNm", schCompanyNm);
        model.addAttribute("schMemId", schMemId);
        model.addAttribute("schBrandNm", schBrandNm);

        return prefixPath.concat("/mypage/admin_brand_list");
    }

    /**
     * Pending 목록(어드민)
     * @param tbMemMstRecord
     * @param schProductNm
     * @param schBrandNm
     * @param model
     * @return String
     */
    @RequestMapping("/admin/pending/list")
    public String dispPendingList(TbMemMstRecord tbMemMstRecord
            , @RequestParam(value = "schProductNm", required = false) String schProductNm
            , @RequestParam(value = "schBrandNm", required = false) String schBrandNm
            , Model model) {

        model.addAttribute("productList", productSvc.findAllForPending(schProductNm, schBrandNm));
        model.addAttribute("schProductNm", schProductNm);
        model.addAttribute("schBrandNm", schBrandNm);

        return prefixPath.concat("/mypage/pending_list");
    }

}

