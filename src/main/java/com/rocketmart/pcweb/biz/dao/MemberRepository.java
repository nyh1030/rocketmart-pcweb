package com.rocketmart.pcweb.biz.dao;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    //@Transactional(readOnly = true)
    public List<MemberDto> findAll() {
        return Collections.emptyList();
    }

    //@Transactional(rollbackFor = Exception.class)
    public int saveOneForMem() {
        return dslContext.insertInto(TB_MEM_MST)
                .set(TB_MEM_MST.MEM_SEQ, 3)
                .set(TB_MEM_MST.ROLE, "BUYER")
                .set(TB_MEM_MST.MEM_ID, "BUYER")
                .set(TB_MEM_MST.MEM_NM, "user10")
                .set(TB_MEM_MST.TEL, "2222")
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, 5)
                .set(TB_MEM_MST.REG_USR_ID, "2222")
                .set(TB_MEM_MST.UPD_USR_ID, "2222")
                .execute()
                ;

    }
}