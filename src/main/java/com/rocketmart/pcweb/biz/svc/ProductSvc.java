package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import com.rocketmart.pcweb.biz.dao.repository.ProductRepository;
import com.rocketmart.pcweb.common.api.ApiResponse;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductSvc {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private FileUtils fileUtils;

	public List<Map<String, Object>> findAll() {
		return productRepository.findAll();
	}

	public List<Map<String, Object>> findAllForPending(String schProductNm, String schBrandNm) {
		return productRepository.findAllForPending(schProductNm, schBrandNm);
	}

	public List<Map<String, Object>> findAllByBrand(int brandSeq) {
		return productRepository.findAllByBrand(brandSeq);
	}

	public List<Map<String, Object>> findProductForBrand(int brandSeq) {
		return productRepository.findProductForBrand(brandSeq);
	}

	public Map<String, Object> findByProductSeq(int productSeq) {
		return productRepository.findByProductSeq(productSeq);
	}

	public List<Map<String, Object>> findAllForProductInfo(List<Integer> productSeqs) {
		return productRepository.findAllForProductInfo(productSeqs);
	}

	public List<Map<String, Object>> findFobByProductSeq(int productSeq) {
		return productRepository.findFobByProductSeq(productSeq);
	}

	public Map<String, Object> findFrontAfileByProductSeq(int productSeq) {
		return productRepository.findFrontAfileByProductSeq(productSeq);
	}

	public Map<String, Object> findBackAfileByProductSeq(int productSeq) {
		return productRepository.findBackAfileByProductSeq(productSeq);
	}

	public Map<String, Object> findAspectAfileByProductSeq(int productSeq) {
		return productRepository.findAspectAfileByProductSeq(productSeq);
	}

	public Map<String, Object> findShape1AfileByProductSeq(int productSeq) {
		return productRepository.findShape1AfileByProductSeq(productSeq);
	}

	public Map<String, Object> findShape2AfileByProductSeq(int productSeq) {
		return productRepository.findShape2AfileByProductSeq(productSeq);
	}

	public Map<String, Object> findOutside1AfileByProductSeq(int productSeq) {
		return productRepository.findOutside1AfileByProductSeq(productSeq);
	}

	public Map<String, Object> findOutside2AfileByProductSeq(int productSeq) {
		return productRepository.findOutside2AfileByProductSeq(productSeq);
	}

	public Map<String, Object> findEtc1AfileByProductSeq(int productSeq) {
		return productRepository.findEtc1AfileByProductSeq(productSeq);
	}

	public Map<String, Object> findEtc2AfileByProductSeq(int productSeq) {
		return productRepository.findEtc2AfileByProductSeq(productSeq);
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
	public String saveOneForProductInfo(ProductDto productDto) {
		int fobSaveCnt = 0;

		try {
			int productSaveCnt = productRepository.saveOneForProductInfo(productDto);
			if (productSaveCnt > 0) {
				int productSeq = productRepository.findOneForMaxProductSeq();

				String[] rangeStart = productDto.getRangeStart().split(",", -1);
				String[] rangeEnd = productDto.getRangeEnd().split(",", -1);
				String[] tradingPrice = productDto.getTradingPrice().split(",", -1);
				String[] supplyRate = productDto.getSupplyRate().split(",", -1);
				String[] exposureSupplyRate = productDto.getExposureSupplyRate().split(",", -1);

				int length = rangeStart.length;
				for (int idx = 0; idx < length; idx++) {
					Map<String, Object> paramMap = new HashMap<>();
					paramMap.put("productSeq", productSeq);
					paramMap.put("rangeStart", rangeStart[idx]);
					paramMap.put("rangeEnd", rangeEnd[idx]);
					paramMap.put("tradingPrice", tradingPrice[idx]);
					paramMap.put("supplyRate", supplyRate[idx]);
					paramMap.put("exposureSupplyRate", exposureSupplyRate[idx]);

					fobSaveCnt += productRepository.saveOneForFobInfo(paramMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fobSaveCnt = 0;
		}

		return fobSaveCnt > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}

	@Transactional(rollbackFor = Exception.class)
	public String updateOneForProductInfo(ProductDto productDto) throws Exception {
		int fobSaveCnt = 0;
		try {
			int productSaveCnt = productRepository.updateOneForProductInfo(productDto);
			if (productSaveCnt > 0) {
				List<Integer> delParams = Arrays.stream(productDto.getFobSeq().split(",", -1))
						.map(Integer::parseInt)
						.collect(Collectors.toList());
				int delCnt = productRepository.deleteByFobSeq(delParams);

				if (delCnt > 0) {
					String[] rangeStart = productDto.getRangeStart().split(",", -1);
					String[] rangeEnd = productDto.getRangeEnd().split(",", -1);
					String[] tradingPrice = productDto.getTradingPrice().split(",", -1);
					String[] supplyRate = productDto.getSupplyRate().split(",", -1);
					String[] exposureSupplyRate = productDto.getExposureSupplyRate().split(",", -1);

					int length = rangeStart.length;
					for (int idx = 0; idx < length; idx++) {
						Map<String, Object> paramMap = new HashMap<>();
						paramMap.put("productSeq", productDto.getProductSeq());
						paramMap.put("rangeStart", rangeStart[idx]);
						paramMap.put("rangeEnd", rangeEnd[idx]);
						paramMap.put("tradingPrice", tradingPrice[idx]);
						paramMap.put("supplyRate", supplyRate[idx]);
						paramMap.put("exposureSupplyRate", exposureSupplyRate[idx]);

						fobSaveCnt += productRepository.saveOneForFobInfo(paramMap);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fobSaveCnt = 0;
		}

		return fobSaveCnt > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}

	@Transactional(rollbackFor = Exception.class)
	public String deleteProduct(int productSeq) {
		return productRepository.deleteProduct(productSeq) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}

	public Map<String, Object> findCateInoByCate1Cd(String cate1Cd) {
		return productRepository.findCateInoByCate1Cd(cate1Cd);
	}

	public Map<String, Object> findCateInoByCate2Cd(String cate2Cd) {
		return productRepository.findCateInoByCate2Cd(cate2Cd);
	}

	public Map<String, Object> findCateInoByCate3Cd(String cate3Cd) {
		return productRepository.findCateInoByCate3Cd(cate3Cd);
	}

	public List<Map<String, Object>> findAllForLastestOrder() {
		return productRepository.findAllForLastestOrder();
	}

	public List<Map<String, Object>> findProductListByCateCd(String cateCd) {
		return productRepository.findProductListByCateCd(cateCd);
	}
}
