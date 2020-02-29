package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbOtherContactUsRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_OTHER_CONTACT_US;

@Repository
public class OtherRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * ContactUs 정보 조회
     */
    public Map<String, Object> findOneForContactUsInfo(int contactSeq) {
        return this.dslContext.selectFrom(TB_OTHER_CONTACT_US)
                .where(TB_OTHER_CONTACT_US.CONTACT_SEQ.eq(contactSeq))
                .fetchOneMap();
    }

    /**
     * ContactUs 목록 조회
     */
    public List<Map<String, Object>> findAllForContactUsInfo() {
        return this.dslContext.selectFrom(TB_OTHER_CONTACT_US)
                .orderBy(TB_OTHER_CONTACT_US.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * ContactUs 등록
     */
    public int saveOneForContactUsInfo(TbOtherContactUsRecord contactUsRecord) {
        return this.dslContext.insertInto(TB_OTHER_CONTACT_US)
                .set(TB_OTHER_CONTACT_US.USR_NM, contactUsRecord.getUsrNm())
                .set(TB_OTHER_CONTACT_US.EMAIL, contactUsRecord.getEmail())
                .set(TB_OTHER_CONTACT_US.COMPANY_NM, contactUsRecord.getCompanyNm())
                .set(TB_OTHER_CONTACT_US.SUBJECT, contactUsRecord.getSubject())
                .set(TB_OTHER_CONTACT_US.MESSAGE, contactUsRecord.getMessage())
                .execute();
    }
}