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

import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	public List<Map<String, Object>> findAllForAfile() {
		return this.dslContext.select(TB_BRAND_MST.BRAND_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_BRAND_MST)
				.join(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
				.fetchMaps();
	}

	public Map<String, Object> findByBrandSeq(int brandSeq) {
		return this.dslContext.select(
				TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ,
				TB_BRAND_MST.BRAND_HOMEPAGE_URL, TB_BRAND_MST.BRAND_YOUTUBE_URL, TB_BRAND_MST.BRAND_INSTAGRAM_URL,
				TB_BRAND_MST.BRAND_OWNERSHIP, TB_BRAND_MST.BRAND_CERIFY, TB_BRAND_MST.BRAND_INTRODUCTION,
				TB_CM_AFILE.URL_PATH_CD, TB_CM_AFILE.AFILE_SIZE)
				.from(TB_BRAND_MST)
				.leftOuterJoin(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandSeq))
				.fetchOneMap();
	}

	public int saveOneForBrandInfo(BrandDto brandDto) {
		return this.dslContext.insertInto(TB_BRAND_MST)
				.columns(TB_BRAND_MST.BRAND_NM, TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ, TB_BRAND_MST.BRAND_OWNERSHIP,
						TB_BRAND_MST.BRAND_HOMEPAGE_URL, TB_BRAND_MST.BRAND_YOUTUBE_URL, TB_BRAND_MST.BRAND_INSTAGRAM_URL,
						TB_BRAND_MST.BRAND_CERIFY, TB_BRAND_MST.BRAND_INTRODUCTION, TB_BRAND_MST.REG_USR_ID, TB_BRAND_MST.UPD_USR_ID)
				.values(brandDto.getBrandNm(), brandDto.getBrandLogoFileSeq(), brandDto.getBrandOwnership(),
						brandDto.getBrandHomePageUrl(), brandDto.getBrandYouTubeUrl(), brandDto.getBrandInstagramUrl(),
						brandDto.getBrandCerify(), brandDto.getBrandIntroduction(), "ADMIN", "ADMIN")
				.execute();
	}
}
