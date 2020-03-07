package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;
import com.rocketmart.pcweb.biz.svc.OtherSvc;
import com.rocketmart.pcweb.common.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
public class OtherRestCtl {

	@Autowired
	private OtherSvc otherSvc;

	/**
	 * Contactus 등록
	 * @param contactUsRecord
	 * @return ResponseEntity<String>
	 */
	@PostMapping("/any/rest/contactus/info/save")
	public ResponseEntity<String> saveContactUsInfo(TbContactUsRecord contactUsRecord) {
		return new ResponseEntity<>(otherSvc.saveOneForContactUsInfo(contactUsRecord) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

	/**
	 * wishlist 등록
	 * @param tbWishMstRecord
	 * @return ResponseEntity<String>
	 */
	@PostMapping("/any/rest/wishlist/info/save")
	public ResponseEntity<String> saveOneForWishListInfo(TbWishMstRecord tbWishMstRecord, Principal principal) {
		int resultCnt = 0;

		tbWishMstRecord.setRegUsrId(principal.getName());

		//중복이면 실패, 중복없으면 등록
		resultCnt = otherSvc.wishInfoOverLapChk(tbWishMstRecord) ? 0 : otherSvc.saveOneForWishListInfo(tbWishMstRecord);

		return new ResponseEntity<>(resultCnt > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

}
