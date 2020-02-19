package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginSvc {

	@Autowired
	private MemberRepository memberMapper;

	public void insertMemberInfo() {
		memberMapper.saveOneForMem();
	}
}
