package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

		List<Map<String, Object>> bsnsList = null;	// List
		Map<String, Object> mmbrMap = null;		// 회원정보 Map
		Map<String, Object> bsnsTypMap = null;	// 사업자유형 Map
		Object bsnsTyp = null;				// 사업자유형
		String[] bsnsTypCds = null;		// 사업자유형 코드 Array
		String[] bsnsTypCdNms = null;	// 사업자유형 코드명 Array
		String[] bsnsChckArr = null;	// 사업자유형 선택 Array
		String role = "";	// 역할
		int indx = 0;

		// 회원정보 조회
		mmbrMap = this.memberRepository.findOneForMemInfo(mmbrId);
		role = String.valueOf(mmbrMap.get("ROLE"));

		if(role.equals("ADMIN")) {	// 관리자

		}else if(role.equals("BUYER")) {	// 구매자

		}else if(role.equals("SELLER")) {	// 판매자

			bsnsTypCds = new String[3];
			bsnsTypCds[0] = "10";
			bsnsTypCds[1] = "20";
			bsnsTypCds[2] = "30";
			bsnsTypCdNms = new String[3];
			bsnsTypCdNms[0] = "제조업자";
			bsnsTypCdNms[1] = "책임판매업자";
			bsnsTypCdNms[2] = "도매/소매 유통업자";

			bsnsList = new ArrayList<Map<String, Object>>();
			bsnsTyp = mmbrMap.get("BSNS_TYPE");	// 사업자유형

			if(bsnsTyp != null) {
				bsnsChckArr = String.valueOf(bsnsTyp).split(",");
			}

			for(int i=0; i<bsnsTypCds.length; i++) {

				bsnsTypMap = new HashMap<String, Object>();
				bsnsTypMap.put("bsnsCd", bsnsTypCds[i]);
				bsnsTypMap.put("bsnsCdNm", bsnsTypCdNms[i]);
				bsnsTypMap.put("chckFlg", false);

				for(int j=0; j<bsnsChckArr.length; j++) {

					if(bsnsTypCds[i].equals(bsnsChckArr[j])) {
						bsnsTypMap.put("chckFlg", true);
						break;
					}
				}

				bsnsList.add(bsnsTypMap);
			}
		}

		mmbrMap.put("bsnsList", bsnsList);


		return mmbrMap;
	}

	/**
	 * 구매자 정보 수정
	 * @param mmbrRcrd
	 * @param nwPw
	 * @return int
	 */
	public int execModifyBuyerInfo(TbMemMstRecord mmbrRcrd, String nwPw) {

		BCryptPasswordEncoder passwordEncoder = null;	// 암호화

		// 비밀번호 입력값 있을경우
		if(!nwPw.isEmpty()) {
			passwordEncoder = new BCryptPasswordEncoder();
			mmbrRcrd.setMemPw(passwordEncoder.encode(nwPw));
		}

		return this.memberRepository.execModifyBuyerInfo(mmbrRcrd);
	}

	/**
	 * 판매자 정보 수정
	 * @param mmbrRcrd
	 * @param nwPw
	 * @return int
	 */
	public int execModifySellerInfo(TbMemMstRecord mmbrRcrd, String nwPw) {

		BCryptPasswordEncoder passwordEncoder = null;	// 암호화

		// 비밀번호 입력값 있을경우
		if(!nwPw.isEmpty()) {
			passwordEncoder = new BCryptPasswordEncoder();
			mmbrRcrd.setMemPw(passwordEncoder.encode(nwPw));
		}

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
	public List<Map<String, Object>> findAllForMemInfo(TbMemMstRecord tbMemMstRecord) {
		return memberRepository.findAllForMemInfo(tbMemMstRecord);

	}
}