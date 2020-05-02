/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbContactUsRecord;

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
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TbContactUs extends TableImpl<TbContactUsRecord> {

    private static final long serialVersionUID = -1166673898;

    /**
     * The reference instance of <code>rocketmart.tb_contact_us</code>
     */
    public static final TbContactUs TB_CONTACT_US = new TbContactUs();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbContactUsRecord> getRecordType() {
        return TbContactUsRecord.class;
    }

    /**
     * The column <code>rocketmart.tb_contact_us.CONTACT_SEQ</code>. 컨택 일련번호
     */
    public final TableField<TbContactUsRecord, Integer> CONTACT_SEQ = createField(DSL.name("CONTACT_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "컨택 일련번호");

    /**
     * The column <code>rocketmart.tb_contact_us.USR_NM</code>. 문의자명
     */
    public final TableField<TbContactUsRecord, String> USR_NM = createField(DSL.name("USR_NM"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "문의자명");

    /**
     * The column <code>rocketmart.tb_contact_us.EMAIL</code>. email
     */
    public final TableField<TbContactUsRecord, String> EMAIL = createField(DSL.name("EMAIL"), org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "email");

    /**
     * The column <code>rocketmart.tb_contact_us.COMPANY_NM</code>. 회사명
     */
    public final TableField<TbContactUsRecord, String> COMPANY_NM = createField(DSL.name("COMPANY_NM"), org.jooq.impl.SQLDataType.VARCHAR(200).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "회사명");

    /**
     * The column <code>rocketmart.tb_contact_us.SUBJECT</code>. 문의 제목
     */
    public final TableField<TbContactUsRecord, String> SUBJECT = createField(DSL.name("SUBJECT"), org.jooq.impl.SQLDataType.VARCHAR(500).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "문의 제목");

    /**
     * The column <code>rocketmart.tb_contact_us.MESSAGE</code>. 문의 본문
     */
    public final TableField<TbContactUsRecord, String> MESSAGE = createField(DSL.name("MESSAGE"), org.jooq.impl.SQLDataType.VARCHAR(4000).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "문의 본문");

    /**
     * The column <code>rocketmart.tb_contact_us.REG_TS</code>. 등록일시
     */
    public final TableField<TbContactUsRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.tb_contact_us.REPLY_YN</code>. 회신여부
     */
    public final TableField<TbContactUsRecord, String> REPLY_YN = createField(DSL.name("REPLY_YN"), org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.VARCHAR)), this, "회신여부");

    /**
     * Create a <code>rocketmart.tb_contact_us</code> table reference
     */
    public TbContactUs() {
        this(DSL.name("tb_contact_us"), null);
    }

    /**
     * Create an aliased <code>rocketmart.tb_contact_us</code> table reference
     */
    public TbContactUs(String alias) {
        this(DSL.name(alias), TB_CONTACT_US);
    }

    /**
     * Create an aliased <code>rocketmart.tb_contact_us</code> table reference
     */
    public TbContactUs(Name alias) {
        this(alias, TB_CONTACT_US);
    }

    private TbContactUs(Name alias, Table<TbContactUsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbContactUs(Name alias, Table<TbContactUsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("관리자 문의"));
    }

    public <O extends Record> TbContactUs(Table<O> child, ForeignKey<O, TbContactUsRecord> key) {
        super(child, key, TB_CONTACT_US);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_CONTACT_US_PRIMARY);
    }

    @Override
    public Identity<TbContactUsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_CONTACT_US;
    }

    @Override
    public UniqueKey<TbContactUsRecord> getPrimaryKey() {
        return Keys.KEY_TB_CONTACT_US_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbContactUsRecord>> getKeys() {
        return Arrays.<UniqueKey<TbContactUsRecord>>asList(Keys.KEY_TB_CONTACT_US_PRIMARY);
    }

    @Override
    public TbContactUs as(String alias) {
        return new TbContactUs(DSL.name(alias), this);
    }

    @Override
    public TbContactUs as(Name alias) {
        return new TbContactUs(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbContactUs rename(String name) {
        return new TbContactUs(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbContactUs rename(Name name) {
        return new TbContactUs(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, String, String, Timestamp, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
