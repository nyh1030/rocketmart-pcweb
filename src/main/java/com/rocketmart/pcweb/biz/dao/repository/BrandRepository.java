package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	public int saveOneForBrandInfo(BrandDto brandDto) {
		return this.dslContext.insertInto(TbBrandMst.TB_BRAND_MST)
				.columns(TbBrandMst.TB_BRAND_MST.BRAND_NM, TbBrandMst.TB_BRAND_MST.BRAND_LOGO, TbBrandMst.TB_BRAND_MST.BRAND_OWNERSHIP,
						TbBrandMst.TB_BRAND_MST.BRAND_HOMEPAGE_URL, TbBrandMst.TB_BRAND_MST.BRAND_YOUTUBE_URL, TbBrandMst.TB_BRAND_MST.BRAND_INSTAGRAM_URL,
						TbBrandMst.TB_BRAND_MST.BRAND_CERIFY, TbBrandMst.TB_BRAND_MST.BRAND_INTRODUCTION, TbBrandMst.TB_BRAND_MST.REG_USR_ID, TbBrandMst.TB_BRAND_MST.UPD_USR_ID)
				.values(brandDto.getBrandNm(), brandDto.getBrandLogo(), brandDto.getBrandOwnership(),
						brandDto.getBrandHomePageUrl(), brandDto.getBrandYouTubeUrl(), brandDto.getBrandInstagramUrl(),
						brandDto.getBrandCerify(), brandDto.getBrandIntroduction(), "ADMIN", "ADMIN")
				.execute();
	}
}
