package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.CategorySvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BrandCtl {

	@Autowired
	private BrandSvc brandSvc;

	@Autowired
	private ProductSvc productSvc;

	@Autowired
	private CategorySvc categorySvc;

	private String prefixPath = "fragments/content/brand";

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
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		model.addAttribute("categoryList", categorySvc.findAll());

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

		model.addAttribute("productList", categorySvc.findAllForCategoryWithBrandPrdInfo(tbCateMstRecord, brandSeq));

		return prefixPath.concat("/brand_detail");
	}

	@GetMapping("/any/brand/list")
	public String brandList(Model model) {
		model.addAttribute("brandMap", brandSvc.findAllForAlPaBet());
		return prefixPath.concat("/brand_list");
	}

}