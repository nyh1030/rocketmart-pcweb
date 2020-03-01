package com.rocketmart.pcweb.biz.ctl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCtl {

	private String prefixPath = "fragments/content";

	@GetMapping("/seller/product_register")
	public String product_register() {
		return prefixPath.concat("/mypage/product_register");
	}
}
