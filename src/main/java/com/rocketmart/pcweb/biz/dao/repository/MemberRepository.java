package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    public TbMemMstRecord findOneForMemInfo(String memId) {
        return this.dslContext.selectFrom(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.eq(memId))
                .fetchOne();
    }

    public int saveOneForMemInfo(TbMemMstRecord memberRecord) {
        return this.dslContext.insertInto(TB_MEM_MST)
                .set(TB_MEM_MST.ROLE, memberRecord.getRole())
                .set(TB_MEM_MST.MEM_ID, memberRecord.getMemId())
                .set(TB_MEM_MST.MEM_NM, memberRecord.getMemNm())
                .set(TB_MEM_MST.MEM_PW, memberRecord.getMemPw())
                .set(TB_MEM_MST.TEL, memberRecord.getTel())
                .set(TB_MEM_MST.COMPANY_NM, memberRecord.getCompanyNm())
                .set(TB_MEM_MST.COMPANY_URL, memberRecord.getCompanyUrl())
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, 5)
                .set(TB_MEM_MST.BSNS_TYPE, memberRecord.getBsnsType())
                .set(TB_MEM_MST.BUYER_CHANNEL, memberRecord.getBuyerChannel())
                .set(TB_MEM_MST.BUYER_TEXT, memberRecord.getBuyerText())
                .set(TB_MEM_MST.REG_USR_ID, "system")
                .set(TB_MEM_MST.UPD_USR_ID, "system")
                .execute();
    }
}