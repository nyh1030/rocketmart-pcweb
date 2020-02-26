/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbPrdMst;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record22;
import org.jooq.Row22;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 상품 마스터
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbPrdMstRecord extends UpdatableRecordImpl<TbPrdMstRecord> implements Record22<Integer, String, String, String, String, String, String, String, String, String, Long, Integer, String, String, String, String, String, String, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = 2026310657;

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public void setProductSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public Integer getProductSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_NM</code>. 상품명
     */
    public void setProductNm(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_NM</code>. 상품명
     */
    public String getProductNm() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public void setCate1Cd(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public String getCate1Cd() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public void setCate2Cd(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public String getCate2Cd() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public void setCate3Cd(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public String getCate3Cd() {
        return (String) get(4);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_URL</code>. 상품소개영상 URL
     */
    public void setProductUrl(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_URL</code>. 상품소개영상 URL
     */
    public String getProductUrl() {
        return (String) get(5);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_CAPACITY</code>. 상품 용량
     */
    public void setProductCapacity(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_CAPACITY</code>. 상품 용량
     */
    public String getProductCapacity() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_LINEUP</code>. 상품 색상/라인업
     */
    public void setProductLineup(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_LINEUP</code>. 상품 색상/라인업
     */
    public String getProductLineup() {
        return (String) get(7);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.SELLER_NOTE</code>. SELLER 노트
     */
    public void setSellerNote(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.SELLER_NOTE</code>. SELLER 노트
     */
    public String getSellerNote() {
        return (String) get(8);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_CONTENT</code>. 상품상세설명
     */
    public void setProductContent(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_CONTENT</code>. 상품상세설명
     */
    public String getProductContent() {
        return (String) get(9);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.RETAIL_PRICE</code>. 소비자가격(USD)
     */
    public void setRetailPrice(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.RETAIL_PRICE</code>. 소비자가격(USD)
     */
    public Long getRetailPrice() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.WHOLESALE_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public void setWholesaleSeq(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.WHOLESALE_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public Integer getWholesaleSeq() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.GIVE_SAMPLE_YN</code>. 무료 샘플 제공 여부
     */
    public void setGiveSampleYn(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.GIVE_SAMPLE_YN</code>. 무료 샘플 제공 여부
     */
    public String getGiveSampleYn() {
        return (String) get(12);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_ATRBT</code>. 상품 속성
     */
    public void setProductAtrbt(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_ATRBT</code>. 상품 속성
     */
    public String getProductAtrbt() {
        return (String) get(13);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.PRODUCT_CRT</code>. 상품 인증
     */
    public void setProductCrt(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.PRODUCT_CRT</code>. 상품 인증
     */
    public String getProductCrt() {
        return (String) get(14);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.EXPORT_HST</code>. 수출이력
     */
    public void setExportHst(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.EXPORT_HST</code>. 수출이력
     */
    public String getExportHst() {
        return (String) get(15);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.TRADING_CONDITIONS</code>. 가능한거래조건
     */
    public void setTradingConditions(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.TRADING_CONDITIONS</code>. 가능한거래조건
     */
    public String getTradingConditions() {
        return (String) get(16);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.DEL_YN</code>. 삭제여부
     */
    public void setDelYn(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.DEL_YN</code>. 삭제여부
     */
    public String getDelYn() {
        return (String) get(17);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.REG_USR_ID</code>. 등록자ID
     */
    public void setRegUsrId(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.REG_USR_ID</code>. 등록자ID
     */
    public String getRegUsrId() {
        return (String) get(18);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(19, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
        return (Timestamp) get(19);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.UPD_USR_ID</code>. 수정자ID
     */
    public void setUpdUsrId(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.UPD_USR_ID</code>. 수정자ID
     */
    public String getUpdUsrId() {
        return (String) get(20);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_MST.UPD_TS</code>. 수정일시
     */
    public void setUpdTs(Timestamp value) {
        set(21, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_MST.UPD_TS</code>. 수정일시
     */
    public Timestamp getUpdTs() {
        return (Timestamp) get(21);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record22 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row22<Integer, String, String, String, String, String, String, String, String, String, Long, Integer, String, String, String, String, String, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row22) super.fieldsRow();
    }

    @Override
    public Row22<Integer, String, String, String, String, String, String, String, String, String, Long, Integer, String, String, String, String, String, String, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row22) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_SEQ;
    }

    @Override
    public Field<String> field2() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_NM;
    }

    @Override
    public Field<String> field3() {
        return TbPrdMst.TB_PRD_MST.CATE1_CD;
    }

    @Override
    public Field<String> field4() {
        return TbPrdMst.TB_PRD_MST.CATE2_CD;
    }

    @Override
    public Field<String> field5() {
        return TbPrdMst.TB_PRD_MST.CATE3_CD;
    }

    @Override
    public Field<String> field6() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_URL;
    }

    @Override
    public Field<String> field7() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_CAPACITY;
    }

    @Override
    public Field<String> field8() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_LINEUP;
    }

    @Override
    public Field<String> field9() {
        return TbPrdMst.TB_PRD_MST.SELLER_NOTE;
    }

    @Override
    public Field<String> field10() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_CONTENT;
    }

    @Override
    public Field<Long> field11() {
        return TbPrdMst.TB_PRD_MST.RETAIL_PRICE;
    }

    @Override
    public Field<Integer> field12() {
        return TbPrdMst.TB_PRD_MST.WHOLESALE_SEQ;
    }

    @Override
    public Field<String> field13() {
        return TbPrdMst.TB_PRD_MST.GIVE_SAMPLE_YN;
    }

    @Override
    public Field<String> field14() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_ATRBT;
    }

    @Override
    public Field<String> field15() {
        return TbPrdMst.TB_PRD_MST.PRODUCT_CRT;
    }

    @Override
    public Field<String> field16() {
        return TbPrdMst.TB_PRD_MST.EXPORT_HST;
    }

    @Override
    public Field<String> field17() {
        return TbPrdMst.TB_PRD_MST.TRADING_CONDITIONS;
    }

    @Override
    public Field<String> field18() {
        return TbPrdMst.TB_PRD_MST.DEL_YN;
    }

    @Override
    public Field<String> field19() {
        return TbPrdMst.TB_PRD_MST.REG_USR_ID;
    }

    @Override
    public Field<Timestamp> field20() {
        return TbPrdMst.TB_PRD_MST.REG_TS;
    }

    @Override
    public Field<String> field21() {
        return TbPrdMst.TB_PRD_MST.UPD_USR_ID;
    }

    @Override
    public Field<Timestamp> field22() {
        return TbPrdMst.TB_PRD_MST.UPD_TS;
    }

    @Override
    public Integer component1() {
        return getProductSeq();
    }

    @Override
    public String component2() {
        return getProductNm();
    }

    @Override
    public String component3() {
        return getCate1Cd();
    }

    @Override
    public String component4() {
        return getCate2Cd();
    }

    @Override
    public String component5() {
        return getCate3Cd();
    }

    @Override
    public String component6() {
        return getProductUrl();
    }

    @Override
    public String component7() {
        return getProductCapacity();
    }

    @Override
    public String component8() {
        return getProductLineup();
    }

    @Override
    public String component9() {
        return getSellerNote();
    }

    @Override
    public String component10() {
        return getProductContent();
    }

    @Override
    public Long component11() {
        return getRetailPrice();
    }

    @Override
    public Integer component12() {
        return getWholesaleSeq();
    }

    @Override
    public String component13() {
        return getGiveSampleYn();
    }

    @Override
    public String component14() {
        return getProductAtrbt();
    }

    @Override
    public String component15() {
        return getProductCrt();
    }

    @Override
    public String component16() {
        return getExportHst();
    }

    @Override
    public String component17() {
        return getTradingConditions();
    }

    @Override
    public String component18() {
        return getDelYn();
    }

    @Override
    public String component19() {
        return getRegUsrId();
    }

    @Override
    public Timestamp component20() {
        return getRegTs();
    }

    @Override
    public String component21() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp component22() {
        return getUpdTs();
    }

    @Override
    public Integer value1() {
        return getProductSeq();
    }

    @Override
    public String value2() {
        return getProductNm();
    }

    @Override
    public String value3() {
        return getCate1Cd();
    }

    @Override
    public String value4() {
        return getCate2Cd();
    }

    @Override
    public String value5() {
        return getCate3Cd();
    }

    @Override
    public String value6() {
        return getProductUrl();
    }

    @Override
    public String value7() {
        return getProductCapacity();
    }

    @Override
    public String value8() {
        return getProductLineup();
    }

    @Override
    public String value9() {
        return getSellerNote();
    }

    @Override
    public String value10() {
        return getProductContent();
    }

    @Override
    public Long value11() {
        return getRetailPrice();
    }

    @Override
    public Integer value12() {
        return getWholesaleSeq();
    }

    @Override
    public String value13() {
        return getGiveSampleYn();
    }

    @Override
    public String value14() {
        return getProductAtrbt();
    }

    @Override
    public String value15() {
        return getProductCrt();
    }

    @Override
    public String value16() {
        return getExportHst();
    }

    @Override
    public String value17() {
        return getTradingConditions();
    }

    @Override
    public String value18() {
        return getDelYn();
    }

    @Override
    public String value19() {
        return getRegUsrId();
    }

    @Override
    public Timestamp value20() {
        return getRegTs();
    }

    @Override
    public String value21() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp value22() {
        return getUpdTs();
    }

    @Override
    public TbPrdMstRecord value1(Integer value) {
        setProductSeq(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value2(String value) {
        setProductNm(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value3(String value) {
        setCate1Cd(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value4(String value) {
        setCate2Cd(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value5(String value) {
        setCate3Cd(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value6(String value) {
        setProductUrl(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value7(String value) {
        setProductCapacity(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value8(String value) {
        setProductLineup(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value9(String value) {
        setSellerNote(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value10(String value) {
        setProductContent(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value11(Long value) {
        setRetailPrice(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value12(Integer value) {
        setWholesaleSeq(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value13(String value) {
        setGiveSampleYn(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value14(String value) {
        setProductAtrbt(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value15(String value) {
        setProductCrt(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value16(String value) {
        setExportHst(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value17(String value) {
        setTradingConditions(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value18(String value) {
        setDelYn(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value19(String value) {
        setRegUsrId(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value20(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value21(String value) {
        setUpdUsrId(value);
        return this;
    }

    @Override
    public TbPrdMstRecord value22(Timestamp value) {
        setUpdTs(value);
        return this;
    }

    @Override
    public TbPrdMstRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, Long value11, Integer value12, String value13, String value14, String value15, String value16, String value17, String value18, String value19, Timestamp value20, String value21, Timestamp value22) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        value22(value22);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbPrdMstRecord
     */
    public TbPrdMstRecord() {
        super(TbPrdMst.TB_PRD_MST);
    }

    /**
     * Create a detached, initialised TbPrdMstRecord
     */
    public TbPrdMstRecord(Integer productSeq, String productNm, String cate1Cd, String cate2Cd, String cate3Cd, String productUrl, String productCapacity, String productLineup, String sellerNote, String productContent, Long retailPrice, Integer wholesaleSeq, String giveSampleYn, String productAtrbt, String productCrt, String exportHst, String tradingConditions, String delYn, String regUsrId, Timestamp regTs, String updUsrId, Timestamp updTs) {
        super(TbPrdMst.TB_PRD_MST);

        set(0, productSeq);
        set(1, productNm);
        set(2, cate1Cd);
        set(3, cate2Cd);
        set(4, cate3Cd);
        set(5, productUrl);
        set(6, productCapacity);
        set(7, productLineup);
        set(8, sellerNote);
        set(9, productContent);
        set(10, retailPrice);
        set(11, wholesaleSeq);
        set(12, giveSampleYn);
        set(13, productAtrbt);
        set(14, productCrt);
        set(15, exportHst);
        set(16, tradingConditions);
        set(17, delYn);
        set(18, regUsrId);
        set(19, regTs);
        set(20, updUsrId);
        set(21, updTs);
    }
}