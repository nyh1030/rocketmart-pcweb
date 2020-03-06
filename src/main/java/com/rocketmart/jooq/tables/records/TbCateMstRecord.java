/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbCateMst;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 카테고리_정보
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbCateMstRecord extends UpdatableRecordImpl<TbCateMstRecord> implements Record13<Integer, String, String, String, String, String, String, Integer, String, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = 2120580090;

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE_SEQ</code>. 카테고리 일련번호
     */
    public void setCateSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE_SEQ</code>. 카테고리 일련번호
     */
    public Integer getCateSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public void setCate1Cd(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public String getCate1Cd() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE1_NM</code>. 카테고리1 명
     */
    public void setCate1Nm(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE1_NM</code>. 카테고리1 명
     */
    public String getCate1Nm() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public void setCate2Cd(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public String getCate2Cd() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE2_NM</code>. 카테고리2 명
     */
    public void setCate2Nm(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE2_NM</code>. 카테고리2 명
     */
    public String getCate2Nm() {
        return (String) get(4);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public void setCate3Cd(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public String getCate3Cd() {
        return (String) get(5);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.CATE3_NM</code>. 카테고리3 명
     */
    public void setCate3Nm(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.CATE3_NM</code>. 카테고리3 명
     */
    public String getCate3Nm() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.DEPTH</code>. DEPTH
     */
    public void setDepth(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.DEPTH</code>. DEPTH
     */
    public Integer getDepth() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.DEL_YN</code>. 삭제여부
     */
    public void setDelYn(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.DEL_YN</code>. 삭제여부
     */
    public String getDelYn() {
        return (String) get(8);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.REG_USR_ID</code>. 등록자 아이디
     */
    public void setRegUsrId(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.REG_USR_ID</code>. 등록자 아이디
     */
    public String getRegUsrId() {
        return (String) get(9);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.UPD_USR_ID</code>. 수정자 아이디
     */
    public void setUpdUsrId(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.UPD_USR_ID</code>. 수정자 아이디
     */
    public String getUpdUsrId() {
        return (String) get(11);
    }

    /**
     * Setter for <code>rocketmart.TB_CATE_MST.UPD_TS</code>. 수정일시
     */
    public void setUpdTs(Timestamp value) {
        set(12, value);
    }

    /**
     * Getter for <code>rocketmart.TB_CATE_MST.UPD_TS</code>. 수정일시
     */
    public Timestamp getUpdTs() {
        return (Timestamp) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, String, String, String, String, String, Integer, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Integer, String, String, String, String, String, String, Integer, String, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbCateMst.TB_CATE_MST.CATE_SEQ;
    }

    @Override
    public Field<String> field2() {
        return TbCateMst.TB_CATE_MST.CATE1_CD;
    }

    @Override
    public Field<String> field3() {
        return TbCateMst.TB_CATE_MST.CATE1_NM;
    }

    @Override
    public Field<String> field4() {
        return TbCateMst.TB_CATE_MST.CATE2_CD;
    }

    @Override
    public Field<String> field5() {
        return TbCateMst.TB_CATE_MST.CATE2_NM;
    }

    @Override
    public Field<String> field6() {
        return TbCateMst.TB_CATE_MST.CATE3_CD;
    }

    @Override
    public Field<String> field7() {
        return TbCateMst.TB_CATE_MST.CATE3_NM;
    }

    @Override
    public Field<Integer> field8() {
        return TbCateMst.TB_CATE_MST.DEPTH;
    }

    @Override
    public Field<String> field9() {
        return TbCateMst.TB_CATE_MST.DEL_YN;
    }

    @Override
    public Field<String> field10() {
        return TbCateMst.TB_CATE_MST.REG_USR_ID;
    }

    @Override
    public Field<Timestamp> field11() {
        return TbCateMst.TB_CATE_MST.REG_TS;
    }

    @Override
    public Field<String> field12() {
        return TbCateMst.TB_CATE_MST.UPD_USR_ID;
    }

    @Override
    public Field<Timestamp> field13() {
        return TbCateMst.TB_CATE_MST.UPD_TS;
    }

    @Override
    public Integer component1() {
        return getCateSeq();
    }

    @Override
    public String component2() {
        return getCate1Cd();
    }

    @Override
    public String component3() {
        return getCate1Nm();
    }

    @Override
    public String component4() {
        return getCate2Cd();
    }

    @Override
    public String component5() {
        return getCate2Nm();
    }

    @Override
    public String component6() {
        return getCate3Cd();
    }

    @Override
    public String component7() {
        return getCate3Nm();
    }

    @Override
    public Integer component8() {
        return getDepth();
    }

    @Override
    public String component9() {
        return getDelYn();
    }

    @Override
    public String component10() {
        return getRegUsrId();
    }

    @Override
    public Timestamp component11() {
        return getRegTs();
    }

    @Override
    public String component12() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp component13() {
        return getUpdTs();
    }

    @Override
    public Integer value1() {
        return getCateSeq();
    }

    @Override
    public String value2() {
        return getCate1Cd();
    }

    @Override
    public String value3() {
        return getCate1Nm();
    }

    @Override
    public String value4() {
        return getCate2Cd();
    }

    @Override
    public String value5() {
        return getCate2Nm();
    }

    @Override
    public String value6() {
        return getCate3Cd();
    }

    @Override
    public String value7() {
        return getCate3Nm();
    }

    @Override
    public Integer value8() {
        return getDepth();
    }

    @Override
    public String value9() {
        return getDelYn();
    }

    @Override
    public String value10() {
        return getRegUsrId();
    }

    @Override
    public Timestamp value11() {
        return getRegTs();
    }

    @Override
    public String value12() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp value13() {
        return getUpdTs();
    }

    @Override
    public TbCateMstRecord value1(Integer value) {
        setCateSeq(value);
        return this;
    }

    @Override
    public TbCateMstRecord value2(String value) {
        setCate1Cd(value);
        return this;
    }

    @Override
    public TbCateMstRecord value3(String value) {
        setCate1Nm(value);
        return this;
    }

    @Override
    public TbCateMstRecord value4(String value) {
        setCate2Cd(value);
        return this;
    }

    @Override
    public TbCateMstRecord value5(String value) {
        setCate2Nm(value);
        return this;
    }

    @Override
    public TbCateMstRecord value6(String value) {
        setCate3Cd(value);
        return this;
    }

    @Override
    public TbCateMstRecord value7(String value) {
        setCate3Nm(value);
        return this;
    }

    @Override
    public TbCateMstRecord value8(Integer value) {
        setDepth(value);
        return this;
    }

    @Override
    public TbCateMstRecord value9(String value) {
        setDelYn(value);
        return this;
    }

    @Override
    public TbCateMstRecord value10(String value) {
        setRegUsrId(value);
        return this;
    }

    @Override
    public TbCateMstRecord value11(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbCateMstRecord value12(String value) {
        setUpdUsrId(value);
        return this;
    }

    @Override
    public TbCateMstRecord value13(Timestamp value) {
        setUpdTs(value);
        return this;
    }

    @Override
    public TbCateMstRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, Integer value8, String value9, String value10, Timestamp value11, String value12, Timestamp value13) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbCateMstRecord
     */
    public TbCateMstRecord() {
        super(TbCateMst.TB_CATE_MST);
    }

    /**
     * Create a detached, initialised TbCateMstRecord
     */
    public TbCateMstRecord(Integer cateSeq, String cate1Cd, String cate1Nm, String cate2Cd, String cate2Nm, String cate3Cd, String cate3Nm, Integer depth, String delYn, String regUsrId, Timestamp regTs, String updUsrId, Timestamp updTs) {
        super(TbCateMst.TB_CATE_MST);

        set(0, cateSeq);
        set(1, cate1Cd);
        set(2, cate1Nm);
        set(3, cate2Cd);
        set(4, cate2Nm);
        set(5, cate3Cd);
        set(6, cate3Nm);
        set(7, depth);
        set(8, delYn);
        set(9, regUsrId);
        set(10, regTs);
        set(11, updUsrId);
        set(12, updTs);
    }
}