package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.pcweb.biz.svc.OtherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherCtl {

    private String prefixPath = "fragments/content";

    @Autowired
    private OtherSvc otherSvc;

    // contactUs 등록 페이지
    @GetMapping("/any/contactus/register")
    public String dispContactUs() {
        return prefixPath.concat("/other/contactUs_register");
    }

    //contactus 목록(어드민)
    @RequestMapping("/admin/contactus/list")
    public String dispContactusList(TbContactUsRecord tbContactUsRecord, Model model) {

        model.addAttribute("contactusList", otherSvc.findAllForContactUsInfo(tbContactUsRecord));
        model.addAttribute("usrNm", tbContactUsRecord.getUsrNm());
        model.addAttribute("companyNm", tbContactUsRecord.getCompanyNm());
        model.addAttribute("subject", tbContactUsRecord.getSubject());

        return prefixPath.concat("/mypage/contactUs_list");
    }

}

