package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.dao.repository.ProductRepository;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductSvc {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private FileUtils fileUtils;

	@Transactional(rollbackFor = Exception.class)
	public String saveProductUpload(MultipartFile file, String themaRelmCd, String regMenuPart) {
		return fileUtils.uploadFile(file, themaRelmCd, regMenuPart);
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForProductInfo(ProductDto productDto) {
		return productRepository.saveOneForProductInfo(productDto);
	}
}
