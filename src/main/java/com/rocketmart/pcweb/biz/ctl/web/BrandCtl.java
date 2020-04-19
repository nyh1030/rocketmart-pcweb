package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BrandCtl {

	@Autowired
	private BrandSvc brandSvc;

	@Autowired
	private ProductSvc productSvc;

	@Autowired
	private CategorySvc categorySvc;

	@Autowired
	private MemberSvc memberSvc;

	private String prefixPath = "fragments/content/brand";

	@GetMapping("/seller/mypage")
	public String mypage(Principal principal) {
		Map<String, Object> memInfo = memberSvc.findOneForMemInfo(principal.getName());
		if("Y".equals(memInfo.get("APPROVAL_YN"))){
			return "redirect:/seller/brand_add";
		}else{
			return "redirect:/seller/seller_detail";
		}
	}

	@GetMapping("/seller/brand_add")
	public String brandAdd(Model model, Principal principal) {
		model.addAttribute("brandList", brandSvc.findAllForAfile(principal.getName()));
		model.addAttribute("updateDateTime", brandSvc.findLastUpdatedDateTime(principal.getName()));
		return prefixPath.concat("/brand_add");
	}

	@GetMapping("/seller/brand_register")
	public String brandRegister(Model model) {
		return prefixPath.concat("/brand_register");
	}

	@GetMapping("/seller/brand_modify/{brandSeq}")
	public String brandModify(Model model, @PathVariable(value = "brandSeq") int brandSeq) {
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		return prefixPath.concat("/brand_modify");
	}

	@GetMapping("/any/brand_detail/{brandSeq}")
	public String brandDetail(TbCateMstRecord tbCateMstRecord, Model model,
	                          @PathVariable(value = "brandSeq")  int brandSeq, @RequestParam(value = "depth", required = false) String depth,
	                          @RequestParam(value = "cateCd", required = false) String cateCd) {

		List<Map<String, Object>> categoryList = categorySvc.findAllByBrandSeq(brandSeq);
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		model.addAttribute("category1Depth", categoryList.stream().map(category -> category.get("CATE1_CD")).collect(Collectors.toList()));
		model.addAttribute("category2Depth", categoryList.stream().map(category -> category.get("CATE2_CD")).collect(Collectors.toList()));
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("depth", depth);
		model.addAttribute("cateCd", cateCd);

		if (!StringUtils.isEmpty(depth) && !StringUtils.isEmpty(cateCd)) {
			if ("1".equals(depth)) {
				tbCateMstRecord.setCate1Cd(cateCd);
			} else if ("2".equals(depth)) {
				tbCateMstRecord.setCate2Cd(cateCd);
			} else if ("3".equals(depth)) {
				tbCateMstRecord.setCate3Cd(cateCd);
			} else {
				tbCateMstRecord.setCate1Cd("1");
			}
		} else {
			tbCateMstRecord.setCate1Cd("1");
		}

		if (!StringUtils.isEmpty(depth) && !StringUtils.isEmpty(cateCd)) {
			List<Map<String, Object>> productList = categorySvc.findAllForCategoryWithBrandPrdInfo(tbCateMstRecord, brandSeq);
			model.addAttribute("productList", productList);
			if (!productList.isEmpty()) {
				if ("1".equals(depth)) {
					model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
				} else if ("2".equals(depth)) {
					model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
					model.addAttribute("productCate2", productSvc.findCateInoByCate2Cd((String) productList.get(0).get("CATE2_CD")));
				} else if ("3".equals(depth)) {
					model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productList.get(0).get("CATE1_CD")));
					model.addAttribute("productCate2", productSvc.findCateInoByCate2Cd((String) productList.get(0).get("CATE2_CD")));
					model.addAttribute("productCate3", productSvc.findCateInoByCate3Cd((String) productList.get(0).get("CATE3_CD")));
				}
			}
		} else {
			model.addAttribute("productList", productSvc.findAllByBrand(brandSeq));
		}

		return prefixPath.concat("/brand_detail");
	}

	@GetMapping("/any/brand/list")
	public String brandList(Model model) {
		model.addAttribute("brandMap", brandSvc.findAllForAlPaBet());
		return prefixPath.concat("/brand_list");
	}

}