package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class BrandSvc {

	@Autowired
	private BrandRepository brandRepository;

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> saveOneForBrandInfo(BrandDto brandDto) {
		int resultCnt = brandRepository.saveOneForBrandInfo(brandDto);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("resultCode", resultCnt > 0 ? "200" : "-1");
		returnMap.put("resultMsg", resultCnt > 0 ? "SUCCESS" : "FAIL");
		return returnMap;
	}
}