package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_BRAND_MST;
import static com.rocketmart.jooq.Tables.TB_CATE_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;

@Repository
public class CategoryRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * 메인 > Category 목록 메뉴
     * @param cate1Cd
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAllForCategoryMenu(String cate1Cd) {

        return this.dslContext.selectFrom(TB_CATE_MST)
                .where(TB_CATE_MST.CATE1_CD.eq(cate1Cd))
                .orderBy(TB_CATE_MST.CATE1_CD.asc(), TB_CATE_MST.CATE2_CD.asc(), TB_CATE_MST.CATE3_CD.asc())
                .fetchMaps();
    }

    /**
     * 메인 > Category 목록 조회
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAllForCategoryPrdInfo(TbCateMstRecord tbCateMstRecord) {

        return this.dslContext
                .select(
                         TB_PRD_MST.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_BRAND_MST.BRAND_NM
                        ,TB_CM_AFILE.AFILE_SEQ
                        ,TB_CM_AFILE.URL_PATH_CD
                )
                .from(TB_PRD_MST)
                .innerJoin(TB_CM_AFILE)
                .on(TB_PRD_MST.PRODUCT_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
                .innerJoin(TB_BRAND_MST)
                .on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
                .where(TB_PRD_MST.DEL_YN.equal("N"))
                .and(isNotEmpty(tbCateMstRecord.getCate1Cd(), TB_PRD_MST.CATE1_CD.eq(tbCateMstRecord.getCate1Cd())))
                .and(isNotEmpty(tbCateMstRecord.getCate2Cd(), TB_PRD_MST.CATE2_CD.eq(tbCateMstRecord.getCate2Cd())))
                .and(isNotEmpty(tbCateMstRecord.getCate3Cd(), TB_PRD_MST.CATE3_CD.eq(tbCateMstRecord.getCate3Cd())))
                .orderBy(TB_PRD_MST.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * 메인 > brands 목록 조회
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAllForCategoryWithBrandPrdInfo(TbCateMstRecord tbCateMstRecord, int brandSeq) {
        return this.dslContext
                .select(
                        TB_PRD_MST.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_BRAND_MST.BRAND_NM
                        ,TB_CM_AFILE.AFILE_SEQ
                        ,TB_CM_AFILE.URL_PATH_CD
                )
                .from(TB_PRD_MST)
                .innerJoin(TB_CM_AFILE)
                .on(TB_PRD_MST.PRODUCT_SEQ.equal(TB_CM_AFILE.AFILE_SEQ))
                .innerJoin(TB_BRAND_MST)
                .on(TB_PRD_MST.BRAND_SEQ.equal(TB_BRAND_MST.BRAND_SEQ))
                .where(TB_PRD_MST.DEL_YN.equal("N").and(TB_BRAND_MST.BRAND_SEQ.equal(brandSeq)))
                .and(isNotEmpty(tbCateMstRecord.getCate1Cd(), TB_PRD_MST.CATE1_CD.eq(tbCateMstRecord.getCate1Cd())))
                .and(isNotEmpty(tbCateMstRecord.getCate2Cd(), TB_PRD_MST.CATE2_CD.eq(tbCateMstRecord.getCate2Cd())))
                .and(isNotEmpty(tbCateMstRecord.getCate3Cd(), TB_PRD_MST.CATE3_CD.eq(tbCateMstRecord.getCate3Cd())))
                .orderBy(TB_PRD_MST.REG_TS.desc())
                .fetchMaps();
    }

    public List<Map<String, Object>> findAll() {
        return this.dslContext.select()
                .from(TB_CATE_MST)
                .fetchMaps();
    }
}