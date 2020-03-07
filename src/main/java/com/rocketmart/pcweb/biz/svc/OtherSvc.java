package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.TbInquiryDtl;
import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbInquiryDtlRecord;
import com.rocketmart.jooq.tables.records.TbInquiryMstRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;
import com.rocketmart.pcweb.biz.dao.repository.OtherRepository;
import com.rocketmart.pcweb.common.api.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

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
	public List<Map<String, Object>> findAllForContactUsInfo(TbContactUsRecord tbContactUsRecord) {
		return otherRepository.findAllForContactUsInfo(tbContactUsRecord);
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
	 * WishList 목록 조회
	 * @param tbWishMstRecord
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForWishInfo(TbWishMstRecord tbWishMstRecord) {
		return otherRepository.findAllForWishInfo(tbWishMstRecord);
	}

	/**
	 * Inquiry 등록
	 * @param tbInquiryMstRecord
	 * @param productSeqs
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public String saveInquiryInfo(TbInquiryMstRecord tbInquiryMstRecord, List<Integer> productSeqs) {
		int resultMstSeq = 0;
		int resultDtlCnt = 0;
		int resultWishCnt = 0;
		TbInquiryMstRecord inquiryMstRecord = otherRepository.saveOneForInquiryMstInfo(tbInquiryMstRecord);
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

		}

		return resultDtlCnt > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}
}