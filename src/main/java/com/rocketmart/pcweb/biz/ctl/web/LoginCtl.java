package com.rocketmart.pcweb.biz.ctl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginCtl {

	private String prefixPath = "fragments/content";

	/**
	 * 로그인 페이지
	 * @param principal
	 * @return String
	 */
	@GetMapping("/any/signin")
	public String dispSignin(Principal principal) {
		String returnUrl;
		if(null != principal){
			returnUrl = "redirect:/";
		}else{
			returnUrl = prefixPath.concat("/user/signin");
		}

		return returnUrl;
	}

	/**
	 * 로그인 처리
	 * @return String
	 */
	@GetMapping("/any/signin/result")
	public String execLogin() {
		return "redirect:/";
	}

	/**
	 * 로그아웃 처리
	 * @return String
	 */
	@GetMapping("/any/signout/result")
	public String dispLogout() {
		return "redirect:/";
	}

	/**
	 * 접근 거부 페이지
	 * @return String
	 */
	@GetMapping("/user/denied")
	public String dispDenied() {
		return prefixPath.concat("/user/denied");
	}

}
