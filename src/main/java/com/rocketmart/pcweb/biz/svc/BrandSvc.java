package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BrandSvc {

	@Autowired
	private BrandRepository brandRepository;

	public List<Map<String, Object>> findAll() {
		return brandRepository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForBrandInfo(BrandDto brandDto) {
		return brandRepository.saveOneForBrandInfo(brandDto);
	}
}