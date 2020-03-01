/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbPrdMstRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
public class TbPrdMst extends TableImpl<TbPrdMstRecord> {

    private static final long serialVersionUID = 796965288;

    /**
     * The reference instance of <code>rocketmart.TB_PRD_MST</code>
     */
    public static final TbPrdMst TB_PRD_MST = new TbPrdMst();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbPrdMstRecord> getRecordType() {
        return TbPrdMstRecord.class;
    }

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_SEQ = createField(DSL.name("PRODUCT_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "상품 일련번호");

    /**
     * The column <code>rocketmart.TB_PRD_MST.BRAND_SEQ</code>. 브랜드 일련번호
     */
    public final TableField<TbPrdMstRecord, Integer> BRAND_SEQ = createField(DSL.name("BRAND_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "브랜드 일련번호");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_NM</code>. 상품명
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_NM = createField(DSL.name("PRODUCT_NM"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품명");

    /**
     * The column <code>rocketmart.TB_PRD_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public final TableField<TbPrdMstRecord, String> CATE1_CD = createField(DSL.name("CATE1_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리1 코드");

    /**
     * The column <code>rocketmart.TB_PRD_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public final TableField<TbPrdMstRecord, String> CATE2_CD = createField(DSL.name("CATE2_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리2 코드");

    /**
     * The column <code>rocketmart.TB_PRD_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public final TableField<TbPrdMstRecord, String> CATE3_CD = createField(DSL.name("CATE3_CD"), org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리3 코드");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_URL</code>. 상품소개영상 URL
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_URL = createField(DSL.name("PRODUCT_URL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품소개영상 URL");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_CAPACITY</code>. 상품 용량
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_CAPACITY = createField(DSL.name("PRODUCT_CAPACITY"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 용량");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_LINEUP</code>. 상품 색상/라인업
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_LINEUP = createField(DSL.name("PRODUCT_LINEUP"), org.jooq.impl.SQLDataType.VARCHAR(1000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 색상/라인업");

    /**
     * The column <code>rocketmart.TB_PRD_MST.SELLER_NOTE</code>. SELLER 노트
     */
    public final TableField<TbPrdMstRecord, String> SELLER_NOTE = createField(DSL.name("SELLER_NOTE"), org.jooq.impl.SQLDataType.VARCHAR(4000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "SELLER 노트");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_CONTENT</code>. 상품상세설명
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_CONTENT = createField(DSL.name("PRODUCT_CONTENT"), org.jooq.impl.SQLDataType.VARCHAR(4000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품상세설명");

    /**
     * The column <code>rocketmart.TB_PRD_MST.RETAIL_PRICE</code>. 소비자가격(USD)
     */
    public final TableField<TbPrdMstRecord, Integer> RETAIL_PRICE = createField(DSL.name("RETAIL_PRICE"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "소비자가격(USD)");

    /**
     * The column <code>rocketmart.TB_PRD_MST.WHOLESALE_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public final TableField<TbPrdMstRecord, Integer> WHOLESALE_SEQ = createField(DSL.name("WHOLESALE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "도매가격(FOB) 일련번호");

    /**
     * The column <code>rocketmart.TB_PRD_MST.GIVE_SAMPLE_YN</code>. 무료 샘플 제공 여부
     */
    public final TableField<TbPrdMstRecord, String> GIVE_SAMPLE_YN = createField(DSL.name("GIVE_SAMPLE_YN"), org.jooq.impl.SQLDataType.CHAR(1).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.CHAR)), this, "무료 샘플 제공 여부");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_ATRBT</code>. 상품 속성
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_ATRBT = createField(DSL.name("PRODUCT_ATRBT"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 속성");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_CRT</code>. 상품 인증
     */
    public final TableField<TbPrdMstRecord, String> PRODUCT_CRT = createField(DSL.name("PRODUCT_CRT"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "상품 인증");

    /**
     * The column <code>rocketmart.TB_PRD_MST.EXPORT_HST</code>. 수출이력
     */
    public final TableField<TbPrdMstRecord, String> EXPORT_HST = createField(DSL.name("EXPORT_HST"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "수출이력");

    /**
     * The column <code>rocketmart.TB_PRD_MST.TRADING_CONDITIONS</code>. 가능한거래조건
     */
    public final TableField<TbPrdMstRecord, String> TRADING_CONDITIONS = createField(DSL.name("TRADING_CONDITIONS"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "가능한거래조건");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_FRONT_AFILE_SEQ</code>. 파일첨부 제품정면
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_FRONT_AFILE_SEQ = createField(DSL.name("PRODUCT_FRONT_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 제품정면");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_BACK_AFILE_SEQ</code>. 파일첨부 제품후면
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_BACK_AFILE_SEQ = createField(DSL.name("PRODUCT_BACK_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 제품후면");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_ASPECT_AFILE_SEQ</code>. 파일첨부 제품측면
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_ASPECT_AFILE_SEQ = createField(DSL.name("PRODUCT_ASPECT_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 제품측면");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_SHAPE1_AFILE_SEQ</code>. 파일첨부 제품제형1
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_SHAPE1_AFILE_SEQ = createField(DSL.name("PRODUCT_SHAPE1_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 제품제형1");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_SHAPE2_AFILE_SEQ</code>. 파일첨부 제품제형2
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_SHAPE2_AFILE_SEQ = createField(DSL.name("PRODUCT_SHAPE2_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 제품제형2");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_OUTSIDE1_AFILE_SEQ</code>. 파일첨부 외부패키지1
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_OUTSIDE1_AFILE_SEQ = createField(DSL.name("PRODUCT_OUTSIDE1_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 외부패키지1");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_OUTSIDE2_AFILE_SEQ</code>. 파일첨부 외부패키지2
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_OUTSIDE2_AFILE_SEQ = createField(DSL.name("PRODUCT_OUTSIDE2_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 외부패키지2");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_ETC1_AFILE_SEQ</code>. 파일첨부 기타1
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_ETC1_AFILE_SEQ = createField(DSL.name("PRODUCT_ETC1_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 기타1");

    /**
     * The column <code>rocketmart.TB_PRD_MST.PRODUCT_ETC2_AFILE_SEQ</code>. 파일첨부 기타2
     */
    public final TableField<TbPrdMstRecord, Integer> PRODUCT_ETC2_AFILE_SEQ = createField(DSL.name("PRODUCT_ETC2_AFILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "파일첨부 기타2");

    /**
     * The column <code>rocketmart.TB_PRD_MST.DEL_YN</code>. 삭제여부
     */
    public final TableField<TbPrdMstRecord, String> DEL_YN = createField(DSL.name("DEL_YN"), org.jooq.impl.SQLDataType.CHAR(1).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.CHAR)), this, "삭제여부");

    /**
     * The column <code>rocketmart.TB_PRD_MST.REG_USR_ID</code>. 등록자ID
     */
    public final TableField<TbPrdMstRecord, String> REG_USR_ID = createField(DSL.name("REG_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "등록자ID");

    /**
     * The column <code>rocketmart.TB_PRD_MST.REG_TS</code>. 등록일시
     */
    public final TableField<TbPrdMstRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.TB_PRD_MST.UPD_USR_ID</code>. 수정자ID
     */
    public final TableField<TbPrdMstRecord, String> UPD_USR_ID = createField(DSL.name("UPD_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "수정자ID");

    /**
     * The column <code>rocketmart.TB_PRD_MST.UPD_TS</code>. 수정일시
     */
    public final TableField<TbPrdMstRecord, Timestamp> UPD_TS = createField(DSL.name("UPD_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "수정일시");

    /**
     * Create a <code>rocketmart.TB_PRD_MST</code> table reference
     */
    public TbPrdMst() {
        this(DSL.name("TB_PRD_MST"), null);
    }

    /**
     * Create an aliased <code>rocketmart.TB_PRD_MST</code> table reference
     */
    public TbPrdMst(String alias) {
        this(DSL.name(alias), TB_PRD_MST);
    }

    /**
     * Create an aliased <code>rocketmart.TB_PRD_MST</code> table reference
     */
    public TbPrdMst(Name alias) {
        this(alias, TB_PRD_MST);
    }

    private TbPrdMst(Name alias, Table<TbPrdMstRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbPrdMst(Name alias, Table<TbPrdMstRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("상품 마스터"));
    }

    public <O extends Record> TbPrdMst(Table<O> child, ForeignKey<O, TbPrdMstRecord> key) {
        super(child, key, TB_PRD_MST);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_PRD_MST_PRIMARY, Indexes.TB_PRD_MST_TB_PRD_MST_FK1);
    }

    @Override
    public Identity<TbPrdMstRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_PRD_MST;
    }

    @Override
    public UniqueKey<TbPrdMstRecord> getPrimaryKey() {
        return Keys.KEY_TB_PRD_MST_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbPrdMstRecord>> getKeys() {
        return Arrays.<UniqueKey<TbPrdMstRecord>>asList(Keys.KEY_TB_PRD_MST_PRIMARY);
    }

    @Override
    public List<ForeignKey<TbPrdMstRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TbPrdMstRecord, ?>>asList(Keys.TB_PRD_MST_FK1);
    }

    public TbBrandMst tbBrandMst() {
        return new TbBrandMst(this, Keys.TB_PRD_MST_FK1);
    }

    @Override
    public TbPrdMst as(String alias) {
        return new TbPrdMst(DSL.name(alias), this);
    }

    @Override
    public TbPrdMst as(Name alias) {
        return new TbPrdMst(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbPrdMst rename(String name) {
        return new TbPrdMst(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbPrdMst rename(Name name) {
        return new TbPrdMst(name, null);
    }
}