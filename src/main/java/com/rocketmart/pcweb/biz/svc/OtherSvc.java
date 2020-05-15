package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.TbInquiryDtl;
import com.rocketmart.jooq.tables.TbInquiryMst;
import com.rocketmart.jooq.tables.records.*;
import com.rocketmart.pcweb.biz.dao.repository.OtherRepository;
import com.rocketmart.pcweb.common.api.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;

@Slf4j
@AllArgsConstructor
@Service
public class OtherSvc {

	@Autowired
	private OtherRepository otherRepository;

	/**
	 * ContactUs 등록
	 * @param contactUsRecord
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int saveOneForContactUsInfo(TbContactUsRecord contactUsRecord) {
		return otherRepository.saveOneForContactUsInfo(contactUsRecord);
	}

	/**
	 * ContactUs 목록 조회
	 * @param tbContactUsRecord
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForContactUsInfo(TbContactUsRecord tbContactUsRecord, int startIndex, int pageSize) {
		return otherRepository.findAllForContactUsInfo(tbContactUsRecord, startIndex, pageSize);
	}

	/**
	 * ContactUs 상세정보 조회
	 * @param contactSeq
	 * @return Map<String, Object>
	 */
	public Map<String, Object> findOneForContactUsInfo(int contactSeq) {
		return otherRepository.findOneForContactUsInfo(contactSeq);
	}

	/**
	 * WishList 등록 중복 체크
	 * @param tbWishMstRecord
	 * @return boolean
	 *
	 * Y면 중복상품 존재, N이면 중복상품 없음
	 */
	public boolean wishInfoOverLapChk(TbWishMstRecord tbWishMstRecord) {
		return this.otherRepository.wishInfoOverLapChk(tbWishMstRecord);
	}

	/**
	 * WishList 등록
	 * @param tbWishMstRecord
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int saveOneForWishListInfo(TbWishMstRecord tbWishMstRecord) {
		return otherRepository.saveOneForWishListInfo(tbWishMstRecord);
	}

	/**
	 * WishList 삭제
	 * @param tbWishMstRecord
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int deleteWishListInfo(TbWishMstRecord tbWishMstRecord) {
		return otherRepository.deleteWishListInfo(tbWishMstRecord);
	}

	/**
	 * WishList 목록 조회
	 * @param tbWishMstRecord
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForWishInfo(TbWishMstRecord tbWishMstRecord) {
		return otherRepository.findAllForWishInfo(tbWishMstRecord);
	}

	/**
	 * Inquiry 목록 조회
	 * @param tbInquiryDtlRecord
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForInquiryInfo(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm, String usrName, int startIndex, int pageSize) {
		if(usrName.equals("admin")){
			return otherRepository.findAllForAdminInquiryInfo(tbInquiryDtlRecord, schMemId, schMemNm, schProductNm, startIndex, pageSize);
		}else{
			return otherRepository.findAllForInquiryInfo(tbInquiryDtlRecord, schMemId, schMemNm, schProductNm, startIndex, pageSize);
		}
	}

	/**
	 * Inquiry 등록
	 * @param tbInquiryDtlRecord
	 * @param productSeqArr
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public String saveInquiryInfo(TbInquiryDtlRecord tbInquiryDtlRecord, List<Integer> productSeqArr) {
		int resultMstSeq = 0;
		int resultDtlCnt = 0;
		int resultWishCnt = 0;
/*		TbInquiryMstRecord inquiryMstRecord = otherRepository.saveOneForInquiryMstInfo(tbInquiryMstRecord);
		resultMstSeq = inquiryMstRecord.getInquirySeq();

		if (resultMstSeq > 0){
			TbInquiryDtlRecord tbInquiryDtlRecord = new TbInquiryDtlRecord();
			tbInquiryDtlRecord.setInquirySeq(resultMstSeq);
			tbInquiryDtlRecord.setRegUsrId(tbInquiryMstRecord.getRegUsrId());

			for(Integer productSeq : productSeqs){
				tbInquiryDtlRecord.setProductSeq(productSeq);
				resultDtlCnt += otherRepository.saveAllForInquiryDtlInfo(tbInquiryDtlRecord);
				if(resultDtlCnt > 0){
					resultWishCnt += otherRepository.updateOneForWishInfo(tbInquiryDtlRecord, productSeq);
				}
			}

		}*/
		for(Integer productSeq : productSeqArr){
			tbInquiryDtlRecord.setProductSeq(productSeq);
			resultDtlCnt += otherRepository.saveAllForInquiryDtlInfo(tbInquiryDtlRecord);
			if(resultDtlCnt > 0){
				resultWishCnt += otherRepository.updateOneForWishInfo(tbInquiryDtlRecord, productSeq);
			}
		}

		return resultDtlCnt > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}

	/**
	 * Inquiry 상세정보 조회_마스터
	 * @param inquirySeq
	 * @return Map<String, Object>
	 */
	public Map<String, Object> findOneForInquiryMstInfo(int inquirySeq) {
		return otherRepository.findOneForInquiryMstInfo(inquirySeq);
	}

	/**
	 * Inquiry 상세정보 조회_상세
	 * @param productSeq, regUsrId
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForInquiryDtlInfo(int productSeq, String regUsrId) {
		return otherRepository.findAllForInquiryDtlInfo(productSeq, regUsrId);
	}

	/**
	 * Click Log 목록(어드민)
	 * @param tbPrdFobHstRecord
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForClickLogInfo(TbPrdFobHstRecord tbPrdFobHstRecord, String schMemId, String schProductNm) {
		return otherRepository.findAllForClickLogInfo(tbPrdFobHstRecord, schMemId, schProductNm);
	}

	/**
	 * Click Log 등록(상품 가격 조회 이력 등록)
	 * @param tbPrdFobHstRecord
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int saveOneForClickLogInfo(TbPrdFobHstRecord tbPrdFobHstRecord) {
		return otherRepository.saveOneForClickLogInfo(tbPrdFobHstRecord);
	}

	/**
	 * Contact Us 회신여부 변경
	 * @param contactSeq
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateContactUsReplyYn(int contactSeq) {
		return otherRepository.updateContactUsReplyYn(contactSeq);
	}

	/**
	 * Inquiry 회신여부 변경
	 * @param inquiryDtlSeq
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateInquiryReplyYn(int inquiryDtlSeq) {
		return otherRepository.updateInquiryReplyYn(inquiryDtlSeq);
	}

	public int findContactUsCnt(TbContactUsRecord tbContactUsRecord) {
		return otherRepository.findContactUsCnt(tbContactUsRecord);
	}

	public int findInquiryCnt(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm, String usrName) {
		if(usrName.equals("admin")){
			return otherRepository.findAllForAdminInquiryInfoCnt(tbInquiryDtlRecord, schMemId, schMemNm, schProductNm);
		}else{
			return otherRepository.findAllForInquiryInfoCnt(tbInquiryDtlRecord, schMemId, schMemNm, schProductNm);
		}
	}
}