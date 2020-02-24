/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbBrandMstRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TbBrandMst extends TableImpl<TbBrandMstRecord> {

    private static final long serialVersionUID = -941124859;

    /**
     * The reference instance of <code>rocketmart.tb_brand_mst</code>
     */
    public static final TbBrandMst TB_BRAND_MST = new TbBrandMst();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbBrandMstRecord> getRecordType() {
        return TbBrandMstRecord.class;
    }

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_SEQ</code>. 브랜드 일련번호
     */
    public final TableField<TbBrandMstRecord, Integer> BRAND_SEQ = createField(DSL.name("BRAND_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "브랜드 일련번호");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_NM</code>. 브랜드명
     */
    public final TableField<TbBrandMstRecord, String> BRAND_NM = createField(DSL.name("BRAND_NM"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "브랜드명");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_LOGO</code>. 브랜드 로고
     */
    public final TableField<TbBrandMstRecord, String> BRAND_LOGO = createField(DSL.name("BRAND_LOGO"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "브랜드 로고");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_OWNERSHIP</code>. 브랜드 오너십
     */
    public final TableField<TbBrandMstRecord, String> BRAND_OWNERSHIP = createField(DSL.name("BRAND_OWNERSHIP"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "브랜드 오너십");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_HOMEPAGE_URL</code>. 브랜드 홈페이지URL
     */
    public final TableField<TbBrandMstRecord, String> BRAND_HOMEPAGE_URL = createField(DSL.name("BRAND_HOMEPAGE_URL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "브랜드 홈페이지URL");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_YOUTUBE_URL</code>. 브랜드 유튜브URL
     */
    public final TableField<TbBrandMstRecord, String> BRAND_YOUTUBE_URL = createField(DSL.name("BRAND_YOUTUBE_URL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "브랜드 유튜브URL");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_INSTAGRAM_URL</code>. 브랜드 인스타그램URL
     */
    public final TableField<TbBrandMstRecord, String> BRAND_INSTAGRAM_URL = createField(DSL.name("BRAND_INSTAGRAM_URL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "브랜드 인스타그램URL");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_CERIFY</code>. 브랜드 인증
     */
    public final TableField<TbBrandMstRecord, String> BRAND_CERIFY = createField(DSL.name("BRAND_CERIFY"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "브랜드 인증");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_INTRODUCTION</code>. 브랜드 소개
     */
    public final TableField<TbBrandMstRecord, String> BRAND_INTRODUCTION = createField(DSL.name("BRAND_INTRODUCTION"), org.jooq.impl.SQLDataType.VARCHAR(2000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "브랜드 소개");

    /**
     * The column <code>rocketmart.tb_brand_mst.BRAND_FILE_SEQ</code>. 파일첨부 ID
     */
    public final TableField<TbBrandMstRecord, String> BRAND_FILE_SEQ = createField(DSL.name("BRAND_FILE_SEQ"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "파일첨부 ID");

    /**
     * The column <code>rocketmart.tb_brand_mst.REG_USR_ID</code>. 등록자 아이디
     */
    public final TableField<TbBrandMstRecord, String> REG_USR_ID = createField(DSL.name("REG_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "등록자 아이디");

    /**
     * The column <code>rocketmart.tb_brand_mst.REG_TS</code>. 등록일시
     */
    public final TableField<TbBrandMstRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.tb_brand_mst.UPD_USR_ID</code>. 수정자 아이디
     */
    public final TableField<TbBrandMstRecord, String> UPD_USR_ID = createField(DSL.name("UPD_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "수정자 아이디");

    /**
     * The column <code>rocketmart.tb_brand_mst.UPD_TS</code>. 수정일시
     */
    public final TableField<TbBrandMstRecord, Timestamp> UPD_TS = createField(DSL.name("UPD_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "수정일시");

    /**
     * Create a <code>rocketmart.tb_brand_mst</code> table reference
     */
    public TbBrandMst() {
        this(DSL.name("tb_brand_mst"), null);
    }

    /**
     * Create an aliased <code>rocketmart.tb_brand_mst</code> table reference
     */
    public TbBrandMst(String alias) {
        this(DSL.name(alias), TB_BRAND_MST);
    }

    /**
     * Create an aliased <code>rocketmart.tb_brand_mst</code> table reference
     */
    public TbBrandMst(Name alias) {
        this(alias, TB_BRAND_MST);
    }

    private TbBrandMst(Name alias, Table<TbBrandMstRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbBrandMst(Name alias, Table<TbBrandMstRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("브랜드_정보"));
    }

    public <O extends Record> TbBrandMst(Table<O> child, ForeignKey<O, TbBrandMstRecord> key) {
        super(child, key, TB_BRAND_MST);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_BRAND_MST_PRIMARY);
    }

    @Override
    public Identity<TbBrandMstRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_BRAND_MST;
    }

    @Override
    public UniqueKey<TbBrandMstRecord> getPrimaryKey() {
        return Keys.KEY_TB_BRAND_MST_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbBrandMstRecord>> getKeys() {
        return Arrays.<UniqueKey<TbBrandMstRecord>>asList(Keys.KEY_TB_BRAND_MST_PRIMARY);
    }

    @Override
    public TbBrandMst as(String alias) {
        return new TbBrandMst(DSL.name(alias), this);
    }

    @Override
    public TbBrandMst as(Name alias) {
        return new TbBrandMst(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrandMst rename(String name) {
        return new TbBrandMst(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrandMst rename(Name name) {
        return new TbBrandMst(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<Integer, String, String, String, String, String, String, String, String, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}