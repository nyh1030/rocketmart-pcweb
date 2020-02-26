package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	public List<Map<String, Object>> findAllForAfile() {
		return this.dslContext.select(TbBrandMst.TB_BRAND_MST.BRAND_SEQ, TbCmAfile.TB_CM_AFILE.URL_PATH_CD)
				.from(TbBrandMst.TB_BRAND_MST)
				.join(TbCmAfile.TB_CM_AFILE)
				.on(TbBrandMst.TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.eq(TbCmAfile.TB_CM_AFILE.AFILE_SEQ))
				.fetchMaps();
	}

	public Map<String, Object> findByBrandSeq(int brandSeq) {
		return this.dslContext.select(TbBrandMst.TB_BRAND_MST.BRAND_SEQ, TbBrandMst.TB_BRAND_MST.BRAND_NM, TbBrandMst.TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ,
				TbBrandMst.TB_BRAND_MST.BRAND_HOMEPAGE_URL, TbBrandMst.TB_BRAND_MST.BRAND_YOUTUBE_URL, TbBrandMst.TB_BRAND_MST.BRAND_INSTAGRAM_URL, TbBrandMst.TB_BRAND_MST.BRAND_OWNERSHIP,
				TbBrandMst.TB_BRAND_MST.BRAND_CERIFY, TbBrandMst.TB_BRAND_MST.BRAND_INTRODUCTION)
				.from(TbBrandMst.TB_BRAND_MST)
				.where(TbBrandMst.TB_BRAND_MST.BRAND_SEQ.equal(brandSeq))
				.fetchOneMap();
	}

	public int saveOneForBrandInfo(BrandDto brandDto) {
		return this.dslContext.insertInto(TbBrandMst.TB_BRAND_MST)
				.columns(TbBrandMst.TB_BRAND_MST.BRAND_NM, TbBrandMst.TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ, TbBrandMst.TB_BRAND_MST.BRAND_OWNERSHIP,
						TbBrandMst.TB_BRAND_MST.BRAND_HOMEPAGE_URL, TbBrandMst.TB_BRAND_MST.BRAND_YOUTUBE_URL, TbBrandMst.TB_BRAND_MST.BRAND_INSTAGRAM_URL,
						TbBrandMst.TB_BRAND_MST.BRAND_CERIFY, TbBrandMst.TB_BRAND_MST.BRAND_INTRODUCTION, TbBrandMst.TB_BRAND_MST.REG_USR_ID, TbBrandMst.TB_BRAND_MST.UPD_USR_ID)
				.values(brandDto.getBrandNm(), brandDto.getBrandFileSeq(), brandDto.getBrandOwnership(),
						brandDto.getBrandHomePageUrl(), brandDto.getBrandYouTubeUrl(), brandDto.getBrandInstagramUrl(),
						brandDto.getBrandCerify(), brandDto.getBrandIntroduction(), "ADMIN", "ADMIN")
				.execute();
	}
}
