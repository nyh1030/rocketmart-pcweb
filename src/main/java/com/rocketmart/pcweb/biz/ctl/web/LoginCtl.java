package com.rocketmart.pcweb.biz.ctl.web;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginCtl {

	@Autowired
	private MemberSvc memberSvc;

	private String prefixPath = "fragments/content";

	// 로그인 페이지
	@GetMapping("/user/signin")
	public String dispSignin(HttpServletRequest request) {
		String returnUrl = "";
		if(request.getSession().getAttribute("memInfo") != null){
			returnUrl = "redirect:/";
		}else{
			returnUrl = prefixPath.concat("/user/signin");
		}

		return returnUrl;
	}

	// 로그인 처리
	@GetMapping("/user/signin/result")
	public String execLogin(Authentication authentication, Model model) {
		return "redirect:/";
	}

	// 로그아웃 처리
	@GetMapping("/user/signout/result")
	public String dispLogout() {
		return "redirect:/";
	}

	// 접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return prefixPath.concat("/user/denied");
	}

}
