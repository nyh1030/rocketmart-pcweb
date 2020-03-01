package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCtl {

	@Autowired
	private BrandSvc brandSvc;

	private String prefixPath = "fragments/content";

	@GetMapping("/seller/product_register")
	public String product_register(Model model) {
		model.addAttribute("brandInfo", brandSvc.findBrandByUsrId());

		return prefixPath.concat("/mypage/product_register");
	}
}
