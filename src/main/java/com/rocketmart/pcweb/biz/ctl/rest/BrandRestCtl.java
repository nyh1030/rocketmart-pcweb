package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.svc.BrandSvc;
import com.rocketmart.pcweb.common.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Slf4j
@RestController
public class BrandRestCtl {

	@Autowired
	private BrandSvc brandSvc;

	@PostMapping("/seller/brand/file/upload")
	public ResponseEntity<String> saveBrandFile(MultipartFile file, @RequestParam(value = "themaRelmCd") String themaRelmCd, @RequestParam(value = "regMenuPart") String regMenuPart) {
		return new ResponseEntity<>(brandSvc.saveBrandUpload(file, themaRelmCd, regMenuPart), HttpStatus.OK);
	}

	@PostMapping("/seller/brand/info/save")
	public ResponseEntity<String> saveBrandInfo(@RequestBody BrandDto brandDto, Principal principal) {
		brandDto.setRegUsrId(principal.getName());
		brandDto.setUpdUsrId(principal.getName());
		return new ResponseEntity<>(brandSvc.saveOneForBrandInfo(brandDto) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

	@PutMapping("/seller/brand/info/update")
	public ResponseEntity<String> updateBrandInfo(@RequestBody BrandDto brandDto, Principal principal) {
		brandDto.setRegUsrId(principal.getName());
		brandDto.setUpdUsrId(principal.getName());
		return new ResponseEntity<>(brandSvc.updateOneForBrandInfo(brandDto) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

	@DeleteMapping("/seller/brand/{brandSeq}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = "brandSeq") int brandSeq) {
		return new ResponseEntity<>(brandSvc.deleteBrand(brandSeq), HttpStatus.OK);
	}
}
