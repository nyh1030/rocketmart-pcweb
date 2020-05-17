package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import com.rocketmart.pcweb.common.Pagination.Pagination;
import com.rocketmart.pcweb.common.Pagination.PaginationImagePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
            , @RequestParam(defaultValue = "1") int page
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
            int totalCnt = categorySvc.findCategoryPrdInfoCnt(tbCateMstRecord);

            // 생성인자로  총 게시물 수, 현재 페이지를 전달
            PaginationImagePage pagination = new PaginationImagePage(totalCnt, page);

            // DB select start index
            int startIndex = pagination.getStartIndex();
            // 페이지 당 보여지는 게시글의 최대 개수
            int pageSize = pagination.getPageSize();

            List<Map<String, Object>> productList = categorySvc.findAllForCategoryPrdInfo(tbCateMstRecord, startIndex, pageSize);
            model.addAttribute("productList", productList);
            model.addAttribute("pagination", pagination);
            model.addAttribute("totalCnt", totalCnt);
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
            int totalCnt = productSvc.findCategoryPrdCnt();

            // 생성인자로  총 게시물 수, 현재 페이지를 전달
            PaginationImagePage pagination = new PaginationImagePage(totalCnt, page);

            // DB select start index
            int startIndex = pagination.getStartIndex();
            // 페이지 당 보여지는 게시글의 최대 개수
            int pageSize = pagination.getPageSize();

            model.addAttribute("productList", productSvc.findCategoryPrdAll(startIndex, pageSize));
            model.addAttribute("pagination", pagination);
            model.addAttribute("totalCnt", totalCnt);
        }

        model.addAttribute("depth", depth.orElse(""));
        model.addAttribute("cateCd", cateCd.orElse(""));

        return prefixPath.concat("/category/category_list");
    }

}
