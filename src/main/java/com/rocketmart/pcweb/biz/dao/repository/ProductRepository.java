package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCateMst.TB_CATE_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbPrdFob.TB_PRD_FOB;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;

@Repository
public class ProductRepository {

	@Autowired
	private DSLContext dslContext;

	public int findOneForMaxProductSeq() {
		return this.dslContext.select(DSL.coalesce(DSL.max(TB_PRD_MST.PRODUCT_SEQ), 0))
				.from(TB_PRD_MST)
				.fetchOne(Record1::value1);
	}

	public List<Map<String, Object>> findProductForBrand(int brandSeq) {
		return this.dslContext.select(
				TB_PRD_MST.PRODUCT_SEQ, TB_PRD_MST.PRODUCT_NM, TB_PRD_MST.PRODUCT_CAPACITY,
				TB_PRD_MST.RETAIL_PRICE, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.BRAND_SEQ.equal(brandSeq)).and(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public Map<String, Object> findByProductSeq(int productSeq) {
		return this.dslContext.select(
				TB_PRD_MST.PRODUCT_SEQ, TB_PRD_MST.PRODUCT_NM,TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM,TB_PRD_MST.CATE1_CD, TB_PRD_MST.CATE2_CD, TB_PRD_MST.CATE3_CD,
				TB_PRD_MST.PRODUCT_CAPACITY, TB_PRD_MST.PRODUCT_URL, TB_PRD_MST.PRODUCT_LINEUP, TB_PRD_MST.SELLER_NOTE, TB_PRD_MST.PRODUCT_CONTENT,
				TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.FOB_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN, TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT,
				TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_BRAND_MST)
				.on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
				.leftOuterJoin(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq)).and(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public List<Map<String, Object>> findAllForLastestOrder() {
		return this.dslContext.select(
				TB_PRD_MST.PRODUCT_SEQ, TB_PRD_MST.PRODUCT_NM,TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM,TB_PRD_MST.CATE1_CD, TB_PRD_MST.CATE2_CD, TB_PRD_MST.CATE3_CD,
				TB_PRD_MST.PRODUCT_CAPACITY, TB_PRD_MST.PRODUCT_URL, TB_PRD_MST.PRODUCT_LINEUP, TB_PRD_MST.SELLER_NOTE, TB_PRD_MST.PRODUCT_CONTENT,
				TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.FOB_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN, TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT,
				TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_BRAND_MST)
				.on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.orderBy(TB_PRD_MST.REG_TS.desc())
				.fetchMaps();
	}

	public List<Map<String, Object>> findProductListByCateCd(String cateCd) {
		return this.dslContext.select(
				TB_PRD_MST.PRODUCT_SEQ, TB_PRD_MST.PRODUCT_NM,TB_BRAND_MST.BRAND_SEQ, TB_BRAND_MST.BRAND_NM,TB_PRD_MST.CATE1_CD, TB_PRD_MST.CATE2_CD, TB_PRD_MST.CATE3_CD,
				TB_PRD_MST.PRODUCT_CAPACITY, TB_PRD_MST.PRODUCT_URL, TB_PRD_MST.PRODUCT_LINEUP, TB_PRD_MST.SELLER_NOTE, TB_PRD_MST.PRODUCT_CONTENT,
				TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.FOB_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN, TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT,
				TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_BRAND_MST)
				.on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.CATE2_CD.equal(cateCd)).and(TB_PRD_MST.DEL_YN.equal("N"))
				.orderBy(TB_PRD_MST.REG_TS.desc())
				.fetchMaps();
	}

	public List<Map<String, Object>> findFobByProductSeq(int productSeq) {
		return this.dslContext.select(
				TB_PRD_FOB.FOB_SEQ, TB_PRD_FOB.PRODUCT_SEQ, TB_PRD_FOB.RANGE_START, TB_PRD_FOB.RANGE_END,
				TB_PRD_FOB.TRADING_PRICE, TB_PRD_FOB.SUPPLY_RATE)
				.from(TB_PRD_FOB)
				.where(TB_PRD_FOB.PRODUCT_SEQ.equal(productSeq)).and(TB_PRD_FOB.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public Map<String, Object> findFrontAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findBackAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_BACK_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findAspectAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ASPECT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findShape1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_SHAPE1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findShape2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_SHAPE2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findOutside1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_OUTSIDE1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findOutside2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_OUTSIDE2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findEtc1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ETC1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public Map<String, Object> findEtc2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ETC2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public List<Map<String, Object>> findListForCate1() {
		return this.dslContext.select(
				TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE1_NM)
				.from(TB_CATE_MST)
				.groupBy(TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE1_NM)
				.fetchMaps();
	}

	public List<Map<String, Object>> findListForCate2() {
		return this.dslContext.select(
				TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE2_NM)
				.from(TB_CATE_MST)
				.groupBy(TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE2_NM)
				.fetchMaps();
	}

	public List<Map<String, Object>> findListForCate3() {
		return this.dslContext.select(
				TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE3_CD, TB_CATE_MST.CATE3_NM)
				.from(TB_CATE_MST)
				.groupBy(TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE3_CD, TB_CATE_MST.CATE3_NM)
				.fetchMaps();
	}

	public int saveOneForProductInfo(ProductDto productDto) {
		return this.dslContext.insertInto(TB_PRD_MST)
				.columns(TB_PRD_MST.BRAND_SEQ, TB_PRD_MST.PRODUCT_NM, TB_PRD_MST.CATE1_CD, TB_PRD_MST.CATE2_CD, TB_PRD_MST.CATE3_CD,
						TB_PRD_MST.PRODUCT_URL, TB_PRD_MST.PRODUCT_CAPACITY, TB_PRD_MST.PRODUCT_LINEUP, TB_PRD_MST.SELLER_NOTE,
						TB_PRD_MST.PRODUCT_CONTENT, TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.FOB_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN,
						TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT, TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS,
						TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ, TB_PRD_MST.PRODUCT_BACK_AFILE_SEQ, TB_PRD_MST.PRODUCT_ASPECT_AFILE_SEQ,
						TB_PRD_MST.PRODUCT_SHAPE1_AFILE_SEQ, TB_PRD_MST.PRODUCT_SHAPE2_AFILE_SEQ, TB_PRD_MST.PRODUCT_OUTSIDE1_AFILE_SEQ,
						TB_PRD_MST.PRODUCT_OUTSIDE2_AFILE_SEQ, TB_PRD_MST.PRODUCT_ETC1_AFILE_SEQ, TB_PRD_MST.PRODUCT_ETC2_AFILE_SEQ,
						TB_BRAND_MST.REG_USR_ID, TB_BRAND_MST.UPD_USR_ID)
				.values(productDto.getBrandSeq(), productDto.getProductNm(), productDto.getCate1Cd(), productDto.getCate2Cd(), productDto.getCate3Cd(),
						productDto.getProductUrl(), productDto.getProductCapacity(), productDto.getProductLineup(), productDto.getSellerNote(),
						productDto.getProductContent(), productDto.getRetailPrice(), 1, productDto.getGiveSampleYn(),
						productDto.getProductAtrbt(), productDto.getProductCrt(), productDto.getExportHst(), productDto.getTradingConditions(),
						productDto.getProductFrontAfileSeq(), productDto.getProductBackAfileSeq(), productDto.getProductAspectAfileSeq(),
						productDto.getProductShape1AfileSeq(), productDto.getProductShape2AfileSeq(), productDto.getProductOutside1AfileSeq(),
						productDto.getProductOutside2AfileSeq(), productDto.getProductEtc1AfileSeq(), productDto.getProductEtc2AfileSeq(),
						"ADMIN", "ADMIN")
				.execute();
	}

	public int saveOneForFobInfo(Map<String, Object> paramMap) {
		return this.dslContext.insertInto(TB_PRD_FOB)
				.columns(TB_PRD_FOB.PRODUCT_SEQ, TB_PRD_FOB.RANGE_START, TB_PRD_FOB.RANGE_END,
						TB_PRD_FOB.TRADING_PRICE, TB_PRD_FOB.SUPPLY_RATE)
				.values(Integer.parseInt(paramMap.get("productSeq").toString()), Long.parseLong(paramMap.get("rangeStart").toString()), Long.parseLong(paramMap.get("rangeEnd").toString()),
						Long.parseLong(paramMap.get("tradingPrice").toString()), Integer.parseInt(paramMap.get("supplyRate").toString()))
				.execute();
	}

	public int updateOneForFobInfo(Map<String, Object> paramMap) {
		return this.dslContext.update(TB_PRD_FOB)
				.set(TB_PRD_FOB.RANGE_START, Long.parseLong(paramMap.get("rangeStart").toString()))
				.set(TB_PRD_FOB.RANGE_END, Long.parseLong(paramMap.get("rangeEnd").toString()))
				.set(TB_PRD_FOB.TRADING_PRICE, Long.parseLong(paramMap.get("tradingPrice").toString()))
				.set(TB_PRD_FOB.SUPPLY_RATE, Integer.parseInt(paramMap.get("supplyRate").toString()))
				.where(TB_PRD_FOB.FOB_SEQ.equal((int) paramMap.get("fobSeq")))
				.and(TB_PRD_FOB.PRODUCT_SEQ.equal((int) paramMap.get("productSeq")))
				.execute();
	}

	public int updateOneForProductInfo(ProductDto productDto) {
		return this.dslContext.update(TB_PRD_MST)
				.set(TB_PRD_MST.PRODUCT_NM, productDto.getProductNm())
				.set(TB_PRD_MST.CATE1_CD, productDto.getCate1Cd())
				.set(TB_PRD_MST.CATE2_CD, productDto.getCate2Cd())
				.set(TB_PRD_MST.CATE3_CD, productDto.getCate3Cd())
				.set(TB_PRD_MST.PRODUCT_URL, productDto.getProductUrl())
				.set(TB_PRD_MST.PRODUCT_CAPACITY, productDto.getProductCapacity())
				.set(TB_PRD_MST.PRODUCT_LINEUP, productDto.getProductLineup())
				.set(TB_PRD_MST.SELLER_NOTE, productDto.getSellerNote())
				.set(TB_PRD_MST.PRODUCT_CONTENT, productDto.getProductContent())
				.set(TB_PRD_MST.RETAIL_PRICE, productDto.getRetailPrice())
				.set(TB_PRD_MST.GIVE_SAMPLE_YN, productDto.getGiveSampleYn())
				.set(TB_PRD_MST.PRODUCT_ATRBT, productDto.getProductAtrbt())
				.set(TB_PRD_MST.PRODUCT_CRT, productDto.getProductCrt())
				.set(TB_PRD_MST.EXPORT_HST, productDto.getExportHst())
				.set(TB_PRD_MST.TRADING_CONDITIONS, productDto.getTradingConditions())
				.set(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ, productDto.getProductFrontAfileSeq())
				.set(TB_PRD_MST.PRODUCT_BACK_AFILE_SEQ, productDto.getProductBackAfileSeq())
				.set(TB_PRD_MST.PRODUCT_ASPECT_AFILE_SEQ, productDto.getProductAspectAfileSeq())
				.set(TB_PRD_MST.PRODUCT_SHAPE1_AFILE_SEQ, productDto.getProductShape1AfileSeq())
				.set(TB_PRD_MST.PRODUCT_SHAPE2_AFILE_SEQ, productDto.getProductShape2AfileSeq())
				.set(TB_PRD_MST.PRODUCT_OUTSIDE1_AFILE_SEQ, productDto.getProductOutside1AfileSeq())
				.set(TB_PRD_MST.PRODUCT_OUTSIDE2_AFILE_SEQ, productDto.getProductOutside2AfileSeq())
				.set(TB_PRD_MST.PRODUCT_ETC1_AFILE_SEQ, productDto.getProductEtc1AfileSeq())
				.set(TB_PRD_MST.PRODUCT_ETC2_AFILE_SEQ, productDto.getProductEtc2AfileSeq())
				.where(TB_PRD_MST.PRODUCT_SEQ.equal(productDto.getProductSeq()))
				.execute();
	}

	public int deleteProduct(int productSeq) {
		return this.dslContext.update(TB_PRD_MST)
				.set(TB_PRD_MST.DEL_YN, "Y")
				.where(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.execute();
	}

	public int deleteByFobSeq(List<Integer> fobSeqs) {
		return this.dslContext.delete(TB_PRD_FOB).where(TB_PRD_FOB.FOB_SEQ.in(fobSeqs)).execute();
	}

	public Map<String, Object> findCateInoByCate1Cd(String cate1Cd) {
		return this.dslContext.select(TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE1_NM)
				.from(TB_CATE_MST)
				.where(TB_CATE_MST.CATE1_CD.equal(cate1Cd))
				.groupBy(TB_CATE_MST.CATE1_CD, TB_CATE_MST.CATE1_NM)
				.fetchOneMap();
	}

	public Map<String, Object> findCateInoByCate2Cd(String cate2Cd) {
		return this.dslContext.select(TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE2_NM)
				.from(TB_CATE_MST)
				.where(TB_CATE_MST.CATE2_CD.equal(cate2Cd))
				.groupBy(TB_CATE_MST.CATE2_CD, TB_CATE_MST.CATE2_NM)
				.fetchOneMap();
	}

	public Map<String, Object> findCateInoByCate3Cd(String cate3Cd) {
		return this.dslContext.select(TB_CATE_MST.CATE3_CD, TB_CATE_MST.CATE3_NM)
				.from(TB_CATE_MST)
				.where(TB_CATE_MST.CATE3_CD.equal(cate3Cd))
				.groupBy(TB_CATE_MST.CATE3_CD, TB_CATE_MST.CATE3_NM)
				.fetchOneMap();
	}
}
