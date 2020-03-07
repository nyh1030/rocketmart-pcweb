package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class BrandCtl {

	@Autowired
	private BrandSvc brandSvc;

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

	@GetMapping("/seller/brand_detail/{brandSeq}")
	public String brandDetail(Model model, @PathVariable(value = "brandSeq") int brandSeq) {
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		return prefixPath.concat("/brand_detail");
	}

	@GetMapping("/any/brand/list")
	public String dispBrandList() {
		return prefixPath.concat("/brand_list");
	}
}