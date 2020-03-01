package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.dto.ProductDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;

@Repository
public class ProductRepository {

	@Autowired
	private DSLContext dslContext;

	public int saveOneForProductInfo(ProductDto productDto) {
		return this.dslContext.insertInto(TB_PRD_MST)
				.columns(TB_PRD_MST.BRAND_SEQ, TB_PRD_MST.PRODUCT_NM, TB_PRD_MST.CATE1_CD, TB_PRD_MST.CATE2_CD, TB_PRD_MST.CATE3_CD,
						TB_PRD_MST.PRODUCT_URL, TB_PRD_MST.PRODUCT_CAPACITY, TB_PRD_MST.PRODUCT_LINEUP, TB_PRD_MST.SELLER_NOTE,
						TB_PRD_MST.PRODUCT_CONTENT, TB_PRD_MST.RETAIL_PRICE, TB_PRD_MST.WHOLESALE_SEQ, TB_PRD_MST.GIVE_SAMPLE_YN,
						TB_PRD_MST.PRODUCT_ATRBT, TB_PRD_MST.PRODUCT_CRT, TB_PRD_MST.EXPORT_HST, TB_PRD_MST.TRADING_CONDITIONS,
						TB_BRAND_MST.REG_USR_ID, TB_BRAND_MST.UPD_USR_ID)
				.values(productDto.getBrandSeq(), productDto.getProductNm(), productDto.getCate1Cd(), productDto.getCate2Cd(), productDto.getCate3Cd(),
						productDto.getProductUrl(), productDto.getProductCapacity(), productDto.getProductLineup(), productDto.getSellerNote(),
						productDto.getProductContent(), productDto.getRetailPrice(), 1, productDto.getGiveSampleYn(),
						productDto.getProductAtrbt(), productDto.getProductCrt(), productDto.getExportHst(), productDto.getTradingConditions(),
						"ADMIN", "ADMIN")
				.execute();
	}
}
