package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductCtl {

	@Autowired
	private ProductSvc productSvc;
	@Autowired
	private BrandSvc brandSvc;

	private String prefixPath = "fragments/content";

	@GetMapping("/seller/product_register/{brandSeq}")
	public String product_register(Model model, @PathVariable(value = "brandSeq") int brandSeq) {
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		model.addAttribute("cate1List", productSvc.findListForCate1());
		model.addAttribute("cate2List", productSvc.findListForCate2());
		model.addAttribute("cate3List", productSvc.findListForCate3());

		return prefixPath.concat("/mypage/product_register");
	}

	@GetMapping("/seller/product_modify/{productSeq}")
	public String product_modify(Model model, @PathVariable(value = "productSeq") int productSeq) {
		model.addAttribute("productInfo", productSvc.findByProductSeq(productSeq));
		model.addAttribute("fobList", productSvc.findFobByProductSeq(productSeq));
		model.addAttribute("productFrontAfile", productSvc.findFrontAfileByProductSeq(productSeq));
		model.addAttribute("productBackAfile", productSvc.findBackAfileByProductSeq(productSeq));
		model.addAttribute("productAspectAfile", productSvc.findAspectAfileByProductSeq(productSeq));
		model.addAttribute("productShape1Afile", productSvc.findShape1AfileByProductSeq(productSeq));
		model.addAttribute("productShape2Afile", productSvc.findShape2AfileByProductSeq(productSeq));
		model.addAttribute("productOutside1Afile", productSvc.findOutside1AfileByProductSeq(productSeq));
		model.addAttribute("productOutside2Afile", productSvc.findOutside2AfileByProductSeq(productSeq));
		model.addAttribute("productEtc1Afile", productSvc.findEtc1AfileByProductSeq(productSeq));
		model.addAttribute("productEtc2Afile", productSvc.findEtc2AfileByProductSeq(productSeq));
		model.addAttribute("cate1List", productSvc.findListForCate1());
		model.addAttribute("cate2List", productSvc.findListForCate2());
		model.addAttribute("cate3List", productSvc.findListForCate3());

		return prefixPath.concat("/mypage/product_modify");
	}
}
