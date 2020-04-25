package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Map;

@Controller
public class ProductCtl {

	@Autowired
	private ProductSvc productSvc;
	@Autowired
	private BrandSvc brandSvc;
	@Autowired
	private MemberSvc memberSvc;

	private String prefixPath = "fragments/content/product";

	@GetMapping("/seller/product_register/{brandSeq}")
	public String productRegister(Model model, @PathVariable(value = "brandSeq") int brandSeq) {
		model.addAttribute("brandInfo", brandSvc.findByBrandSeq(brandSeq));
		model.addAttribute("cate1List", productSvc.findListForCate1());
		model.addAttribute("cate2List", productSvc.findListForCate2());
		model.addAttribute("cate3List", productSvc.findListForCate3());

		return prefixPath.concat("/product_register");
	}

	@GetMapping("/seller/product_modify/{productSeq}")
	public String productModify(Model model, @PathVariable(value = "productSeq") int productSeq) {
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

		return prefixPath.concat("/product_modify");
	}

	@GetMapping("/any/product_detail/{productSeq}")
	public String productDetail(Model model, @PathVariable(value = "productSeq") int productSeq, Principal principal) {
		Map<String, Object> productInfo = productSvc.findByProductSeq(productSeq);

		model.addAttribute("productInfo", productInfo);
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
		model.addAttribute("productCate1", productSvc.findCateInoByCate1Cd((String) productInfo.get("CATE1_CD")));
		model.addAttribute("productCate2", productSvc.findCateInoByCate2Cd((String) productInfo.get("CATE2_CD")));
		model.addAttribute("productCate3", productSvc.findCateInoByCate3Cd((String) productInfo.get("CATE3_CD")));
		model.addAttribute("productSeq", productSeq);

		if(null != principal){
			model.addAttribute("memInfo", memberSvc.findOneForMemInfo(principal.getName()));
			model.addAttribute("memProductInfo", memberSvc.findOneForMemProductInfo(productSeq, principal.getName()));
		}

		return prefixPath.concat("/product_detail");
	}
}
