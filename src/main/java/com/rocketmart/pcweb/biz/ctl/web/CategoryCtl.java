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
    public String dispCategoryList(Model model) {

        model.addAttribute("cateMenuList", categorySvc.findAllForCategoryMenu());

        return prefixPath.concat("/category/category_list");
    }

}
