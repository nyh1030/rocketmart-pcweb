package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.common.file.FileResponse;
import com.rocketmart.pcweb.common.file.FileUtils;
import com.rocketmart.pcweb.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class BrandRestCtl {

	@Autowired
	private BrandSvc brandSvc;

	@Autowired
	private FileUtils fileUtils;

	@PostMapping("/brand/file/upload")
	public ResponseEntity<String> saveBrandFile(MultipartFile file, HttpServletRequest request) {
		return new ResponseEntity<>(fileUtils.uploadFile(file, request), HttpStatus.OK);
	}

	@PostMapping("/brand/info/save")
	public ResponseEntity<String> saveBrandInfo(BrandDto brandDto) {
		return new ResponseEntity<>(brandSvc.saveOneForBrandInfo(brandDto) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

}
