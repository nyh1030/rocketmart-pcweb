package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_CATE_MST;

@Repository
public class CategoryRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * 메인 > Category 목록 메뉴
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAllForCategoryMenu() {

        return this.dslContext.selectFrom(TB_CATE_MST)
                .orderBy(TB_CATE_MST.CATE1_CD.asc(), TB_CATE_MST.CATE2_CD.asc(), TB_CATE_MST.CATE3_CD.asc())
                .fetchMaps();
    }
}