package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.MemberDto;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    public Result<TbMemMstRecord> findOneForMemInfo(String memId) {
        return this.dslContext.selectFrom(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.eq(memId))
                .fetch();
    }

    public int saveOneForMemInfo(MemberDto memberDto) {
        return this.dslContext.insertInto(TB_MEM_MST)
                .set(TB_MEM_MST.ROLE, memberDto.getRole())
                .set(TB_MEM_MST.MEM_ID, memberDto.getMemId())
                .set(TB_MEM_MST.MEM_NM, memberDto.getMemNm())
                .set(TB_MEM_MST.MEM_PW, memberDto.getMemPw())
                .set(TB_MEM_MST.TEL, memberDto.getTel())
                .set(TB_MEM_MST.COMPANY_NM, memberDto.getCompanyNm())
                .set(TB_MEM_MST.COMPANY_URL, memberDto.getCompanyUrl())
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, 5)
                .set(TB_MEM_MST.BSNS_TYPE, memberDto.getBsnsType())
                .set(TB_MEM_MST.BUYER_CHANNEL, memberDto.getBuyerChannel())
                .set(TB_MEM_MST.BUYER_TEXT, memberDto.getBuyerText())
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, 5)
                .set(TB_MEM_MST.REG_USR_ID, "system")
                .set(TB_MEM_MST.UPD_USR_ID, "system")
                .execute();
    }
}