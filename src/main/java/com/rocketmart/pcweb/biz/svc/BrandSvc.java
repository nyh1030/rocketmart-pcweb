package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BrandSvc {

	@Autowired
	private BrandRepository brandRepository;

	public List<Map<String, Object>> findAllForAfile() {
		return brandRepository.findAllForAfile();
	}

	public Map<String, Object> findByBrandSeq(int brandSeq) {
		return brandRepository.findByBrandSeq(brandSeq);
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForBrandInfo(BrandDto brandDto) {
		return brandRepository.saveOneForBrandInfo(brandDto);
	}
}