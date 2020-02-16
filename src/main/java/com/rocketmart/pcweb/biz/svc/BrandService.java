package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.BrandDto;
import com.rocketmart.pcweb.biz.dao.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrandService {

	@Autowired
	private BrandRepository brandMapper;

/*	public List<BrandDto> findAll() {
		return brandMapper.findAll();
	}

	public int insertBrandInfo(BrandDto brandDto) {
		return brandMapper.saveOne(brandDto);
	}*/
}
