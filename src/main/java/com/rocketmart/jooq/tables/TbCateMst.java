/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbCateMstRecord;

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
import org.jooq.Row13;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TbCateMst extends TableImpl<TbCateMstRecord> {

    private static final long serialVersionUID = 216334925;

    /**
     * The reference instance of <code>rocketmart.TB_CATE_MST</code>
     */
    public static final TbCateMst TB_CATE_MST = new TbCateMst();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbCateMstRecord> getRecordType() {
        return TbCateMstRecord.class;
    }

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE_SEQ</code>. 카테고리 일련번호
     */
    public final TableField<TbCateMstRecord, Integer> CATE_SEQ = createField(DSL.name("CATE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "카테고리 일련번호");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE1_CD</code>. 카테고리1 코드
     */
    public final TableField<TbCateMstRecord, String> CATE1_CD = createField(DSL.name("CATE1_CD"), org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리1 코드");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE1_NM</code>. 카테고리1 명
     */
    public final TableField<TbCateMstRecord, String> CATE1_NM = createField(DSL.name("CATE1_NM"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리1 명");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE2_CD</code>. 카테고리2 코드
     */
    public final TableField<TbCateMstRecord, String> CATE2_CD = createField(DSL.name("CATE2_CD"), org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리2 코드");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE2_NM</code>. 카테고리2 명
     */
    public final TableField<TbCateMstRecord, String> CATE2_NM = createField(DSL.name("CATE2_NM"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리2 명");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE3_CD</code>. 카테고리3 코드
     */
    public final TableField<TbCateMstRecord, String> CATE3_CD = createField(DSL.name("CATE3_CD"), org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리3 코드");

    /**
     * The column <code>rocketmart.TB_CATE_MST.CATE3_NM</code>. 카테고리3 명
     */
    public final TableField<TbCateMstRecord, String> CATE3_NM = createField(DSL.name("CATE3_NM"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "카테고리3 명");

    /**
     * The column <code>rocketmart.TB_CATE_MST.DEPTH</code>. DEPTH
     */
    public final TableField<TbCateMstRecord, Integer> DEPTH = createField(DSL.name("DEPTH"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "DEPTH");

    /**
     * The column <code>rocketmart.TB_CATE_MST.DEL_YN</code>. 삭제여부
     */
    public final TableField<TbCateMstRecord, String> DEL_YN = createField(DSL.name("DEL_YN"), org.jooq.impl.SQLDataType.CHAR(1).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.CHAR)), this, "삭제여부");

    /**
     * The column <code>rocketmart.TB_CATE_MST.REG_USR_ID</code>. 등록자 아이디
     */
    public final TableField<TbCateMstRecord, String> REG_USR_ID = createField(DSL.name("REG_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "등록자 아이디");

    /**
     * The column <code>rocketmart.TB_CATE_MST.REG_TS</code>. 등록일시
     */
    public final TableField<TbCateMstRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.TB_CATE_MST.UPD_USR_ID</code>. 수정자 아이디
     */
    public final TableField<TbCateMstRecord, String> UPD_USR_ID = createField(DSL.name("UPD_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "수정자 아이디");

    /**
     * The column <code>rocketmart.TB_CATE_MST.UPD_TS</code>. 수정일시
     */
    public final TableField<TbCateMstRecord, Timestamp> UPD_TS = createField(DSL.name("UPD_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "수정일시");

    /**
     * Create a <code>rocketmart.TB_CATE_MST</code> table reference
     */
    public TbCateMst() {
        this(DSL.name("TB_CATE_MST"), null);
    }

    /**
     * Create an aliased <code>rocketmart.TB_CATE_MST</code> table reference
     */
    public TbCateMst(String alias) {
        this(DSL.name(alias), TB_CATE_MST);
    }

    /**
     * Create an aliased <code>rocketmart.TB_CATE_MST</code> table reference
     */
    public TbCateMst(Name alias) {
        this(alias, TB_CATE_MST);
    }

    private TbCateMst(Name alias, Table<TbCateMstRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbCateMst(Name alias, Table<TbCateMstRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("카테고리_정보"));
    }

    public <O extends Record> TbCateMst(Table<O> child, ForeignKey<O, TbCateMstRecord> key) {
        super(child, key, TB_CATE_MST);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_CATE_MST_PRIMARY);
    }

    @Override
    public Identity<TbCateMstRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_CATE_MST;
    }

    @Override
    public UniqueKey<TbCateMstRecord> getPrimaryKey() {
        return Keys.KEY_TB_CATE_MST_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbCateMstRecord>> getKeys() {
        return Arrays.<UniqueKey<TbCateMstRecord>>asList(Keys.KEY_TB_CATE_MST_PRIMARY);
    }

    @Override
    public TbCateMst as(String alias) {
        return new TbCateMst(DSL.name(alias), this);
    }

    @Override
    public TbCateMst as(Name alias) {
        return new TbCateMst(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbCateMst rename(String name) {
        return new TbCateMst(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbCateMst rename(Name name) {
        return new TbCateMst(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, String, String, String, String, String, Integer, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
