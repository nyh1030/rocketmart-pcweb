package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
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

	//회원가입
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> saveOneForMemInfo(TbMemMstRecord memberRecord) {
		// 비밀번호 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberRecord.setMemPw(passwordEncoder.encode(memberRecord.getMemPw()));

		int resultCnt = memberRepository.saveOneForMemInfo(memberRecord);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("resultCode", resultCnt > 0 ? "200" : "-1");
		returnMap.put("resultMsg", resultCnt > 0 ? "SUCCESS" : "FAIL");
		return returnMap;
	}

	/**
	 * 회원 정보 조회
	 * @param memId
	 * @return Map<String, Object>
	 */
	public Map<String, Object> findOneForMemInfo(String memId) {
		return this.memberRepository.findOneForMemInfo(memId);
	}
}
