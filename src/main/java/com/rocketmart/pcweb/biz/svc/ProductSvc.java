package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductSvc {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForProductInfo(ProductDto productDto) {
		return productRepository.saveOneForProductInfo(productDto);
	}
}
