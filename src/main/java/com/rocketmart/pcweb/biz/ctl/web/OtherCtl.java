package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbPrdMstRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;
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
    @GetMapping("/any/wishlist/list")
    public String dispWishList(TbWishMstRecord tbWishMstRecord, Principal principal, Model model) {
        tbWishMstRecord.setRegUsrId(principal.getName());

        model.addAttribute("wishList", otherSvc.findAllForWishInfo(tbWishMstRecord));

        return prefixPath.concat("/mypage/wish_list");
    }

    @PostMapping("/any/inquiry_register")
    public String dispInquiryRegister(@RequestParam(value = "productSeq") String productSeq, Model model) {
        List<Integer> productSeqs = Arrays.stream(productSeq.split(",", -1))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        model.addAttribute("productList", productSvc.findAllForProductInfo(productSeqs));

        return prefixPath.concat("/other/inquiry_register");
    }

}

