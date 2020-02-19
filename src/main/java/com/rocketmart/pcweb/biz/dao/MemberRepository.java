package com.rocketmart.pcweb.biz.dao;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    public List<MemberDto> findAll() {
        return Collections.emptyList();
    }

    public void saveOneForMem(MemberDto memberDto) {
        dslContext.insertInto(TB_MEM_MST)
                .set(TB_MEM_MST.ROLE, memberDto.getRole())
                .set(TB_MEM_MST.MEM_ID, memberDto.getMemId())
                .set(TB_MEM_MST.MEM_NM, memberDto.getMemNm())
                .set(TB_MEM_MST.MEM_PW, memberDto.getMemPw())
                .set(TB_MEM_MST.TEL, memberDto.getTel())
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, 5)
                .set(TB_MEM_MST.REG_USR_ID, "system")
                .set(TB_MEM_MST.UPD_USR_ID, "system")
                .execute();

    }
}