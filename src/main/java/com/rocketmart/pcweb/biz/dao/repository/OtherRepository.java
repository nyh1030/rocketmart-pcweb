package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.TbInquiryDtl;
import com.rocketmart.jooq.tables.records.*;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.jooq.OrderedAggregateFunction;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.*;
import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbInquiryDtl.TB_INQUIRY_DTL;
import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;
import static org.jooq.impl.DSL.*;

@Repository
public class OtherRepository {

    @Autowired
    private DSLContext dslContext;

    /**
     * ContactUs 상세정보 조회
     */
    public Map<String, Object> findOneForContactUsInfo(int contactSeq) {
        return this.dslContext.selectFrom(TB_CONTACT_US)
                .where(TB_CONTACT_US.CONTACT_SEQ.eq(contactSeq))
                .fetchOneMap();
    }

    /**
     * ContactUs 목록 조회
     */
    public List<Map<String, Object>> findAllForContactUsInfo(TbContactUsRecord tbContactUsRecord, int startIndex, int pageSize) {
        return this.dslContext
                .select(
                        DSL.rowNumber().over().as("ROW_NUM"),
                        field("CONTACT_SEQ"),
                        field("USR_NM"),
                        field("EMAIL"),
                        field("COMPANY_NM"),
                        field("SUBJECT"),
                        field("MESSAGE"),
                        field("REG_TS"),
                        field("REPLY_YN")
                ).from(
                        select(
                                TB_CONTACT_US.CONTACT_SEQ,
                                TB_CONTACT_US.USR_NM,
                                TB_CONTACT_US.EMAIL,
                                TB_CONTACT_US.COMPANY_NM,
                                TB_CONTACT_US.SUBJECT,
                                TB_CONTACT_US.MESSAGE,
                                TB_CONTACT_US.REG_TS,
                                TB_CONTACT_US.REPLY_YN
                        ).from(TB_CONTACT_US)
                        .where(DSL.trueCondition())
                        .and(isNotEmpty(tbContactUsRecord.getUsrNm(), TB_CONTACT_US.USR_NM.eq(tbContactUsRecord.getUsrNm())))
                        .and(isNotEmpty(tbContactUsRecord.getEmail(), TB_CONTACT_US.EMAIL.eq(tbContactUsRecord.getEmail())))
                        .and(isNotEmpty(tbContactUsRecord.getCompanyNm(), TB_CONTACT_US.COMPANY_NM.eq(tbContactUsRecord.getCompanyNm())))
                        .and(isNotEmpty(tbContactUsRecord.getSubject(), TB_CONTACT_US.SUBJECT.eq(tbContactUsRecord.getSubject())))
                        .and(isNotEmpty(tbContactUsRecord.getMessage(), TB_CONTACT_US.MESSAGE.eq(tbContactUsRecord.getMessage())))
                        .orderBy(TB_CONTACT_US.REG_TS.desc())
                )
                .offset(startIndex)
                .limit(pageSize)
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

    /**
     * WishList 등록 중복 체크
     */
    public boolean wishInfoOverLapChk(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext.selectCount()
                .from(TB_WISH_MST)
                .where(TB_WISH_MST.PRODUCT_SEQ.eq(tbWishMstRecord.getProductSeq()))
                    .and(TB_WISH_MST.REG_USR_ID.eq(tbWishMstRecord.getRegUsrId())
                    //.and(TB_WISH_MST.ASK_YN.eq("N"))
                    .and(TB_WISH_MST.DEL_YN.eq("N")))
                .fetchOne().value1() > 0;
    }

    /**
     * WishList 등록
     */
    public int saveOneForWishListInfo(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext.insertInto(TB_WISH_MST)
                .set(TB_WISH_MST.PRODUCT_SEQ, tbWishMstRecord.getProductSeq())
                .set(TB_WISH_MST.REG_USR_ID, tbWishMstRecord.getRegUsrId())
                .set(TB_WISH_MST.UPD_USR_ID, tbWishMstRecord.getRegUsrId())
                .execute();
    }

    /**
     * WishList 삭제
     */
    public int deleteWishListInfo(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext.update(TB_WISH_MST)
                .set(TB_WISH_MST.DEL_YN, "Y")
                .where(TB_WISH_MST.PRODUCT_SEQ.equal(tbWishMstRecord.getProductSeq())
                        .and(TB_WISH_MST.REG_USR_ID.eq(tbWishMstRecord.getRegUsrId())))
                .execute();
    }

    /**
     * WishList 목록 조회
     */
    public List<Map<String, Object>> findAllForWishInfo(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext
                .select(
                         TB_WISH_MST.WISH_SEQ
                        ,TB_WISH_MST.ASK_YN
                        ,TB_PRD_MST.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_CM_AFILE.URL_PATH_CD
                        ,TB_PRD_MST.RETAIL_PRICE
                        ,TB_PRD_MST.GIVE_SAMPLE_YN
                        ,TB_MEM_MST.APPROVAL_YN
                        ,TB_MEM_MST.MEM_NM
                        ,TB_INQUIRY_DTL.REG_USR_ID
                        ,DSL.nvl2(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ,"Y", "N").as("INQUIRY_YN")
                )
                .from(TB_WISH_MST)
                .join(TB_PRD_MST)
                    .on(TB_WISH_MST.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                .join(TB_CM_AFILE)
                    .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .join(TB_MEM_MST)
                    .on(TB_WISH_MST.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .leftJoin(TB_INQUIRY_DTL)
                    .on(TB_WISH_MST.REG_USR_ID.eq(TB_INQUIRY_DTL.REG_USR_ID)).and(TB_WISH_MST.PRODUCT_SEQ.eq(TB_INQUIRY_DTL.PRODUCT_SEQ))
                .where(isNotEmpty(tbWishMstRecord.getRegUsrId(), TB_WISH_MST.REG_USR_ID.eq(tbWishMstRecord.getRegUsrId()))
                    .and(TB_WISH_MST.DEL_YN.eq("N"))
                )
                .groupBy(TB_WISH_MST.WISH_SEQ, TB_WISH_MST.ASK_YN, TB_PRD_MST.PRODUCT_SEQ, TB_PRD_MST.PRODUCT_NM, TB_CM_AFILE.URL_PATH_CD, TB_PRD_MST.RETAIL_PRICE, TB_MEM_MST.APPROVAL_YN, TB_MEM_MST.MEM_NM)
                .orderBy(TB_WISH_MST.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * Inquiry 목록 조회
     */
    public List<Map<String, Object>> findAllForInquiryInfo(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm, int startIndex, int pageSize) {
        return this.dslContext
                .select(
                        DSL.rowNumber().over().as("ROW_NUM"),
                        field("INQUIRY_DTL_SEQ"),
                        field("MESSAGE"),
                        field("MEM_ID"),
                        field("MEM_NM"),
                        field("PRODUCT_SEQ"),
                        field("PRODUCT_NM"),
                        field("URL_PATH_CD"),
                        field("REG_USR_ID"),
                        field("REG_TS"),
                        field("UPD_USR_ID"),
                        field("UPD_TS"),
                        field("REPLY_YN_CNT")
                ).from(select(
                        TB_INQUIRY_DTL.INQUIRY_DTL_SEQ
                        ,TB_INQUIRY_DTL.MESSAGE
                        ,TB_MEM_MST.MEM_ID
                        ,TB_MEM_MST.MEM_NM
                        ,TB_PRD_MST.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_CM_AFILE.URL_PATH_CD
                        ,TB_INQUIRY_DTL.REG_USR_ID
                        ,TB_INQUIRY_DTL.REG_TS
                        ,TB_INQUIRY_DTL.UPD_USR_ID
                        ,TB_INQUIRY_DTL.UPD_TS
                        ,(select(count())
                                .from(TB_INQUIRY_DTL)
                                .where(
                                        isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TB_INQUIRY_DTL.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                .and(TB_INQUIRY_DTL.REPLY_YN.eq("N"))
                                                .and(TB_INQUIRY_DTL.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                                ).asField("REPLY_YN_CNT")
                        )
                        )
                                .from(TB_INQUIRY_DTL)
                                .join(TB_MEM_MST)
                                .on(TB_INQUIRY_DTL.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                                .join(TB_PRD_MST)
                                .on(TB_PRD_MST.PRODUCT_SEQ.eq(TB_INQUIRY_DTL.PRODUCT_SEQ))
                                .join(TB_CM_AFILE)
                                .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                                .where(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.in(
                                        select(max(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ))
                                                .from(TB_INQUIRY_DTL)
                                                .where(
                                                        isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TB_INQUIRY_DTL.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                                .and(isNotEmpty(schMemId, TB_INQUIRY_DTL.REG_USR_ID.like("%"+schMemId+"%")))
                                                                .and(isNotEmpty(schMemNm, TB_MEM_MST.MEM_NM.like("%"+schMemNm+"%")))
                                                                .and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
                                                ).groupBy(TB_INQUIRY_DTL.PRODUCT_SEQ)
                                        )
                                )
                                .orderBy(TB_INQUIRY_DTL.REG_TS.desc())
                )
                .offset(startIndex)
                .limit(pageSize)
                .fetchMaps();
    }

    /**
     * Inquiry 목록 조회(admin)
     */

    public List<Map<String, Object>> findAllForAdminInquiryInfo(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm, int startIndex, int pageSize) {
        TbInquiryDtl TID = TB_INQUIRY_DTL.as("TID");

        return this.dslContext
                .select(
                        DSL.rowNumber().over().as("ROW_NUM"),
                        field("INQUIRY_DTL_SEQ"),
                        field("MESSAGE"),
                        field("MEM_ID"),
                        field("MEM_NM"),
                        field("PRODUCT_SEQ"),
                        field("PRODUCT_NM"),
                        field("URL_PATH_CD"),
                        field("REG_USR_ID"),
                        field("REG_TS"),
                        field("UPD_USR_ID"),
                        field("UPD_TS"),
                        field("REPLY_YN_CNT")
                ).from(select(
                            TB_INQUIRY_DTL.INQUIRY_DTL_SEQ
                            ,TB_INQUIRY_DTL.MESSAGE
                            ,TB_MEM_MST.MEM_ID
                            ,TB_MEM_MST.MEM_NM
                            ,TB_PRD_MST.PRODUCT_SEQ
                            ,TB_PRD_MST.PRODUCT_NM
                            ,TB_CM_AFILE.URL_PATH_CD
                            ,TB_INQUIRY_DTL.REG_USR_ID
                            ,TB_INQUIRY_DTL.REG_TS
                            ,TB_INQUIRY_DTL.UPD_USR_ID
                            ,TB_INQUIRY_DTL.UPD_TS
                            ,(select(count())
                                    .from(TID)
                                    .where(
                                            isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TID.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                    .and(TID.REPLY_YN.eq("N"))
                                                    .and(TID.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                                                    .and(TID.REG_USR_ID.eq(TB_INQUIRY_DTL.REG_USR_ID))
                                    ).asField("REPLY_YN_CNT")
                            )
                    )
                    .from(TB_INQUIRY_DTL)
                    .join(TB_MEM_MST)
                    .on(TB_INQUIRY_DTL.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                    .join(TB_PRD_MST)
                    .on(TB_PRD_MST.PRODUCT_SEQ.eq(TB_INQUIRY_DTL.PRODUCT_SEQ))
                    .join(TB_CM_AFILE)
                    .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                    .where(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.in(
                            select(max(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ))
                                    .from(TB_INQUIRY_DTL)
                                    .where(
                                            isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TB_INQUIRY_DTL.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                    .and(isNotEmpty(schMemId, TB_INQUIRY_DTL.REG_USR_ID.like("%"+schMemId+"%")))
                                                    .and(isNotEmpty(schMemNm, TB_MEM_MST.MEM_NM.like("%"+schMemNm+"%")))
                                                    .and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
                                    ).groupBy(TB_INQUIRY_DTL.PRODUCT_SEQ, TB_INQUIRY_DTL.REG_USR_ID)
                            )
                    )
                    .orderBy(TB_INQUIRY_DTL.REG_TS.desc())
                )
                .offset(startIndex)
                .limit(pageSize)
                .fetchMaps();
    }

    /**
     * Inquiry 상세정보 조회_마스터
     */
    public Map<String, Object> findOneForInquiryMstInfo(int inquirySeq) {
        return this.dslContext
                .select(
                        TB_INQUIRY_MST.INQUIRY_SEQ
                        ,TB_MEM_MST.MEM_ID
                        ,TB_MEM_MST.MEM_NM
                        ,TB_INQUIRY_MST.MESSAGE
                        ,TB_INQUIRY_MST.REG_USR_ID
                        ,TB_INQUIRY_MST.REG_TS
                        ,TB_INQUIRY_MST.UPD_USR_ID
                        ,TB_INQUIRY_MST.UPD_TS
                )
                .from(TB_INQUIRY_MST)
                .join(TB_MEM_MST)
                    .on(TB_INQUIRY_MST.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .where(TB_INQUIRY_MST.INQUIRY_SEQ.eq(inquirySeq))
                .fetchOneMap();
    }

    /**
     * Inquiry 상세정보 조회_상세
     */
    public List<Map<String, Object>> findAllForInquiryDtlInfo(int productSeq, String regUsrId) {
        return this.dslContext
                .select(
                        TB_INQUIRY_DTL.INQUIRY_DTL_SEQ
                        ,TB_INQUIRY_DTL.MESSAGE
                        ,TB_INQUIRY_DTL.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_MEM_MST.MEM_ID
                        ,TB_MEM_MST.MEM_NM
                        ,TB_CM_AFILE.URL_PATH_CD
                        ,TB_INQUIRY_DTL.REG_USR_ID
                        ,TB_INQUIRY_DTL.REG_TS
                        ,TB_INQUIRY_DTL.UPD_USR_ID
                        ,TB_INQUIRY_DTL.UPD_TS
                        ,TB_INQUIRY_DTL.REPLY_YN
                )
                .from(TB_INQUIRY_DTL)
                .join(TB_PRD_MST)
                    .on(TB_INQUIRY_DTL.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                .join(TB_CM_AFILE)
                    .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .join(TB_MEM_MST)
                    .on(TB_INQUIRY_DTL.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .where(TB_INQUIRY_DTL.PRODUCT_SEQ.eq(productSeq))
                    .and(isNotEmpty(regUsrId, TB_INQUIRY_DTL.REG_USR_ID.eq(regUsrId)))
                .orderBy(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.desc())
                .fetchMaps();
    }

    /**
     * Inquiry 마스터 등록
     */
    public TbInquiryMstRecord saveOneForInquiryMstInfo(TbInquiryMstRecord tbInquiryMstRecord) {
        return this.dslContext.insertInto(TB_INQUIRY_MST)
                .set(TB_INQUIRY_MST.MESSAGE, tbInquiryMstRecord.getMessage())
                .set(TB_INQUIRY_MST.REG_USR_ID, tbInquiryMstRecord.getRegUsrId())
                .set(TB_INQUIRY_MST.UPD_USR_ID, tbInquiryMstRecord.getRegUsrId())
                .returning(TB_INQUIRY_MST.INQUIRY_SEQ)
                .fetchOne();
    }

    /**
     * Inquiry 상세 등록
     */
    public int saveAllForInquiryDtlInfo(TbInquiryDtlRecord tbInquiryDtlRecord) {
        return this.dslContext.insertInto(TB_INQUIRY_DTL)
                .set(TB_INQUIRY_DTL.PRODUCT_SEQ, tbInquiryDtlRecord.getProductSeq())
                .set(TB_INQUIRY_DTL.MESSAGE, tbInquiryDtlRecord.getMessage())
                .set(TB_INQUIRY_DTL.REG_USR_ID, tbInquiryDtlRecord.getRegUsrId())
                .set(TB_INQUIRY_DTL.UPD_USR_ID, tbInquiryDtlRecord.getRegUsrId())
                .execute();
    }

    /**
     * Inquiry 후 WishList 에서 제거
     */
    public int updateOneForWishInfo(TbInquiryDtlRecord tbInquiryDtlRecord, int productSeq) {
        return this.dslContext.update(TB_WISH_MST)
                .set(TB_WISH_MST.ASK_YN, "Y")
                .set(TB_WISH_MST.UPD_USR_ID, tbInquiryDtlRecord.getRegUsrId())
                .set(TB_WISH_MST.UPD_TS, currentTimestamp())
                .where(TB_WISH_MST.PRODUCT_SEQ.equal(productSeq)
                    .and(TB_WISH_MST.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()
                )))
                .execute();
    }

    /**
     * Click Log 목록(어드민)
     */
    public List<Map<String, Object>> findAllForClickLogInfo(TbPrdFobHstRecord tbPrdFobHstRecord, String schMemId, String schProductNm) {
        return this.dslContext
                .select(
                        TB_PRD_FOB_HST.REG_USR_ID
                        ,count().as("TOT_CNT")
                        ,groupConcat(TB_PRD_MST.PRODUCT_NM, ", ").as("PRODUCT_NM")
                )
                .from(TB_PRD_FOB_HST)
                .join(TB_PRD_MST)
                    .on(TB_PRD_FOB_HST.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                .join(TB_MEM_MST)
                    .on(TB_PRD_FOB_HST.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .where(isNotEmpty(schMemId, TB_PRD_FOB_HST.REG_USR_ID.like("%"+schMemId+"%")))
                    .and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
                    .and(TB_PRD_FOB_HST.REG_USR_ID.notEqual("admin"))
                    .and(TB_MEM_MST.ROLE.eq("BUYER"))
                .groupBy(TB_PRD_FOB_HST.REG_USR_ID)
                .orderBy(count().desc(), TB_PRD_FOB_HST.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * Click Log 등록(상품 가격 조회 이력 등록)
     */
    public int saveOneForClickLogInfo(TbPrdFobHstRecord tbPrdFobHstRecord) {
        return this.dslContext.insertInto(TB_PRD_FOB_HST)
                .set(TB_PRD_FOB_HST.PRODUCT_SEQ, tbPrdFobHstRecord.getProductSeq())
                .set(TB_PRD_FOB_HST.REG_USR_ID, tbPrdFobHstRecord.getRegUsrId())
                .set(TB_PRD_FOB_HST.UPD_USR_ID, tbPrdFobHstRecord.getRegUsrId())
                .execute();
    }

    /**
     * Contact Us 회신여부 변경
     */
    public int updateContactUsReplyYn(int contactSeq) {
        return this.dslContext.update(TB_CONTACT_US)
                .set(TB_CONTACT_US.REPLY_YN, iif(TB_CONTACT_US.REPLY_YN.eq("Y"),"N", "Y"))
                .where(TB_CONTACT_US.CONTACT_SEQ.equal(contactSeq))
                .execute();
    }

    /**
     * Inquiry 회신여부 변경
     */
    public int updateInquiryReplyYn(int inquiryDtlSeq) {
        return this.dslContext.update(TB_INQUIRY_DTL)
                .set(TB_INQUIRY_DTL.REPLY_YN, iif(TB_INQUIRY_DTL.REPLY_YN.eq("Y"),"N", "Y"))
                .where(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.equal(inquiryDtlSeq))
                .execute();
    }


    public int findContactUsCnt(TbContactUsRecord tbContactUsRecord) {
        return this.dslContext.selectCount().from(TB_CONTACT_US)
                .where(DSL.trueCondition())
                .and(isNotEmpty(tbContactUsRecord.getUsrNm(), TB_CONTACT_US.USR_NM.eq(tbContactUsRecord.getUsrNm())))
                .and(isNotEmpty(tbContactUsRecord.getEmail(), TB_CONTACT_US.EMAIL.eq(tbContactUsRecord.getEmail())))
                .and(isNotEmpty(tbContactUsRecord.getCompanyNm(), TB_CONTACT_US.COMPANY_NM.eq(tbContactUsRecord.getCompanyNm())))
                .and(isNotEmpty(tbContactUsRecord.getSubject(), TB_CONTACT_US.SUBJECT.eq(tbContactUsRecord.getSubject())))
                .and(isNotEmpty(tbContactUsRecord.getMessage(), TB_CONTACT_US.MESSAGE.eq(tbContactUsRecord.getMessage())))
                .fetchOne().value1();
    }

    public int findAllForAdminInquiryInfoCnt(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm) {
        return this.dslContext
                .selectCount()
                .from(TB_INQUIRY_DTL)
                .join(TB_MEM_MST)
                .on(TB_INQUIRY_DTL.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .join(TB_PRD_MST)
                .on(TB_PRD_MST.PRODUCT_SEQ.eq(TB_INQUIRY_DTL.PRODUCT_SEQ))
                .join(TB_CM_AFILE)
                .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .where(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.in(
                        select(max(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ))
                                .from(TB_INQUIRY_DTL)
                                .where(
                                        isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TB_INQUIRY_DTL.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                .and(isNotEmpty(schMemId, TB_INQUIRY_DTL.REG_USR_ID.like("%"+schMemId+"%")))
                                                .and(isNotEmpty(schMemNm, TB_MEM_MST.MEM_NM.like("%"+schMemNm+"%")))
                                                .and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
                                ).groupBy(TB_INQUIRY_DTL.PRODUCT_SEQ, TB_INQUIRY_DTL.REG_USR_ID)
                        )
                )
                .fetchOne().value1();
    }

    public int findAllForInquiryInfoCnt(TbInquiryDtlRecord tbInquiryDtlRecord, String schMemId, String schMemNm, String schProductNm) {
        return this.dslContext
                .selectCount()
                .from(TB_INQUIRY_DTL)
                .join(TB_MEM_MST)
                .on(TB_INQUIRY_DTL.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .join(TB_PRD_MST)
                .on(TB_PRD_MST.PRODUCT_SEQ.eq(TB_INQUIRY_DTL.PRODUCT_SEQ))
                .join(TB_CM_AFILE)
                .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .where(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ.in(
                        select(max(TB_INQUIRY_DTL.INQUIRY_DTL_SEQ))
                                .from(TB_INQUIRY_DTL)
                                .where(
                                        isNotEmpty(tbInquiryDtlRecord.getRegUsrId(), TB_INQUIRY_DTL.REG_USR_ID.eq(tbInquiryDtlRecord.getRegUsrId()))
                                                .and(isNotEmpty(schMemId, TB_INQUIRY_DTL.REG_USR_ID.like("%"+schMemId+"%")))
                                                .and(isNotEmpty(schMemNm, TB_MEM_MST.MEM_NM.like("%"+schMemNm+"%")))
                                                .and(isNotEmpty(schProductNm, TB_PRD_MST.PRODUCT_NM.like("%"+schProductNm+"%")))
                                ).groupBy(TB_INQUIRY_DTL.PRODUCT_SEQ)
                        )
                )
                .fetchOne().value1();
    }
}