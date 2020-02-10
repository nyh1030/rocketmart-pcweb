package com.rocketmart.pcweb.biz.dao;

import com.rocketmart.jooq.tables.Brand;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	@Transactional(readOnly = true)
	public List<BrandDto> findAll() {
		return this.dslContext.select(Brand.BRAND.BRANDID, Brand.BRAND.BRANDNAME)
				.from(Brand.BRAND)
				.fetchInto(BrandDto.class);
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOne(BrandDto brandDto) {
		return this.dslContext.insertInto(Brand.BRAND)
				.columns(Brand.BRAND.BRANDID, Brand.BRAND.BRANDNAME)
				.values(brandDto.getBrandId(), brandDto.getBrandName())
				.execute();
	}
}
