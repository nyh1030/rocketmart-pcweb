package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class BrandCtl {

	@Autowired
	private BrandSvc brandSvc;

	private String prefixPath = "fragments/content";

	@GetMapping("/seller/brand_add")
	public String brand_add(Model model) {
		model.addAttribute("brandList", brandSvc.findAllForAfile());
		return prefixPath.concat("/mypage/brand_add");
	}

	@GetMapping("/seller/brand_register")
	public String brand_register(Model model) {
		return prefixPath.concat("/mypage/brand_register");
	}

	@GetMapping("/seller/brand_modify/{brandSeq}")
	public String brand_register(Model model, @PathVariable(value = "brandSeq") int brandSeq) {
		Map<String, Object> brandInfo =	brandSvc.findByBrandSeq(brandSeq);
		model.addAttribute("brandInfo", brandInfo);
		return prefixPath.concat("/mypage/brand_register");
	}

	@GetMapping("/seller/brand_detail")
	public String brand_detail() {
		return prefixPath.concat("/mypage/brand_detail");
	}
}
