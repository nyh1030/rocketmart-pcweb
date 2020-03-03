/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables;


import com.rocketmart.jooq.Indexes;
import com.rocketmart.jooq.Keys;
import com.rocketmart.jooq.Rocketmart;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;

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
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * WISH LIST 마스터
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbWishMst extends TableImpl<TbWishMstRecord> {

    private static final long serialVersionUID = -1088421805;

    /**
     * The reference instance of <code>rocketmart.TB_WISH_MST</code>
     */
    public static final TbWishMst TB_WISH_MST = new TbWishMst();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbWishMstRecord> getRecordType() {
        return TbWishMstRecord.class;
    }

    /**
     * The column <code>rocketmart.TB_WISH_MST.WISH_SEQ</code>. 위시 일련번호
     */
    public final TableField<TbWishMstRecord, Integer> WISH_SEQ = createField(DSL.name("WISH_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "위시 일련번호");

    /**
     * The column <code>rocketmart.TB_WISH_MST.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public final TableField<TbWishMstRecord, Integer> PRODUCT_SEQ = createField(DSL.name("PRODUCT_SEQ"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "상품 일련번호");

    /**
     * The column <code>rocketmart.TB_WISH_MST.ASK_YN</code>. 문의여부
     */
    public final TableField<TbWishMstRecord, String> ASK_YN = createField(DSL.name("ASK_YN"), org.jooq.impl.SQLDataType.CHAR(1).defaultValue(org.jooq.impl.DSL.field("'N'", org.jooq.impl.SQLDataType.CHAR)), this, "문의여부");

    /**
     * The column <code>rocketmart.TB_WISH_MST.REG_USR_ID</code>. 등록자아이디
     */
    public final TableField<TbWishMstRecord, String> REG_USR_ID = createField(DSL.name("REG_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "등록자아이디");

    /**
     * The column <code>rocketmart.TB_WISH_MST.REG_TS</code>. 등록일시
     */
    public final TableField<TbWishMstRecord, Timestamp> REG_TS = createField(DSL.name("REG_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "등록일시");

    /**
     * The column <code>rocketmart.TB_WISH_MST.UPD_USR_ID</code>. 수정자아이디
     */
    public final TableField<TbWishMstRecord, String> UPD_USR_ID = createField(DSL.name("UPD_USR_ID"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "수정자아이디");

    /**
     * The column <code>rocketmart.TB_WISH_MST.UPD_TS</code>. 수정일시
     */
    public final TableField<TbWishMstRecord, Timestamp> UPD_TS = createField(DSL.name("UPD_TS"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("current_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "수정일시");

    /**
     * Create a <code>rocketmart.TB_WISH_MST</code> table reference
     */
    public TbWishMst() {
        this(DSL.name("TB_WISH_MST"), null);
    }

    /**
     * Create an aliased <code>rocketmart.TB_WISH_MST</code> table reference
     */
    public TbWishMst(String alias) {
        this(DSL.name(alias), TB_WISH_MST);
    }

    /**
     * Create an aliased <code>rocketmart.TB_WISH_MST</code> table reference
     */
    public TbWishMst(Name alias) {
        this(alias, TB_WISH_MST);
    }

    private TbWishMst(Name alias, Table<TbWishMstRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbWishMst(Name alias, Table<TbWishMstRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("WISH LIST 마스터"));
    }

    public <O extends Record> TbWishMst(Table<O> child, ForeignKey<O, TbWishMstRecord> key) {
        super(child, key, TB_WISH_MST);
    }

    @Override
    public Schema getSchema() {
        return Rocketmart.ROCKETMART;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TB_WISH_MST_PRIMARY, Indexes.TB_WISH_MST_TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK);
    }

    @Override
    public Identity<TbWishMstRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_WISH_MST;
    }

    @Override
    public UniqueKey<TbWishMstRecord> getPrimaryKey() {
        return Keys.KEY_TB_WISH_MST_PRIMARY;
    }

    @Override
    public List<UniqueKey<TbWishMstRecord>> getKeys() {
        return Arrays.<UniqueKey<TbWishMstRecord>>asList(Keys.KEY_TB_WISH_MST_PRIMARY);
    }

    @Override
    public List<ForeignKey<TbWishMstRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TbWishMstRecord, ?>>asList(Keys.TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK);
    }

    public TbPrdMst tbPrdMst() {
        return new TbPrdMst(this, Keys.TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK);
    }

    @Override
    public TbWishMst as(String alias) {
        return new TbWishMst(DSL.name(alias), this);
    }

    @Override
    public TbWishMst as(Name alias) {
        return new TbWishMst(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbWishMst rename(String name) {
        return new TbWishMst(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbWishMst rename(Name name) {
        return new TbWishMst(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
