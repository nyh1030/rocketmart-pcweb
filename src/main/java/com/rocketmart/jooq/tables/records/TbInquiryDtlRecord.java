/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbInquiryDtl;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 상품 문의내역 상세
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbInquiryDtlRecord extends UpdatableRecordImpl<TbInquiryDtlRecord> implements Record7<Integer, Integer, String, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = 601069011;

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.INQUIRY_DTL_SEQ</code>. 상품문의 상세 일련번호
     */
    public void setInquiryDtlSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.INQUIRY_DTL_SEQ</code>. 상품문의 상세 일련번호
     */
    public Integer getInquiryDtlSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public void setProductSeq(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public Integer getProductSeq() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.MESSAGE</code>. 문의내용
     */
    public void setMessage(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.MESSAGE</code>. 문의내용
     */
    public String getMessage() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.REG_USR_ID</code>. 등록자아이디
     */
    public void setRegUsrId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.REG_USR_ID</code>. 등록자아이디
     */
    public String getRegUsrId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.UPD_USR_ID</code>. 수정자아이디
     */
    public void setUpdUsrId(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.UPD_USR_ID</code>. 수정자아이디
     */
    public String getUpdUsrId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>rocketmart.TB_INQUIRY_DTL.UPD_TS</code>. 수정일시
     */
    public void setUpdTs(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.TB_INQUIRY_DTL.UPD_TS</code>. 수정일시
     */
    public Timestamp getUpdTs() {
        return (Timestamp) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, Integer, String, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbInquiryDtl.TB_INQUIRY_DTL.INQUIRY_DTL_SEQ;
    }

    @Override
    public Field<Integer> field2() {
        return TbInquiryDtl.TB_INQUIRY_DTL.PRODUCT_SEQ;
    }

    @Override
    public Field<String> field3() {
        return TbInquiryDtl.TB_INQUIRY_DTL.MESSAGE;
    }

    @Override
    public Field<String> field4() {
        return TbInquiryDtl.TB_INQUIRY_DTL.REG_USR_ID;
    }

    @Override
    public Field<Timestamp> field5() {
        return TbInquiryDtl.TB_INQUIRY_DTL.REG_TS;
    }

    @Override
    public Field<String> field6() {
        return TbInquiryDtl.TB_INQUIRY_DTL.UPD_USR_ID;
    }

    @Override
    public Field<Timestamp> field7() {
        return TbInquiryDtl.TB_INQUIRY_DTL.UPD_TS;
    }

    @Override
    public Integer component1() {
        return getInquiryDtlSeq();
    }

    @Override
    public Integer component2() {
        return getProductSeq();
    }

    @Override
    public String component3() {
        return getMessage();
    }

    @Override
    public String component4() {
        return getRegUsrId();
    }

    @Override
    public Timestamp component5() {
        return getRegTs();
    }

    @Override
    public String component6() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp component7() {
        return getUpdTs();
    }

    @Override
    public Integer value1() {
        return getInquiryDtlSeq();
    }

    @Override
    public Integer value2() {
        return getProductSeq();
    }

    @Override
    public String value3() {
        return getMessage();
    }

    @Override
    public String value4() {
        return getRegUsrId();
    }

    @Override
    public Timestamp value5() {
        return getRegTs();
    }

    @Override
    public String value6() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp value7() {
        return getUpdTs();
    }

    @Override
    public TbInquiryDtlRecord value1(Integer value) {
        setInquiryDtlSeq(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value2(Integer value) {
        setProductSeq(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value3(String value) {
        setMessage(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value4(String value) {
        setRegUsrId(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value5(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value6(String value) {
        setUpdUsrId(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord value7(Timestamp value) {
        setUpdTs(value);
        return this;
    }

    @Override
    public TbInquiryDtlRecord values(Integer value1, Integer value2, String value3, String value4, Timestamp value5, String value6, Timestamp value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbInquiryDtlRecord
     */
    public TbInquiryDtlRecord() {
        super(TbInquiryDtl.TB_INQUIRY_DTL);
    }

    /**
     * Create a detached, initialised TbInquiryDtlRecord
     */
    public TbInquiryDtlRecord(Integer inquiryDtlSeq, Integer productSeq, String message, String regUsrId, Timestamp regTs, String updUsrId, Timestamp updTs) {
        super(TbInquiryDtl.TB_INQUIRY_DTL);

        set(0, inquiryDtlSeq);
        set(1, productSeq);
        set(2, message);
        set(3, regUsrId);
        set(4, regTs);
        set(5, updUsrId);
        set(6, updTs);
    }
}
