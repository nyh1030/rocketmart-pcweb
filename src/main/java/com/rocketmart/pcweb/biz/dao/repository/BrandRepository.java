package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;

@Repository
public class BrandRepository {

	@Autowired
	private DSLContext dslContext;

	public List<Map<String, Object>> findAll() {
		return this.dslContext.select(TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_BRAND_MST)
				.join(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_BRAND_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findAllForAfile(String regUsrId) {
		return this.dslContext.select(TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_BRAND_MST)
				.join(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_BRAND_MST.REG_USR_ID.equal(regUsrId)).and(TB_BRAND_MST.DEL_YN.equal("N"))
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
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandSeq)).and(TB_BRAND_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public List<Map<String, Object>> findBrandByUsrId(String usrId) {
		return this.dslContext.select(
				TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM)
				.from(TB_BRAND_MST)
				.where(TB_BRAND_MST.REG_USR_ID.equal(usrId)).and(TB_BRAND_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public Timestamp findLastUpdatedDateTime(String regUsrId) {
		return this.dslContext.select(DSL.max(TB_BRAND_MST.UPD_TS))
				.from(TB_BRAND_MST)
				.where(TB_BRAND_MST.REG_USR_ID.equal(regUsrId)).and(TB_BRAND_MST.DEL_YN.equal("N"))
				.fetchOne(Record1::value1);
	}

	public int saveOneForBrandInfo(BrandDto brandDto) {
		return this.dslContext.insertInto(TB_BRAND_MST)
				.columns(TB_BRAND_MST.BRAND_NM, TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ, TB_BRAND_MST.BRAND_OWNERSHIP,
						TB_BRAND_MST.BRAND_HOMEPAGE_URL, TB_BRAND_MST.BRAND_YOUTUBE_URL, TB_BRAND_MST.BRAND_INSTAGRAM_URL,
						TB_BRAND_MST.BRAND_CERIFY, TB_BRAND_MST.BRAND_INTRODUCTION, TB_BRAND_MST.REG_USR_ID, TB_BRAND_MST.UPD_USR_ID)
				.values(brandDto.getBrandNm(), brandDto.getBrandLogoFileSeq(), brandDto.getBrandOwnership(),
						brandDto.getBrandHomePageUrl(), brandDto.getBrandYouTubeUrl(), brandDto.getBrandInstagramUrl(),
						brandDto.getBrandCerify(), brandDto.getBrandIntroduction(), brandDto.getRegUsrId(), brandDto.getUpdUsrId())
				.execute();
	}

	public int updateOneForBrandInfo(BrandDto brandDto) {
		return this.dslContext.update(TB_BRAND_MST)
				.set(TB_BRAND_MST.BRAND_NM, brandDto.getBrandNm())
				.set(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ, brandDto.getBrandLogoFileSeq())
				.set(TB_BRAND_MST.BRAND_OWNERSHIP, brandDto.getBrandOwnership())
				.set(TB_BRAND_MST.BRAND_HOMEPAGE_URL, brandDto.getBrandHomePageUrl())
				.set(TB_BRAND_MST.BRAND_YOUTUBE_URL, brandDto.getBrandYouTubeUrl())
				.set(TB_BRAND_MST.BRAND_INSTAGRAM_URL, brandDto.getBrandInstagramUrl())
				.set(TB_BRAND_MST.BRAND_CERIFY, brandDto.getBrandCerify())
				.set(TB_BRAND_MST.BRAND_INTRODUCTION, brandDto.getBrandIntroduction())
				.set(TB_BRAND_MST.UPD_USR_ID, brandDto.getRegUsrId())
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandDto.getBrandSeq()))
				.execute();
	}

	public List<Map<String, Object>> findAllForAlPaBet() {
		return this.dslContext.select(
				TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD, DSL.count(TB_PRD_MST.PRODUCT_SEQ).as("PRODUCT_CNT"))
				.from(TB_BRAND_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.leftOuterJoin(TB_PRD_MST)
				.on(TB_BRAND_MST.BRAND_SEQ.equal(TB_PRD_MST.PRODUCT_SEQ))
				.groupBy(TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD)
				.fetchMaps();
	}
}
