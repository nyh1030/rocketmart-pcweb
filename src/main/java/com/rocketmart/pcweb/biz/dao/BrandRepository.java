package com.rocketmart.pcweb.biz.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	//@Transactional(readOnly = true)
	public List<BrandDto> findAll() {
		return Collections.emptyList();
	}

	//@Transactional(rollbackFor = Exception.class)
	public int saveOne(BrandDto brandDto) {
		return 0;
	}
}
