package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class BrandRestCtl {

	@Autowired
	private BrandSvc brandSvc;

	@PostMapping("/brand/info/save")
	public ResponseEntity<Map<String, Object>> saveBrandInfo(BrandDto brandDto) {
		return new ResponseEntity<>(brandSvc.saveOneForBrandInfo(brandDto), HttpStatus.OK);
	}

}
