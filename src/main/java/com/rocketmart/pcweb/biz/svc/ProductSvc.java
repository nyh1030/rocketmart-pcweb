package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.dao.repository.ProductRepository;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductSvc {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private FileUtils fileUtils;

	public List<Map<String, Object>> findProductForBrand(int brandSeq) {
		return productRepository.findProductForBrand(brandSeq);
	}

	public List<Map<String, Object>> findListForCate1() {
		return productRepository.findListForCate1();
	}

	public List<Map<String, Object>> findListForCate2() {
		return productRepository.findListForCate2();
	}

	public List<Map<String, Object>> findListForCate3() {
		return productRepository.findListForCate3();
	}

	@Transactional(rollbackFor = Exception.class)
	public String saveProductUpload(MultipartFile file, String themaRelmCd, String regMenuPart) {
		return fileUtils.uploadFile(file, themaRelmCd, regMenuPart);
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForProductInfo(ProductDto productDto) {
		int wholeSaleSaveCnt = 0;
		int productSaveCnt = productRepository.saveOneForProductInfo(productDto);
		if (productSaveCnt > 0) {
			int productSeq = productRepository.findOneForMaxProductSeq();

			String[] rangeStart = productDto.getRangeStart().split(",", -1);
			String[] rangeEnd = productDto.getRangeEnd().split(",", -1);
			String[] tradingPrice = productDto.getTradingPrice().split(",", -1);
			String[] supplyRate = productDto.getSupplyRate().split(",", -1);

			int length = rangeStart.length;
			for (int idx = 0; idx < length; idx++) {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("productSeq", productSeq);
				paramMap.put("rangeStart", rangeStart[idx]);
				paramMap.put("rangeEnd", rangeEnd[idx]);
				paramMap.put("tradingPrice", tradingPrice[idx]);
				paramMap.put("supplyRate", supplyRate[idx]);

				wholeSaleSaveCnt += productRepository.saveOneForWholeSaleInfo(paramMap);
			}
		}

		return wholeSaleSaveCnt;
	}
}
