package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCtl {

	@Autowired
	private ProductSvc productSvc;
	@Autowired
	private BrandSvc brandSvc;

	private String prefixPath = "fragments/content";

	@GetMapping("/seller/product_register")
	public String product_register(Model model) {
		model.addAttribute("brandList", brandSvc.findBrandByUsrId());
		model.addAttribute("cate1List", productSvc.findListForCate1());
		model.addAttribute("cate2List", productSvc.findListForCate2());
		model.addAttribute("cate3List", productSvc.findListForCate3());

		return prefixPath.concat("/mypage/product_register");
	}
}
