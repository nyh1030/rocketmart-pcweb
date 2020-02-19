package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.MemberDto;
import com.rocketmart.pcweb.biz.dao.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberSvc {

	@Autowired
	private MemberRepository memberMapper;

	@Transactional
	public void saveOneForMem(MemberDto memberDto) {
		// 비밀번호 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDto.setMemPw(passwordEncoder.encode(memberDto.getMemPw()));

		memberMapper.saveOneForMem(memberDto);
	}
}
