/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbBrandFile;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 브랜드_파일
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbBrandFileRecord extends UpdatableRecordImpl<TbBrandFileRecord> implements Record8<Integer, String, String, String, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = -344436063;

    /**
     * Setter for <code>rocketmart.tb_brand_file.FILE_SEQ</code>. 파일 일련번호
     */
    public void setFileSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.FILE_SEQ</code>. 파일 일련번호
     */
    public Integer getFileSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.STORED_FILE_NM</code>. 저장된 파일명
     */
    public void setStoredFileNm(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.STORED_FILE_NM</code>. 저장된 파일명
     */
    public String getStoredFileNm() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.REAL_FILE_NM</code>. 실제 파일명
     */
    public void setRealFileNm(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.REAL_FILE_NM</code>. 실제 파일명
     */
    public String getRealFileNm() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.FILE_EXTENSIONS</code>. 파일 확장자
     */
    public void setFileExtensions(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.FILE_EXTENSIONS</code>. 파일 확장자
     */
    public String getFileExtensions() {
        return (String) get(3);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.REG_USR_ID</code>. 등록자 아이디
     */
    public void setRegUsrId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.REG_USR_ID</code>. 등록자 아이디
     */
    public String getRegUsrId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.REG_TS</code>. 등록일시
     */
    public void setRegTs(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.REG_TS</code>. 등록일시
     */
    public Timestamp getRegTs() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.UPD_USR_ID</code>. 수정자 아이디
     */
    public void setUpdUsrId(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.UPD_USR_ID</code>. 수정자 아이디
     */
    public String getUpdUsrId() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rocketmart.tb_brand_file.UPD_TS</code>. 수정일시
     */
    public void setUpdTs(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>rocketmart.tb_brand_file.UPD_TS</code>. 수정일시
     */
    public Timestamp getUpdTs() {
        return (Timestamp) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Integer, String, String, String, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbBrandFile.TB_BRAND_FILE.FILE_SEQ;
    }

    @Override
    public Field<String> field2() {
        return TbBrandFile.TB_BRAND_FILE.STORED_FILE_NM;
    }

    @Override
    public Field<String> field3() {
        return TbBrandFile.TB_BRAND_FILE.REAL_FILE_NM;
    }

    @Override
    public Field<String> field4() {
        return TbBrandFile.TB_BRAND_FILE.FILE_EXTENSIONS;
    }

    @Override
    public Field<String> field5() {
        return TbBrandFile.TB_BRAND_FILE.REG_USR_ID;
    }

    @Override
    public Field<Timestamp> field6() {
        return TbBrandFile.TB_BRAND_FILE.REG_TS;
    }

    @Override
    public Field<String> field7() {
        return TbBrandFile.TB_BRAND_FILE.UPD_USR_ID;
    }

    @Override
    public Field<Timestamp> field8() {
        return TbBrandFile.TB_BRAND_FILE.UPD_TS;
    }

    @Override
    public Integer component1() {
        return getFileSeq();
    }

    @Override
    public String component2() {
        return getStoredFileNm();
    }

    @Override
    public String component3() {
        return getRealFileNm();
    }

    @Override
    public String component4() {
        return getFileExtensions();
    }

    @Override
    public String component5() {
        return getRegUsrId();
    }

    @Override
    public Timestamp component6() {
        return getRegTs();
    }

    @Override
    public String component7() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp component8() {
        return getUpdTs();
    }

    @Override
    public Integer value1() {
        return getFileSeq();
    }

    @Override
    public String value2() {
        return getStoredFileNm();
    }

    @Override
    public String value3() {
        return getRealFileNm();
    }

    @Override
    public String value4() {
        return getFileExtensions();
    }

    @Override
    public String value5() {
        return getRegUsrId();
    }

    @Override
    public Timestamp value6() {
        return getRegTs();
    }

    @Override
    public String value7() {
        return getUpdUsrId();
    }

    @Override
    public Timestamp value8() {
        return getUpdTs();
    }

    @Override
    public TbBrandFileRecord value1(Integer value) {
        setFileSeq(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value2(String value) {
        setStoredFileNm(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value3(String value) {
        setRealFileNm(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value4(String value) {
        setFileExtensions(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value5(String value) {
        setRegUsrId(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value6(Timestamp value) {
        setRegTs(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value7(String value) {
        setUpdUsrId(value);
        return this;
    }

    @Override
    public TbBrandFileRecord value8(Timestamp value) {
        setUpdTs(value);
        return this;
    }

    @Override
    public TbBrandFileRecord values(Integer value1, String value2, String value3, String value4, String value5, Timestamp value6, String value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbBrandFileRecord
     */
    public TbBrandFileRecord() {
        super(TbBrandFile.TB_BRAND_FILE);
    }

    /**
     * Create a detached, initialised TbBrandFileRecord
     */
    public TbBrandFileRecord(Integer fileSeq, String storedFileNm, String realFileNm, String fileExtensions, String regUsrId, Timestamp regTs, String updUsrId, Timestamp updTs) {
        super(TbBrandFile.TB_BRAND_FILE);

        set(0, fileSeq);
        set(1, storedFileNm);
        set(2, realFileNm);
        set(3, fileExtensions);
        set(4, regUsrId);
        set(5, regTs);
        set(6, updUsrId);
        set(7, updTs);
    }
}