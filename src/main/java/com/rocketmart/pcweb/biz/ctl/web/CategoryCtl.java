package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryCtl {

    @Autowired
    private CategorySvc categorySvc;

    private String prefixPath = "fragments/content";

    /**
     * 메인 > Category 목록 조회
     * @param model
     * @return List<Map<String, Object>>
     */
    @GetMapping("/any/category/list")
    public String dispCategoryList(TbCateMstRecord tbCateMstRecord, Model model) {
        model.addAttribute("cate1_list", categorySvc.findAllForCategoryMenu("1"));
        model.addAttribute("cate2_list", categorySvc.findAllForCategoryMenu("2"));
        model.addAttribute("cate3_list", categorySvc.findAllForCategoryMenu("3"));
        model.addAttribute("cate4_list", categorySvc.findAllForCategoryMenu("4"));
        model.addAttribute("cate5_list", categorySvc.findAllForCategoryMenu("5"));

        return prefixPath.concat("/category/category_list");
    }

}
