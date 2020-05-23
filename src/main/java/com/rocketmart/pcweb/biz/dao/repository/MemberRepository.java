package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.Tables;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.TB_PRD_FOB_HST;
import static com.rocketmart.jooq.Tables.TB_WISH_MST;
import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbInquiryDtl.TB_INQUIRY_DTL;
import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;
import static org.jooq.impl.DSL.*;

@Repository
public class MemberRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * 회원 상세정보 조회
     */
    public Map<String, Object> findOneForMemInfo(String memId) {

        return this.dslContext
                .select(TB_MEM_MST.MEM_SEQ, TB_MEM_MST.ROLE, TB_MEM_MST.MEM_ID, TB_MEM_MST.MEM_NM,
                        TB_MEM_MST.MEM_PW, TB_MEM_MST.APPROVAL_YN, TB_MEM_MST.TEL, TB_MEM_MST.COMPANY_NM,
                        TB_MEM_MST.COMPANY_URL, TB_MEM_MST.BSNS_TYPE, TB_MEM_MST.OFFLINE_YN, TB_MEM_MST.OFFLINE_TEXT,
                        TB_MEM_MST.ONLINE_YN, TB_MEM_MST.ONLINE_TEXT, TB_MEM_MST.BSNS_RGSTR_SEQ, TB_MEM_MST.USE_YN,
                        TB_MEM_MST.REG_USR_ID, TB_MEM_MST.REG_TS, TB_MEM_MST.UPD_USR_ID, TB_MEM_MST.UPD_TS,
                        TB_CM_AFILE.REG_FILE_NM, TB_CM_AFILE.ORGN_FILE_NM, TB_CM_AFILE.URL_PATH_CD, TB_CM_AFILE.EXT, TB_CM_AFILE.AFILE_SIZE, TB_CM_AFILE.THEMA_RELM_CD)
                .from(TB_MEM_MST)
                .leftOuterJoin(TB_CM_AFILE)
                .on(TB_MEM_MST.BSNS_RGSTR_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .where(TB_MEM_MST.MEM_ID.equal(memId))
                .fetchOneMap();
    }

    /**
     * 회원 목록 조회
     */
    public List<Map<String, Object>> findAllForMemInfo(TbMemMstRecord tbMemMstRecord, int startIndex, int pageSize) {
        return this.dslContext
                .select(
                        DSL.rowNumber().over(orderBy(field("REG_TS"))).as("ROW_NUM"),
                        field("MEM_ID"),
                        field("MEM_NM"),
                        field("ROLE"),
                        field("APPROVAL_YN"),
                        field("TEL"),
                        field("COMPANY_NM"),
                        field("REG_TS")
                ).from(
                        select(
                                TB_MEM_MST.MEM_ID,
                                TB_MEM_MST.MEM_NM,
                                TB_MEM_MST.ROLE,
                                TB_MEM_MST.APPROVAL_YN,
                                TB_MEM_MST.TEL,
                                TB_MEM_MST.COMPANY_NM,
                                TB_MEM_MST.REG_TS
                        ).from(TB_MEM_MST)
                        .where(TB_MEM_MST.MEM_ID.notEqual("admin"))
                        .and(isNotEmpty(tbMemMstRecord.getMemNm(), TB_MEM_MST.MEM_NM.like("%"+tbMemMstRecord.getMemNm()+"%")))
                        .and(isNotEmpty(tbMemMstRecord.getRole(), TB_MEM_MST.ROLE.eq(tbMemMstRecord.getRole())))
                        .and(isNotEmpty(tbMemMstRecord.getApprovalYn(), TB_MEM_MST.APPROVAL_YN.eq(tbMemMstRecord.getApprovalYn())))
                        .and(isNotEmpty(tbMemMstRecord.getCompanyNm(), TB_MEM_MST.COMPANY_NM.like("%"+tbMemMstRecord.getCompanyNm()+"%")))
                )
                .orderBy(field("REG_TS").desc())
                .offset(startIndex)
                .limit(pageSize)
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
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, memberRecord.getBsnsRgstrSeq())
                .set(TB_MEM_MST.BSNS_TYPE, memberRecord.getBsnsType())
                .set(TB_MEM_MST.OFFLINE_YN, DSL.nvl(memberRecord.getOfflineYn(),"N"))
                .set(TB_MEM_MST.OFFLINE_TEXT, memberRecord.getOfflineText())
                .set(TB_MEM_MST.ONLINE_YN, DSL.nvl(memberRecord.getOnlineYn(),"N"))
                .set(TB_MEM_MST.ONLINE_TEXT, memberRecord.getOnlineText())
                .set(TB_MEM_MST.REG_USR_ID, "system")
                .set(TB_MEM_MST.UPD_USR_ID, "system")
                .execute();
    }

    /**
     * 구매자 정보 수정
     * @param mmbrRcrd
     * @return
     */
    public int execModifyBuyerInfo(TbMemMstRecord mmbrRcrd) {
        return this.dslContext.update(TB_MEM_MST)
                .set(TB_MEM_MST.MEM_NM, mmbrRcrd.getMemNm())
                .set(TB_MEM_MST.MEM_PW, mmbrRcrd.getMemPw())
                .set(TB_MEM_MST.TEL, mmbrRcrd.getTel())
                .set(TB_MEM_MST.COMPANY_NM, mmbrRcrd.getCompanyNm())
                .set(TB_MEM_MST.COMPANY_URL, mmbrRcrd.getCompanyUrl())
                .set(TB_MEM_MST.OFFLINE_YN, DSL.nvl(mmbrRcrd.getOfflineYn(),"N"))
                .set(TB_MEM_MST.OFFLINE_TEXT, mmbrRcrd.getOfflineText())
                .set(TB_MEM_MST.ONLINE_YN, DSL.nvl(mmbrRcrd.getOnlineYn(),"N"))
                .set(TB_MEM_MST.ONLINE_TEXT, mmbrRcrd.getOnlineText())
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, mmbrRcrd.getBsnsRgstrSeq())
                .set(TB_MEM_MST.UPD_USR_ID, mmbrRcrd.getUpdUsrId())
                .set(TB_MEM_MST.UPD_TS, currentTimestamp())
                .where(TB_MEM_MST.MEM_ID.eq(mmbrRcrd.getMemId()))
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
                .set(TB_MEM_MST.BSNS_RGSTR_SEQ, mmbrRcrd.getBsnsRgstrSeq())
                .set(TB_MEM_MST.UPD_USR_ID, mmbrRcrd.getUpdUsrId())
                .set(TB_MEM_MST.UPD_TS, currentTimestamp())
                .where(TB_MEM_MST.MEM_ID.eq(mmbrRcrd.getMemId()))
                .execute();
    }

    /**
     * 회원 승인 처리
     * @param memId
     * @param flag
     * @return
     */
    public int execApprovalMemInfo(String memId, String flag) {
        return this.dslContext.update(TB_MEM_MST)
                .set(TB_MEM_MST.APPROVAL_YN, flag)
                .where(TB_MEM_MST.MEM_ID.eq(memId))
                .execute();
    }


    /**
     * 상품에 대한 회원정보 조회
     * @param productSeq
     * @param memId
     * @return mmbrMap
     */
    public Map<String, Object> findOneForMemProductInfo(int productSeq, String memId) {
        return this.dslContext
                .select(TB_MEM_MST.MEM_SEQ, TB_MEM_MST.ROLE, TB_MEM_MST.MEM_ID, TB_MEM_MST.MEM_NM,
                        TB_MEM_MST.MEM_PW, TB_MEM_MST.APPROVAL_YN, TB_MEM_MST.TEL, TB_MEM_MST.COMPANY_NM,
                        TB_MEM_MST.COMPANY_URL, TB_MEM_MST.BSNS_TYPE, TB_MEM_MST.OFFLINE_YN, TB_MEM_MST.OFFLINE_TEXT,
                        TB_MEM_MST.ONLINE_YN, TB_MEM_MST.ONLINE_TEXT, TB_MEM_MST.BSNS_RGSTR_SEQ, TB_MEM_MST.USE_YN,
                        TB_MEM_MST.REG_USR_ID, TB_MEM_MST.REG_TS, TB_MEM_MST.UPD_USR_ID, TB_MEM_MST.UPD_TS,
                        TB_INQUIRY_DTL.INQUIRY_DTL_SEQ,
                        (select(TB_WISH_MST.WISH_SEQ)
                                .from(TB_WISH_MST)
                                .where(TB_WISH_MST.PRODUCT_SEQ.eq(productSeq)
                                        .and(isNotEmpty(memId, TB_WISH_MST.REG_USR_ID.eq(memId)))
                                        .and(TB_WISH_MST.DEL_YN.eq("N"))
                                )
                        ).asField("WISH_YN"),
                        (select(max(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ))
                                .from(TB_INQUIRY_DTL)
                                .where(TB_INQUIRY_DTL.PRODUCT_SEQ.eq(productSeq)
                                    .and(isNotEmpty(memId, TB_INQUIRY_DTL.REG_USR_ID.eq(memId)))
                                )
                        ).asField("INQUIRY_YN"),
                        (select(TB_PRD_FOB_HST.FOB_HST_SEQ)
                                .from(TB_PRD_FOB_HST)
                                .where(TB_PRD_FOB_HST.PRODUCT_SEQ.eq(productSeq)
                                        .and(isNotEmpty(memId, TB_PRD_FOB_HST.REG_USR_ID.eq(memId)))
                                )
                        ).asField("FOB_HST_YN")
                )
                .from(TB_MEM_MST)
                .leftOuterJoin(TB_INQUIRY_DTL)
                    .on(TB_MEM_MST.MEM_ID.eq(TB_INQUIRY_DTL.REG_USR_ID))
                .where(isNotEmpty(memId, TB_MEM_MST.MEM_ID.eq(memId)))
                .groupBy(
                    TB_MEM_MST.MEM_SEQ
                )
                .fetchOneMap();
    }

    /**
     * 비밀번호 초기화
     * @param tbMemMstRecord
     * @return
     */
    public int execModifyMemPwInfo(TbMemMstRecord tbMemMstRecord) {
        return this.dslContext.update(TB_MEM_MST)
                .set(TB_MEM_MST.MEM_PW, tbMemMstRecord.getMemPw())
                .where(TB_MEM_MST.MEM_ID.eq(tbMemMstRecord.getMemId()))
                .execute();
    }

	public int findAllCnt(TbMemMstRecord tbMemMstRecord) {
        return this.dslContext.
                selectCount().from(TB_MEM_MST)
                .where(TB_MEM_MST.MEM_ID.notEqual("admin"))
                .and(isNotEmpty(tbMemMstRecord.getMemNm(), TB_MEM_MST.MEM_NM.like("%"+tbMemMstRecord.getMemNm()+"%")))
                .and(isNotEmpty(tbMemMstRecord.getRole(), TB_MEM_MST.ROLE.eq(tbMemMstRecord.getRole())))
                .and(isNotEmpty(tbMemMstRecord.getApprovalYn(), TB_MEM_MST.APPROVAL_YN.eq(tbMemMstRecord.getApprovalYn())))
                .and(isNotEmpty(tbMemMstRecord.getCompanyNm(), TB_MEM_MST.COMPANY_NM.like("%"+tbMemMstRecord.getCompanyNm()+"%")))
                .fetchOne().value1();
	}
}