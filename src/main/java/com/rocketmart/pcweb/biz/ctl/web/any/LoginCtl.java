package com.rocketmart.pcweb.biz.ctl.web.any;

import com.rocketmart.pcweb.biz.svc.MemberSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/any/login")
public class LoginCtl {

	private String prefixPath = "fragments/content";

	@Autowired
	private MemberSvc memberSvc;

	// 로그인 페이지
	@GetMapping("/signin")
	public String dispLogin() {
		return prefixPath.concat("/login/signin");
	}

	// 로그인
	@PostMapping("/login")
	public String execLogin() {
		return "redirect:/";
	}

	// 로그인 결과 페이지
	@GetMapping("/login/result")
	public String dispLoginResult() {
		return prefixPath.concat("/login/loginSuccess");
	}

	// 로그아웃 결과 페이지
	@GetMapping("/logout/result")
	public String dispLogout() {
		return prefixPath.concat("/login/logout");
	}

	// 접근 거부 페이지
	@GetMapping("/denied")
	public String dispDenied() {
		return prefixPath.concat("/login/denied");
	}

}
