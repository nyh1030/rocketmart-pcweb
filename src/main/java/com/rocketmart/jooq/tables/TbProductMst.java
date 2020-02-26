/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbProductMstRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row17;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TbProductMst extends TableImpl<TbProductMstRecord> {

    private static final long serialVersionUID = 1122470959;

    /**
     * The reference instance of <code>rocketmart.TB_PRODUCT_MST</code>
     */
    public static final TbProductMst TB_PRODUCT_MST = new TbProductMst();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbProductMstRecord> getRecordType() {
        return TbProductMstRecord.class;
    }

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public final TableField<TbProductMstRecord, Integer> PRODUCT_SEQ = createField(DSL.name("PRODUCT_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "상품 일련번호");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_NM</code>. 상품명
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_NM = createField(DSL.name("PRODUCT_NM"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품명");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public final TableField<TbProductMstRecord, String> CATE1_CD = createField(DSL.name("CATE1_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리1 코드");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public final TableField<TbProductMstRecord, String> CATE2_CD = createField(DSL.name("CATE2_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리2 코드");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public final TableField<TbProductMstRecord, String> CATE3_CD = createField(DSL.name("CATE3_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리3 코드");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_URL</code>. 상품소개영상 URL
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_URL = createField(DSL.name("PRODUCT_URL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품소개영상 URL");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_CAPACITY</code>. 상품 용량
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_CAPACITY = createField(DSL.name("PRODUCT_CAPACITY"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 용량");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_LINEUP</code>. 상품 색상/라인업
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_LINEUP = createField(DSL.name("PRODUCT_LINEUP"), org.jooq.impl.SQLDataType.VARCHAR(1000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 색상/라인업");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.SELLER_NOTE</code>. SELLER 노트
     */
    public final TableField<TbProductMstRecord, String> SELLER_NOTE = createField(DSL.name("SELLER_NOTE"), org.jooq.impl.SQLDataType.VARCHAR(4000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "SELLER 노트");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_CONTENT</code>. 상품상세설명
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_CONTENT = createField(DSL.name("PRODUCT_CONTENT"), org.jooq.impl.SQLDataType.VARCHAR(4000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품상세설명");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.RETAIL_PRICE</code>. 소비자가격(USD)
     */
    public final TableField<TbProductMstRecord, Double> RETAIL_PRICE = createField(DSL.name("RETAIL_PRICE"), org.jooq.impl.SQLDataType.DOUBLE.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.DOUBLE)), this, "소비자가격(USD)");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.WHOLESALE_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public final TableField<TbProductMstRecord, Integer> WHOLESALE_SEQ = createField(DSL.name("WHOLESALE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "도매가격(FOB) 일련번호");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.GIVE_SAMPLE_YN</code>. 무료 샘플 제공 여부
     */
    public final TableField<TbProductMstRecord, String> GIVE_SAMPLE_YN = createField(DSL.name("GIVE_SAMPLE_YN"), org.jooq.impl.SQLDataType.CHAR(1).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.CHAR)), this, "무료 샘플 제공 여부");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_ATRBT</code>. 상품 속성
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_ATRBT = createField(DSL.name("PRODUCT_ATRBT"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 속성");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.PRODUCT_CRT</code>. 상품 인증
     */
    public final TableField<TbProductMstRecord, String> PRODUCT_CRT = createField(DSL.name("PRODUCT_CRT"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 인증");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.EXPORT_HST</code>. 수출이력
     */
    public final TableField<TbProductMstRecord, String> EXPORT_HST = createField(DSL.name("EXPORT_HST"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "수출이력");

    /**
     * The column <code>rocketmart.TB_PRODUCT_MST.TRADING_CONDITIONS</code>. 가능한거래조건
     */
    public final TableField<TbProductMstRecord, String> TRADING_CONDITIONS = createField(DSL.name("TRADING_CONDITIONS"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "가능한거래조건");

    /**
     * Create a <code>rocketmart.TB_PRODUCT_MST</code> table reference
     */
    public TbProductMst() {
        this(DSL.name("TB_PRODUCT_MST"), null);
    }

    /**
     * Create an aliased <code>rocketmart.TB_PRODUCT_MST</code> table reference
     */
    public TbProductMst(String alias) {
        this(DSL.name(alias), TB_PRODUCT_MST);
    }

    /**
     * Create an aliased <code>rocketmart.TB_PRODUCT_MST</code> table reference
     */
    public TbProductMst(Name alias) {
        this(alias, TB_PRODUCT_MST);
    }

    private TbProductMst(Name alias, Table<TbProductMstRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbProductMst(Name alias, Table<TbProductMstRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("상품 마스터"));
    }

    public <O extends Record> TbProductMst(Table<O> child, ForeignKey<O, TbProductMstRecord> key) {
        super(child, key, TB_PRODUCT_MST);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_PRODUCT_MST_PRIMARY);
    }

    @Override
    public Identity<TbProductMstRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_PRODUCT_MST;
    }

    @Override
    public UniqueKey<TbProductMstRecord> getPrimaryKey() {
        return Keys.KEY_TB_PRODUCT_MST_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbProductMstRecord>> getKeys() {
        return Arrays.<UniqueKey<TbProductMstRecord>>asList(Keys.KEY_TB_PRODUCT_MST_PRIMARY);
    }

    @Override
    public TbProductMst as(String alias) {
        return new TbProductMst(DSL.name(alias), this);
    }

    @Override
    public TbProductMst as(Name alias) {
        return new TbProductMst(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbProductMst rename(String name) {
        return new TbProductMst(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbProductMst rename(Name name) {
        return new TbProductMst(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, String, String, String, String, String, String, String, String, String, Double, Integer, String, String, String, String, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}