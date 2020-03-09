package com.rocketmart.pcweb.biz.dao.repository;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbInquiryDtlRecord;
import com.rocketmart.jooq.tables.records.TbInquiryMstRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.rocketmart.jooq.Tables.*;
import static com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;
import static com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;
import static com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;
import static com.rocketmart.pcweb.common.CommonUtils.isNotEmpty;
import static org.jooq.impl.DSL.currentTimestamp;

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

    /**
     * WishList 등록 중복 체크
     */
    public boolean wishInfoOverLapChk(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext.selectCount()
                .from(TB_WISH_MST)
                .where(TB_WISH_MST.PRODUCT_SEQ.eq(tbWishMstRecord.getProductSeq()))
                    .and(TB_WISH_MST.REG_USR_ID.eq(tbWishMstRecord.getRegUsrId())
                    .and(TB_WISH_MST.ASK_YN.eq("N"))
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
     * WishList 목록 조회
     */
    public List<Map<String, Object>> findAllForWishInfo(TbWishMstRecord tbWishMstRecord) {
        return this.dslContext
                .select(
                         TB_WISH_MST.WISH_SEQ
                        ,TB_PRD_MST.PRODUCT_SEQ
                        ,TB_PRD_MST.PRODUCT_NM
                        ,TB_CM_AFILE.URL_PATH_CD
                        ,TB_PRD_MST.RETAIL_PRICE
                        ,TB_MEM_MST.APPROVAL_YN
                )
                .from(TB_WISH_MST)
                .join(TB_PRD_MST)
                    .on(TB_WISH_MST.PRODUCT_SEQ.eq(TB_PRD_MST.PRODUCT_SEQ))
                .join(TB_CM_AFILE)
                    .on(TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ.eq(TB_CM_AFILE.AFILE_SEQ))
                .join(TB_MEM_MST)
                    .on(TB_WISH_MST.REG_USR_ID.eq(TB_MEM_MST.MEM_ID))
                .where(TB_WISH_MST.REG_USR_ID.eq(tbWishMstRecord.getRegUsrId())
                    .and(TB_WISH_MST.ASK_YN.eq("N"))
                    .and(TB_WISH_MST.DEL_YN.eq("N"))
                )
                .orderBy(TB_WISH_MST.REG_TS.desc())
                .fetchMaps();
    }

    /**
     * Inquiry 목록 조회(관리자)
     */
    public List<Map<String, Object>> findAllForInquiryInfo(TbInquiryMstRecord tbInquiryMstRecord) {
        return this.dslContext
                .select(
                        TB_INQUIRY_MST.INQUIRY_SEQ
                        ,TB_INQUIRY_MST.MESSAGE
                        ,TB_INQUIRY_MST.REG_USR_ID
                        ,TB_INQUIRY_MST.REG_TS
                        ,TB_INQUIRY_MST.UPD_USR_ID
                        ,TB_INQUIRY_MST.UPD_TS
                )
                .from(TB_INQUIRY_MST)
                .orderBy(TB_INQUIRY_MST.REG_TS.desc())
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
                .set(TB_INQUIRY_DTL.INQUIRY_SEQ, tbInquiryDtlRecord.getInquirySeq())
                .set(TB_INQUIRY_DTL.PRODUCT_SEQ, tbInquiryDtlRecord.getProductSeq())
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

}