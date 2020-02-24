package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import com.rocketmart.pcweb.biz.dao.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class MemberSvc {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public Map<String, Object> saveOneForMemInfo(MemberDto memberDto) {
		// 비밀번호 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDto.setMemPw(passwordEncoder.encode(memberDto.getMemPw()));

		int resultCnt = memberRepository.saveOneForMemInfo(memberDto);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("resultCode", resultCnt > 0 ? "200" : "-1");
		returnMap.put("resultMsg", resultCnt > 0 ? "SUCCESS" : "FAIL");
		return returnMap;		
	}
}
