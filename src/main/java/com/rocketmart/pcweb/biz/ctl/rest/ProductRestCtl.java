package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import com.rocketmart.pcweb.common.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductRestCtl {

	@Autowired
	private ProductSvc productSvc;

	@PostMapping("/seller/product/file/upload")
	public ResponseEntity<String> saveProductFile(MultipartFile file, @RequestParam(value = "themaRelmCd") String themaRelmCd, @RequestParam(value = "regMenuPart") String regMenuPart) {
		return new ResponseEntity<>(productSvc.saveProductUpload(file, themaRelmCd, regMenuPart), HttpStatus.OK);
	}

	@PostMapping("/seller/product/info/save")
	public ResponseEntity<String> saveProductInfo(ProductDto productDto) {
		return new ResponseEntity<>(productSvc.saveOneForProductInfo(productDto) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}
}
