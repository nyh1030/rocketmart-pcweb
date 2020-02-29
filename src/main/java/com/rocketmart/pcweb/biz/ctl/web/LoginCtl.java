package com.rocketmart.pcweb.biz.ctl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginCtl {

	private String prefixPath = "fragments/content";

	// 로그인 페이지
	@GetMapping("/any/signin")
	public String dispSignin(HttpServletRequest request) {
		String returnUrl;
		if(request.getSession().getAttribute("memInfo") != null){
			returnUrl = "redirect:/";
		}else{
			returnUrl = prefixPath.concat("/user/signin");
		}

		return returnUrl;
	}

	// 로그인 처리
	@GetMapping("/any/signin/result")
	public String execLogin() {
		return "redirect:/";
	}

	// 로그아웃 처리
	@GetMapping("/any/signout/result")
	public String dispLogout() {
		return "redirect:/";
	}

	// 접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return prefixPath.concat("/user/denied");
	}

}
