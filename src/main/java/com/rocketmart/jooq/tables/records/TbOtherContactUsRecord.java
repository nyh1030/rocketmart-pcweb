/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbOtherContactUs;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 관리자 문의
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbOtherContactUsRecord extends UpdatableRecordImpl<TbOtherContactUsRecord> implements Record7<Integer, String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = 1186843775;

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.CONTACT_SEQ</code>. 컨택 일련번호
     */
    public void setContactSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.CONTACT_SEQ</code>. 컨택 일련번호
     */
    public Integer getContactSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.USR_NM</code>. 문의자명
     */
    public void setUsrNm(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.USR_NM</code>. 문의자명
     */
    public String getUsrNm() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.EMAIL</code>. email
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.EMAIL</code>. email
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.COMPANY_NM</code>. 회사명
     */
    public void setCompanyNm(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.COMPANY_NM</code>. 회사명
     */
    public String getCompanyNm() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.SUBJECT</code>. 문의 제목
     */
    public void setSubject(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.SUBJECT</code>. 문의 제목
     */
    public String getSubject() {
        return (String) get(4);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.MESSAGE</code>. 문의 본문
     */
    public void setMessage(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.MESSAGE</code>. 문의 본문
     */
    public String getMessage() {
        return (String) get(5);
    }

    /**
     * Setter for <code>rocketmart.TB_OTHER_CONTACT_US.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.TB_OTHER_CONTACT_US.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
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
    public Row7<Integer, String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, String, String, Timestamp> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.CONTACT_SEQ;
    }

    @Override
    public Field<String> field2() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.USR_NM;
    }

    @Override
    public Field<String> field3() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.COMPANY_NM;
    }

    @Override
    public Field<String> field5() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.SUBJECT;
    }

    @Override
    public Field<String> field6() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.MESSAGE;
    }

    @Override
    public Field<Timestamp> field7() {
        return TbOtherContactUs.TB_OTHER_CONTACT_US.REG_TS;
    }

    @Override
    public Integer component1() {
        return getContactSeq();
    }

    @Override
    public String component2() {
        return getUsrNm();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getCompanyNm();
    }

    @Override
    public String component5() {
        return getSubject();
    }

    @Override
    public String component6() {
        return getMessage();
    }

    @Override
    public Timestamp component7() {
        return getRegTs();
    }

    @Override
    public Integer value1() {
        return getContactSeq();
    }

    @Override
    public String value2() {
        return getUsrNm();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getCompanyNm();
    }

    @Override
    public String value5() {
        return getSubject();
    }

    @Override
    public String value6() {
        return getMessage();
    }

    @Override
    public Timestamp value7() {
        return getRegTs();
    }

    @Override
    public TbOtherContactUsRecord value1(Integer value) {
        setContactSeq(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value2(String value) {
        setUsrNm(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value4(String value) {
        setCompanyNm(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value5(String value) {
        setSubject(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value6(String value) {
        setMessage(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord value7(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbOtherContactUsRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Timestamp value7) {
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
     * Create a detached TbOtherContactUsRecord
     */
    public TbOtherContactUsRecord() {
        super(TbOtherContactUs.TB_OTHER_CONTACT_US);
    }

    /**
     * Create a detached, initialised TbOtherContactUsRecord
     */
    public TbOtherContactUsRecord(Integer contactSeq, String usrNm, String email, String companyNm, String subject, String message, Timestamp regTs) {
        super(TbOtherContactUs.TB_OTHER_CONTACT_US);

        set(0, contactSeq);
        set(1, usrNm);
        set(2, email);
        set(3, companyNm);
        set(4, subject);
        set(5, message);
        set(6, regTs);
    }
}
