package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CategoryCtl {

    @Autowired
    private CategorySvc categorySvc;

    @Autowired
    private ProductSvc productSvc;

    private String prefixPath = "fragments/content";

    /**
     * 메인 > Category 목록 조회
     * @param model
     * @return List<Map<String, Object>>
     */
    @GetMapping({"/any/category/list", "/any/category/list/{depth}/{cateCd}"})
    public String dispCategoryList(TbCateMstRecord tbCateMstRecord
            , @PathVariable("depth") Optional<String> depth
            , @PathVariable("cateCd") Optional<String> cateCd
            , Model model) {
/*        model.addAttribute("cate1CdList", categorySvc.findAllForCategoryMenu("1"));
        model.addAttribute("cate2CdList", categorySvc.findAllForCategoryMenu("2"));
        model.addAttribute("cate3CdList", categorySvc.findAllForCategoryMenu("3"));
        model.addAttribute("cate4CdList", categorySvc.findAllForCategoryMenu("4"));
        model.addAttribute("cate5CdList", categorySvc.findAllForCategoryMenu("5"));*/

        if (depth.isPresent() && cateCd.isPresent()) {
            if ("1".equals(depth.get())) {
                tbCateMstRecord.setCate1Cd(cateCd.get());
            } else if ("2".equals(depth.get())) {
                tbCateMstRecord.setCate2Cd(cateCd.get());
            } else if ("3".equals(depth.get())) {
                tbCateMstRecord.setCate3Cd(cateCd.get());
            } else{
                tbCateMstRecord.setCate1Cd("1");
            }
        }else{
            tbCateMstRecord.setCate1Cd("1");
        }

        List<Map<String, Object>> categoryList = categorySvc.findAll();
        model.addAttribute("category1Depth", categoryList.stream().map(category -> category.get("CATE1_CD")).collect(Collectors.toList()));
        model.addAttribute("category2Depth", categoryList.stream().map(category -> category.get("CATE2_CD")).collect(Collectors.toList()));
        model.addAttribute("categoryList", categoryList);

        if (depth.isPresent() && cateCd.isPresent()) {
            List<Map<String, Object>> productList = categorySvc.findAllForCategoryPrdInfo(tbCateMstRecord);
            model.addAttribute("productList", productList);
            if (!productList.isEmpty()) {
                if ("1".equals(depth.get())) {
                    model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
                } else if ("2".equals(depth.get())) {
                    model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
                    model.addAttribute("productCate2", productSvc.findCateInoByCate2Cd((String) productList.get(0).get("CATE2_CD")));
                } else if ("3".equals(depth.get())) {
                    model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
                    model.addAttribute("productCate2", productSvc.findCateInoByCate2Cd((String) productList.get(0).get("CATE2_CD")));
                    model.addAttribute("productCate3", productSvc.findCateInoByCate3Cd((String) productList.get(0).get("CATE3_CD")));
                }
            }
        } else {
            model.addAttribute("productList", productSvc.findAll());
        }

        model.addAttribute("depth", depth.orElse(""));
        model.addAttribute("cateCd", cateCd.orElse(""));

        return prefixPath.concat("/category/category_list");
    }

}
