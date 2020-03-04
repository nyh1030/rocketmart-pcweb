package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.svc.ProductSvc;
import com.rocketmart.pcweb.common.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class ProductRestCtl {

	@Autowired
	private ProductSvc productSvc;

	@GetMapping("/seller/product/list/{brandSeq}")
	public ResponseEntity<List<Map<String, Object>>> findProductForBrand(@PathVariable(value = "brandSeq") int brandSeq) {
		return new ResponseEntity<>(productSvc.findProductForBrand(brandSeq), HttpStatus.OK);
	}

	@PostMapping("/seller/product/file/upload")
	public ResponseEntity<String> saveProductFile(MultipartFile file, @RequestParam(value = "themaRelmCd") String themaRelmCd, @RequestParam(value = "regMenuPart") String regMenuPart) {
		return new ResponseEntity<>(productSvc.saveProductUpload(file, themaRelmCd, regMenuPart), HttpStatus.OK);
	}

	@PostMapping("/seller/product/info/save")
	public ResponseEntity<String> saveProductInfo(ProductDto productDto) {
		return new ResponseEntity<>(productSvc.saveOneForProductInfo(productDto) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
	}

	@PostMapping("/seller/product/copy/{productSeq}")
	public ResponseEntity<String> product_copy(@PathVariable(value = "productSeq") int productSeq) {
		return new ResponseEntity<>(productSvc.copyProduct(productSeq), HttpStatus.OK);
	}

	@DeleteMapping("/seller/product/{productSeq}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = "productSeq") int productSeq) {
		return new ResponseEntity<>(productSvc.deleteProduct(productSeq), HttpStatus.OK);
	}
}
