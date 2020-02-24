/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbBrandFileRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TbBrandFile extends TableImpl<TbBrandFileRecord> {

    private static final long serialVersionUID = -1979292475;

    /**
     * The reference instance of <code>rocketmart.tb_brand_file</code>
     */
    public static final TbBrandFile TB_BRAND_FILE = new TbBrandFile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbBrandFileRecord> getRecordType() {
        return TbBrandFileRecord.class;
    }

    /**
     * The column <code>rocketmart.tb_brand_file.FILE_SEQ</code>. 파일 일련번호
     */
    public final TableField<TbBrandFileRecord, Integer> FILE_SEQ = createField(DSL.name("FILE_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "파일 일련번호");

    /**
     * The column <code>rocketmart.tb_brand_file.STORED_FILE_NM</code>. 저장된 파일명
     */
    public final TableField<TbBrandFileRecord, String> STORED_FILE_NM = createField(DSL.name("STORED_FILE_NM"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "저장된 파일명");

    /**
     * The column <code>rocketmart.tb_brand_file.REAL_FILE_NM</code>. 실제 파일명
     */
    public final TableField<TbBrandFileRecord, String> REAL_FILE_NM = createField(DSL.name("REAL_FILE_NM"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "실제 파일명");

    /**
     * The column <code>rocketmart.tb_brand_file.FILE_EXTENSIONS</code>. 파일 확장자
     */
    public final TableField<TbBrandFileRecord, String> FILE_EXTENSIONS = createField(DSL.name("FILE_EXTENSIONS"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "파일 확장자");

    /**
     * The column <code>rocketmart.tb_brand_file.REG_USR_ID</code>. 등록자 아이디
     */
    public final TableField<TbBrandFileRecord, String> REG_USR_ID = createField(DSL.name("REG_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "등록자 아이디");

    /**
     * The column <code>rocketmart.tb_brand_file.REG_TS</code>. 등록일시
     */
    public final TableField<TbBrandFileRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.tb_brand_file.UPD_USR_ID</code>. 수정자 아이디
     */
    public final TableField<TbBrandFileRecord, String> UPD_USR_ID = createField(DSL.name("UPD_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "수정자 아이디");

    /**
     * The column <code>rocketmart.tb_brand_file.UPD_TS</code>. 수정일시
     */
    public final TableField<TbBrandFileRecord, Timestamp> UPD_TS = createField(DSL.name("UPD_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "수정일시");

    /**
     * Create a <code>rocketmart.tb_brand_file</code> table reference
     */
    public TbBrandFile() {
        this(DSL.name("tb_brand_file"), null);
    }

    /**
     * Create an aliased <code>rocketmart.tb_brand_file</code> table reference
     */
    public TbBrandFile(String alias) {
        this(DSL.name(alias), TB_BRAND_FILE);
    }

    /**
     * Create an aliased <code>rocketmart.tb_brand_file</code> table reference
     */
    public TbBrandFile(Name alias) {
        this(alias, TB_BRAND_FILE);
    }

    private TbBrandFile(Name alias, Table<TbBrandFileRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbBrandFile(Name alias, Table<TbBrandFileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("브랜드_파일"));
    }

    public <O extends Record> TbBrandFile(Table<O> child, ForeignKey<O, TbBrandFileRecord> key) {
        super(child, key, TB_BRAND_FILE);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_BRAND_FILE_PRIMARY);
    }

    @Override
    public UniqueKey<TbBrandFileRecord> getPrimaryKey() {
        return Keys.KEY_TB_BRAND_FILE_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbBrandFileRecord>> getKeys() {
        return Arrays.<UniqueKey<TbBrandFileRecord>>asList(Keys.KEY_TB_BRAND_FILE_PRIMARY);
    }

    @Override
    public TbBrandFile as(String alias) {
        return new TbBrandFile(DSL.name(alias), this);
    }

    @Override
    public TbBrandFile as(Name alias) {
        return new TbBrandFile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrandFile rename(String name) {
        return new TbBrandFile(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrandFile rename(Name name) {
        return new TbBrandFile(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
