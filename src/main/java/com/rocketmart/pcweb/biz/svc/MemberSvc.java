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
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class MemberSvc {

	@Autowired
	private MemberRepository memberRepository;


	/**
	 * 회원중복 체크
	 * @param memId
	 * @return int
	 *
	 * Y면 중복아이디 존재, N이면 중복아이디 없음(회원가입가능)
	 */
	public boolean idOverLapChk(String memId) {
		return this.memberRepository.idOverLapChk(memId);
	}

	/**
	 * 회원 가입
	 * @param memberRecord
	 * @return int
	 */
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
	 * @param mmbrId
	 * @return mmbrMap
	 */
	public Map<String, Object> findOneForMemInfo(String mmbrId) {

		Map<String, Object> mmbrMap = null;		// 회원정보 Map
		Object bsnsTyp = null;				// 사업자유형
		String[] bsnsTypCdArr = null;		// 사업자유형 코드 Array
		String[] bsnsTypNmArr = null;		//  사업자유형 코드명 Array
		String role = "";	// 역할
		int indx = 0;

		// 회원정보 조회
		mmbrMap = this.memberRepository.findOneForMemInfo(mmbrId);
		role = String.valueOf(mmbrMap.get("ROLE"));

		if(role.equals("admin")) {	// 관리자

		}else if(role.equals("buyer")) {	// 구매자

		}else if(role.equals("seller")) {	// 판매자

			bsnsTyp = mmbrMap.get("BSNS_TYPE");	// 사업자유형

			if(bsnsTyp != null) {

				bsnsTypCdArr = String.valueOf(bsnsTyp).split(",");
				bsnsTypNmArr = new String[bsnsTypCdArr.length];

				for(String typCd : bsnsTypCdArr) {

					if (typCd.equals("10")) {
						bsnsTypNmArr[indx] = "- 제조업";
					} else if (typCd.equals("20")) {
						bsnsTypNmArr[indx] = "- 책임판매업";
					} else if (typCd.equals("30")) {
						bsnsTypNmArr[indx] = "- 도매/소매 유통업자";
					}

					indx++;
				}

				mmbrMap.put("bsnsTyps", bsnsTypNmArr);	// 사업자유형 저장
			}
		}

		return mmbrMap;
	}

	/**
	 * 판매자 정보 수정
	 * @param mmbrRcrd
	 * @return int
	 */
	public int execModifySellerInfo(TbMemMstRecord mmbrRcrd) {
		return this.memberRepository.execModifySellerInfo(mmbrRcrd);
	}

	/**
	 * 회원 승인 처리
	 * @param mmbrId
	 * @param flag
	 * @return retMsg
	 */
	public String execApprovalMember(String mmbrId, String flag) {

		String retMsg = "";        // Return Message
		int ret = 0;

		try {

			// 회원 승인 처리
			ret = memberRepository.execApprovalMemInfo(mmbrId, flag);

			System.out.println(" ::::: " + ret);

			if(ret > 0) {
				retMsg = "Success";
			}else {
				retMsg = "Failed";
			}
		}catch(Exception e) {

			retMsg = "Error";
		}

		return retMsg;
	}

	/**
	 * 회원 목록 조회
	 * @param
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForMemInfo() {
		return memberRepository.findAllForMemInfo();

	}
}