package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * 회원 정보 조회
     */
    public Map<String, Object> findOneForMemInfo(String memId) {
        return this.dslContext.selectFrom(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.eq(memId))
                .fetchOneMap();
    }

    /**
     * 회원 목록 조회
     */
    public List<Map<String, Object>> findAllForMemInfo(TbMemMstRecord tbMemMstRecord) {
        /*List<Condition> conditions = new ArrayList<Condition>();

            conditions.add(TB_MEM_MST.MEM_ID.notEqual("admin"));
        if(null != tbMemMstRecord.getMemNm() && !tbMemMstRecord.getMemNm().isEmpty()) {
            conditions.add(TB_MEM_MST.MEM_NM.eq(tbMemMstRecord.getMemNm()));
        }
        if(null != tbMemMstRecord.getApprovalYn() && !tbMemMstRecord.getApprovalYn().isEmpty()) {
            conditions.add(TB_MEM_MST.APPROVAL_YN.eq(tbMemMstRecord.getApprovalYn()));
        }
        if(null != tbMemMstRecord.getCompanyNm() && !tbMemMstRecord.getCompanyNm().isEmpty()) {
            conditions.add(TB_MEM_MST.COMPANY_NM.eq(tbMemMstRecord.getCompanyNm()));
        }*/

        return this.dslContext.selectFrom(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.notEqual("admin"))
                .and(isNotEmpty(tbMemMstRecord.getMemNm(), TB_MEM_MST.MEM_NM.eq(tbMemMstRecord.getMemNm())))
                .and(isNotEmpty(tbMemMstRecord.getApprovalYn(), TB_MEM_MST.APPROVAL_YN.eq(tbMemMstRecord.getApprovalYn())))
                .and(isNotEmpty(tbMemMstRecord.getCompanyNm(), TB_MEM_MST.COMPANY_NM.eq(tbMemMstRecord.getCompanyNm())))
                .orderBy(TB_MEM_MST.MEM_SEQ.desc())
                .fetchMaps();
    }

    /**
     * 회원중복 체크
     */
    public boolean idOverLapChk(String memId) {
        return this.dslContext.selectCount()
                .from(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.eq(memId))
                .fetchOne().value1() > 0;
    }

    /**
     * 회원 가입
     */
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
                .set(TB_MEM_MST.OFFLINE_YN, memberRecord.getOfflineYn())
                .set(TB_MEM_MST.OFFLINE_TEXT, memberRecord.getOfflineText())
                .set(TB_MEM_MST.ONLINE_YN, memberRecord.getOnlineYn())
                .set(TB_MEM_MST.ONLINE_TEXT, memberRecord.getOnlineText())
                .set(TB_MEM_MST.REG_USR_ID, "system")
                .set(TB_MEM_MST.UPD_USR_ID, "system")
                .execute();
    }

    /**
     * 판매자 정보 수정
     * @param mmbrRcrd
     * @return
     */
    public int execModifySellerInfo(TbMemMstRecord mmbrRcrd) {
        return this.dslContext.update(TB_MEM_MST)
                .set(TB_MEM_MST.MEM_NM, mmbrRcrd.getMemNm())
                .set(TB_MEM_MST.MEM_PW, mmbrRcrd.getMemPw())
                .set(TB_MEM_MST.TEL, mmbrRcrd.getTel())
                .set(TB_MEM_MST.COMPANY_NM, mmbrRcrd.getCompanyNm())
                .set(TB_MEM_MST.COMPANY_URL, mmbrRcrd.getCompanyUrl())
                .set(TB_MEM_MST.BSNS_TYPE, mmbrRcrd.getBsnsType())
                .where(TB_MEM_MST.MEM_ID.eq(mmbrRcrd.getMemId()))
                .execute();
    }

    /**
     * 회원 승인 처리
     * @param mmbrId
     * @param flag
     * @return
     */
    public int execApprovalMemInfo(String mmbrId, String flag) {
        return this.dslContext.update(TB_MEM_MST)
                .set(TB_MEM_MST.APPROVAL_YN, flag)
                .where(TB_MEM_MST.MEM_ID.eq(mmbrId))
                .execute();
    }
}