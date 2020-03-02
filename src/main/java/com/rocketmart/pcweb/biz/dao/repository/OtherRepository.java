package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_CONTACT_US;
import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;

@Repository
public class OtherRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * ContactUs 정보 조회
     */
    public Map<String, Object> findOneForContactUsInfo(int contactSeq) {
        return this.dslContext.selectFrom(TB_CONTACT_US)
                .where(TB_CONTACT_US.CONTACT_SEQ.eq(contactSeq))
                .fetchOneMap();
    }

    /**
     * ContactUs 목록 조회
     */
    public List<Map<String, Object>> findAllForContactUsInfo(TbContactUsRecord tbContactUsRecord ) {
        return this.dslContext.selectFrom(TB_CONTACT_US)
                .where(DSL.trueCondition())                
                .and(isNotEmpty(tbContactUsRecord.getUsrNm(), TB_CONTACT_US.USR_NM.eq(tbContactUsRecord.getUsrNm())))
                .and(isNotEmpty(tbContactUsRecord.getEmail(), TB_CONTACT_US.EMAIL.eq(tbContactUsRecord.getEmail())))
                .and(isNotEmpty(tbContactUsRecord.getCompanyNm(), TB_CONTACT_US.COMPANY_NM.eq(tbContactUsRecord.getCompanyNm())))
                .and(isNotEmpty(tbContactUsRecord.getSubject(), TB_CONTACT_US.SUBJECT.eq(tbContactUsRecord.getSubject())))
                .and(isNotEmpty(tbContactUsRecord.getMessage(), TB_CONTACT_US.MESSAGE.eq(tbContactUsRecord.getMessage())))
                .orderBy(TB_CONTACT_US.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * ContactUs 등록
     */
    public int saveOneForContactUsInfo(TbContactUsRecord contactUsRecord) {
        return this.dslContext.insertInto(TB_CONTACT_US)
                .set(TB_CONTACT_US.USR_NM, contactUsRecord.getUsrNm())
                .set(TB_CONTACT_US.EMAIL, contactUsRecord.getEmail())
                .set(TB_CONTACT_US.COMPANY_NM, contactUsRecord.getCompanyNm())
                .set(TB_CONTACT_US.SUBJECT, contactUsRecord.getSubject())
                .set(TB_CONTACT_US.MESSAGE, contactUsRecord.getMessage())
                .execute();
    }
}