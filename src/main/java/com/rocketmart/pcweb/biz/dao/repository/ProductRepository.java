package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
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
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;
import static com.rocketmart.jooq.tables.TbPrdWholesale.TB_PRD_WHOLESALE;

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
				TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.WHOLESALE_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN, TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT,
				TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_BRAND_MST)
				.on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
				.leftOuterJoin(TB_CM_AFILE)
				.on(TB_BRAND_MST.BRAND_LOGO_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq)).and(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchOneMap();
	}

	public List<Map<String, Object>> findWholesaleByProductSeq(int productSeq) {
		return this.dslContext.select(
				TB_PRD_WHOLESALE.WHOLESALE_SEQ, TB_PRD_WHOLESALE.PRODUCT_SEQ, TB_PRD_WHOLESALE.RANGE_START, TB_PRD_WHOLESALE.RANGE_END,
				TB_PRD_WHOLESALE.TRADING_PRICE, TB_PRD_WHOLESALE.SUPPLY_RATE)
				.from(TB_PRD_WHOLESALE)
				.where(TB_PRD_WHOLESALE.PRODUCT_SEQ.equal(productSeq)).and(TB_PRD_WHOLESALE.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findFrontAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findBackAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_BACK_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findAspectAfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ASPECT_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findShape1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_SHAPE1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findShape2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_SHAPE2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findOutside1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_OUTSIDE1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findOutside2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_OUTSIDE2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findEtc1AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ETC1_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
	}

	public List<Map<String, Object>> findEtc2AfileByProductSeq(int productSeq) {
		return this.dslContext.select(TB_CM_AFILE.AFILE_SEQ, TB_CM_AFILE.URL_PATH_CD)
				.from(TB_PRD_MST)
				.innerJoin(TB_CM_AFILE)
				.on(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.and(TB_PRD_MST.PRODUCT_ETC2_AFILE_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
				.where(TB_PRD_MST.DEL_YN.equal("N"))
				.fetchMaps();
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
						TB_PRD_MST.PRODUCT_CONTENT, TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.WHOLESALE_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN,
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

	public int saveOneForWholeSaleInfo(Map<String, Object> paramMap) {
		return this.dslContext.insertInto(TB_PRD_WHOLESALE)
				.columns(TB_PRD_WHOLESALE.PRODUCT_SEQ, TB_PRD_WHOLESALE.RANGE_START, TB_PRD_WHOLESALE.RANGE_END,
						TB_PRD_WHOLESALE.TRADING_PRICE, TB_PRD_WHOLESALE.SUPPLY_RATE)
				.values(Integer.parseInt(paramMap.get("productSeq").toString()), Long.parseLong(paramMap.get("rangeStart").toString()), Long.parseLong(paramMap.get("rangeEnd").toString()),
						Long.parseLong(paramMap.get("tradingPrice").toString()), Integer.parseInt(paramMap.get("supplyRate").toString()))
				.execute();
	}

	public String copyProduct(int productSeq) {
		return "";
	}

	public int deleteProduct(int productSeq) {
		return this.dslContext.update(TB_PRD_MST)
				.set(TB_PRD_MST.DEL_YN, "Y")
				.where(TB_PRD_MST.PRODUCT_SEQ.equal(productSeq))
				.execute();
	}
}
