package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginCtl {

	private String prefixPath = "fragments/content";

	@Autowired
	private MemberSvc memberSvc;

	// 로그인 페이지
	@GetMapping("/user/signin")
	public String dispSignin() {
		return prefixPath.concat("/user/signin");
	}

	// 회원가입 페이지
	@GetMapping("/user/signup")
	public String dispSignup() {
		return prefixPath.concat("/user/signup");
	}

	// 로그인
	@PostMapping("/any/signin")
	public String execLogin() {
		return "redirect:/";
	}

	// 로그인 결과 페이지
	@GetMapping("/any/signin/result")
	public String dispLoginResult() {
		return prefixPath.concat("/user/loginSuccess");
	}

	// 로그아웃 결과 페이지
	@GetMapping("/any/logout")
	public String dispLogout() {
		return prefixPath.concat("/user/logout");
	}

	// 접근 거부 페이지
	@GetMapping("/any/denied")
	public String dispDenied() {
		return prefixPath.concat("/user/denied");
	}

}
