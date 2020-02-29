package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.jooq.tables.records.TbOtherContactUsRecord;
import com.rocketmart.pcweb.biz.svc.OtherSvc;
import com.rocketmart.pcweb.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OtherRestCtl {

	@Autowired
	private OtherSvc otherSvc;

	@PostMapping("/any/other/contactus-info")
	public ResponseEntity<String> saveContactUsInfo(TbOtherContactUsRecord contactUsRecord) {
		return new ResponseEntity<>(otherSvc.saveOneForContactUsInfo(contactUsRecord) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

/*	@GetMapping("/any/other/contactus-info")
	public ResponseEntity<String> saveContactUsInfo(TbOtherContactUsRecord contactUsRecord) {
		return new ResponseEntity<>(otherSvc.saveOneForContactUsInfo(contactUsRecord) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}*/



}
