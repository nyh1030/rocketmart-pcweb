package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.Tables;
import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.records.TbBrandMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_MEM_MST;
import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;
import static org.jooq.impl.DSL.*;

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
				.and(DSL.exists(DSL.selectOne().from(TB_PRD_MST).where(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ).and(TB_PRD_MST.DEL_YN.equal("N")).and(TB_PRD_MST.RELEASE_YN.equal("Y")))))
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
						TB_BRAND_MST.BRAND_CERIFY, TB_BRAND_MST.BRAND_INTRODUCTION, TB_BRAND_MST.REG_USR_ID, TB_BRAND_MST.REG_TS, TB_BRAND_MST.UPD_USR_ID, TB_BRAND_MST.UPD_TS)
				.values(brandDto.getBrandNm(), brandDto.getBrandLogoFileSeq(), brandDto.getBrandOwnership(),
						brandDto.getBrandHomePageUrl(), brandDto.getBrandYouTubeUrl(), brandDto.getBrandInstagramUrl(),
						brandDto.getBrandCerify(), brandDto.getBrandIntroduction(), brandDto.getRegUsrId(), Timestamp.valueOf(LocalDateTime.now()), brandDto.getUpdUsrId(), Timestamp.valueOf(LocalDateTime.now()))
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
				.set(TB_BRAND_MST.UPD_TS, Timestamp.valueOf(LocalDateTime.now()))
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandDto.getBrandSeq()))
				.execute();
	}

	public List<Map<String, Object>> findAllForAlPaBet() {
		Field<?> count =
				this.dslContext.selectCount()
						.from(TB_PRD_MST)
						.where(TB_PRD_MST.BRAND_SEQ.eq(TB_BRAND_MST.BRAND_SEQ)).and(TB_PRD_MST.DEL_YN.equal("N")).and(TB_PRD_MST.RELEASE_YN.equal("Y"))
						.asField("count");

		return this.dslContext.select(
				TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD, count.as("PRODUCT_CNT"))
				.from(TB_BRAND_MST)
				.leftOuterJoin(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(DSL.exists(this.dslContext.selectOne().from(TB_PRD_MST).where(TB_BRAND_MST.BRAND_SEQ.equal(TB_PRD_MST.BRAND_SEQ)).and(TB_PRD_MST.RELEASE_YN.equal("Y"))))
				.groupBy(TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD)
				.fetchMaps();
	}

	public int deleteBrand(int brandSeq) {
		this.dslContext.update(TB_PRD_MST)
				.set(TB_PRD_MST.DEL_YN, "Y")
				.where(TB_PRD_MST.BRAND_SEQ.equal(brandSeq))
				.execute();

		return this.dslContext.update(TB_BRAND_MST)
				.set(TB_BRAND_MST.DEL_YN, "Y")
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandSeq))
				.execute();
	}

	/**
	 * 브랜드 목록(어드민)
	 */
	public List<Map<String, Object>> findAllForAdminBrandInfo(String schCompanyNm, String schMemId, String schBrandNm, int startIndex, int pageSize) {
		return this.dslContext
				.select(
						DSL.rowNumber().over().as("ROW_NUM"),
						field("COMPANY_NM"),
						field("MEM_ID"),
						field("BRAND_SEQ"),
						field("BRAND_NM")
				).from(select(
								TB_MEM_MST.COMPANY_NM
								,TB_MEM_MST.MEM_ID
								,TB_BRAND_MST.BRAND_SEQ
								,TB_BRAND_MST.BRAND_NM
						).from(TB_MEM_MST)
							.join(TB_BRAND_MST)
							.on(TB_MEM_MST.MEM_ID.eq(TB_BRAND_MST.REG_USR_ID))
						.where(isNotEmpty(schCompanyNm, TB_MEM_MST.COMPANY_NM.like("%"+schCompanyNm+"%")))
						.and(isNotEmpty(schMemId, TB_MEM_MST.MEM_ID.like("%"+schMemId+"%")))
						.and(isNotEmpty(schBrandNm, TB_BRAND_MST.BRAND_NM.like("%"+schBrandNm+"%")))
						.and(TB_BRAND_MST.DEL_YN.equal("N"))
						.orderBy(TB_MEM_MST.REG_TS.desc())
				)
				.offset(startIndex)
				.limit(pageSize)
				.fetchMaps();
	}

	public int findAllCnt(String schCompanyNm, String schMemId, String schBrandNm) {
		Record1<Integer> integerRecord1 = this.dslContext
				.select(count())
				.from(TB_MEM_MST)
				.join(TB_BRAND_MST)
				.on(TB_MEM_MST.MEM_ID.eq(TB_BRAND_MST.REG_USR_ID))
				.where(isNotEmpty(schCompanyNm, TB_MEM_MST.COMPANY_NM.like("%" + schCompanyNm + "%")))
				.and(isNotEmpty(schMemId, TB_MEM_MST.MEM_ID.like("%" + schMemId + "%")))
				.and(isNotEmpty(schBrandNm, TB_BRAND_MST.BRAND_NM.like("%" + schBrandNm + "%"))).fetchAny();
		return integerRecord1.value1();
	}

	public List<Map<String, Object>> findAllForAfileWithBrandSeq(int brandSeq) {
		return this.dslContext.select(TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_BRAND_MST)
				.join(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_BRAND_MST.BRAND_SEQ.equal(brandSeq)).and(TB_BRAND_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public int findPendingCnt(String schProductNm, String schBrandNm) {
		return this.dslContext
				.selectCount()
				.from(TB_PRD_MST)
				.leftOuterJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.innerJoin(TB_BRAND_MST)
				.on(TB_PRD_MST.BRAND_SEQ.equal(Tables.TB_BRAND_MST.BRAND_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N")).and(TB_PRD_MST.RELEASE_YN.equal("N"))
				.and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
				.and(isNotEmpty(schBrandNm, TB_BRAND_MST.BRAND_NM.like("%"+schBrandNm+"%")))
				.orderBy(TB_PRD_MST.REG_TS.desc())
				.fetchOne().value1();
	}
}
