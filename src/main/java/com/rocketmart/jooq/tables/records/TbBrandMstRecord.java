/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbBrandMst;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 브랜드_정보
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbBrandMstRecord extends UpdatableRecordImpl<TbBrandMstRecord> implements Record14<Integer, String, String, String, String, String, String, String, String, Integer, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = -540235739;

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_SEQ</code>. 브랜드 일련번호
     */
    public void setBrandSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_SEQ</code>. 브랜드 일련번호
     */
    public Integer getBrandSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_NM</code>. 브랜드명
     */
    public void setBrandNm(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_NM</code>. 브랜드명
     */
    public String getBrandNm() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_LOGO</code>. 브랜드 로고
     */
    public void setBrandLogo(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_LOGO</code>. 브랜드 로고
     */
    public String getBrandLogo() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_OWNERSHIP</code>. 브랜드 오너십
     */
    public void setBrandOwnership(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_OWNERSHIP</code>. 브랜드 오너십
     */
    public String getBrandOwnership() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_HOMEPAGE_URL</code>. 브랜드 홈페이지URL
     */
    public void setBrandHomepageUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_HOMEPAGE_URL</code>. 브랜드 홈페이지URL
     */
    public String getBrandHomepageUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_YOUTUBE_URL</code>. 브랜드 유튜브URL
     */
    public void setBrandYoutubeUrl(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_YOUTUBE_URL</code>. 브랜드 유튜브URL
     */
    public String getBrandYoutubeUrl() {
        return (String) get(5);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_INSTAGRAM_URL</code>. 브랜드 인스타그램URL
     */
    public void setBrandInstagramUrl(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_INSTAGRAM_URL</code>. 브랜드 인스타그램URL
     */
    public String getBrandInstagramUrl() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_CERIFY</code>. 브랜드 인증
     */
    public void setBrandCerify(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_CERIFY</code>. 브랜드 인증
     */
    public String getBrandCerify() {
        return (String) get(7);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.BRAND_INTRODUCTION</code>. 브랜드 소개
     */
    public void setBrandIntroduction(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.BRAND_INTRODUCTION</code>. 브랜드 소개
     */
    public String getBrandIntroduction() {
        return (String) get(8);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.AFILE_SEQ</code>. 파일첨부 일련번호
     */
    public void setAfileSeq(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.AFILE_SEQ</code>. 파일첨부 일련번호
     */
    public Integer getAfileSeq() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.REG_USR_ID</code>. 등록자 아이디
     */
    public void setRegUsrId(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.REG_USR_ID</code>. 등록자 아이디
     */
    public String getRegUsrId() {
        return (String) get(10);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
        return (Timestamp) get(11);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.UPD_USR_ID</code>. 수정자 아이디
     */
    public void setUpdUsrId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.UPD_USR_ID</code>. 수정자 아이디
     */
    public String getUpdUsrId() {
        return (String) get(12);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_mst.UPD_TS</code>. 수정일시
     */
    public void setUpdTs(Timestamp value) {
        set(13, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_mst.UPD_TS</code>. 수정일시
     */
    public Timestamp getUpdTs() {
        return (Timestamp) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<Integer, String, String, String, String, String, String, String, String, Integer, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<Integer, String, String, String, String, String, String, String, String, Integer, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbBrandMst.TB_BRAND_MST.BRAND_SEQ;
    }

    @Override
    public Field<String> field2() {
        return TbBrandMst.TB_BRAND_MST.BRAND_NM;
    }

    @Override
    public Field<String> field3() {
        return TbBrandMst.TB_BRAND_MST.BRAND_LOGO;
    }

    @Override
    public Field<String> field4() {
        return TbBrandMst.TB_BRAND_MST.BRAND_OWNERSHIP;
    }

    @Override
    public Field<String> field5() {
        return TbBrandMst.TB_BRAND_MST.BRAND_HOMEPAGE_URL;
    }

    @Override
    public Field<String> field6() {
        return TbBrandMst.TB_BRAND_MST.BRAND_YOUTUBE_URL;
    }

    @Override
    public Field<String> field7() {
        return TbBrandMst.TB_BRAND_MST.BRAND_INSTAGRAM_URL;
    }

    @Override
    public Field<String> field8() {
        return TbBrandMst.TB_BRAND_MST.BRAND_CERIFY;
    }

    @Override
    public Field<String> field9() {
        return TbBrandMst.TB_BRAND_MST.BRAND_INTRODUCTION;
    }

    @Override
    public Field<Integer> field10() {
        return TbBrandMst.TB_BRAND_MST.AFILE_SEQ;
    }

    @Override
    public Field<String> field11() {
        return TbBrandMst.TB_BRAND_MST.REG_USR_ID;
    }

    @Override
    public Field<Timestamp> field12() {
        return TbBrandMst.TB_BRAND_MST.REG_TS;
    }

    @Override
    public Field<String> field13() {
        return TbBrandMst.TB_BRAND_MST.UPD_USR_ID;
    }

    @Override
    public Field<Timestamp> field14() {
        return TbBrandMst.TB_BRAND_MST.UPD_TS;
    }

    @Override
    public Integer component1() {
        return getBrandSeq();
    }

    @Override
    public String component2() {
        return getBrandNm();
    }

    @Override
    public String component3() {
        return getBrandLogo();
    }

    @Override
    public String component4() {
        return getBrandOwnership();
    }

    @Override
    public String component5() {
        return getBrandHomepageUrl();
    }

    @Override
    public String component6() {
        return getBrandYoutubeUrl();
    }

    @Override
    public String component7() {
        return getBrandInstagramUrl();
    }

    @Override
    public String component8() {
        return getBrandCerify();
    }

    @Override
    public String component9() {
        return getBrandIntroduction();
    }

    @Override
    public Integer component10() {
        return getAfileSeq();
    }

    @Override
    public String component11() {
        return getRegUsrId();
    }

    @Override
    public Timestamp component12() {
        return getRegTs();
    }

    @Override
    public String component13() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp component14() {
        return getUpdTs();
    }

    @Override
    public Integer value1() {
        return getBrandSeq();
    }

    @Override
    public String value2() {
        return getBrandNm();
    }

    @Override
    public String value3() {
        return getBrandLogo();
    }

    @Override
    public String value4() {
        return getBrandOwnership();
    }

    @Override
    public String value5() {
        return getBrandHomepageUrl();
    }

    @Override
    public String value6() {
        return getBrandYoutubeUrl();
    }

    @Override
    public String value7() {
        return getBrandInstagramUrl();
    }

    @Override
    public String value8() {
        return getBrandCerify();
    }

    @Override
    public String value9() {
        return getBrandIntroduction();
    }

    @Override
    public Integer value10() {
        return getAfileSeq();
    }

    @Override
    public String value11() {
        return getRegUsrId();
    }

    @Override
    public Timestamp value12() {
        return getRegTs();
    }

    @Override
    public String value13() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp value14() {
        return getUpdTs();
    }

    @Override
    public TbBrandMstRecord value1(Integer value) {
        setBrandSeq(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value2(String value) {
        setBrandNm(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value3(String value) {
        setBrandLogo(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value4(String value) {
        setBrandOwnership(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value5(String value) {
        setBrandHomepageUrl(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value6(String value) {
        setBrandYoutubeUrl(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value7(String value) {
        setBrandInstagramUrl(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value8(String value) {
        setBrandCerify(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value9(String value) {
        setBrandIntroduction(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value10(Integer value) {
        setAfileSeq(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value11(String value) {
        setRegUsrId(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value12(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value13(String value) {
        setUpdUsrId(value);
        return this;
    }

    @Override
    public TbBrandMstRecord value14(Timestamp value) {
        setUpdTs(value);
        return this;
    }

    @Override
    public TbBrandMstRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, Integer value10, String value11, Timestamp value12, String value13, Timestamp value14) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbBrandMstRecord
     */
    public TbBrandMstRecord() {
        super(TbBrandMst.TB_BRAND_MST);
    }

    /**
     * Create a detached, initialised TbBrandMstRecord
     */
    public TbBrandMstRecord(Integer brandSeq, String brandNm, String brandLogo, String brandOwnership, String brandHomepageUrl, String brandYoutubeUrl, String brandInstagramUrl, String brandCerify, String brandIntroduction, Integer afileSeq, String regUsrId, Timestamp regTs, String updUsrId, Timestamp updTs) {
        super(TbBrandMst.TB_BRAND_MST);

        set(0, brandSeq);
        set(1, brandNm);
        set(2, brandLogo);
        set(3, brandOwnership);
        set(4, brandHomepageUrl);
        set(5, brandYoutubeUrl);
        set(6, brandInstagramUrl);
        set(7, brandCerify);
        set(8, brandIntroduction);
        set(9, afileSeq);
        set(10, regUsrId);
        set(11, regTs);
        set(12, updUsrId);
        set(13, updTs);
    }
}
