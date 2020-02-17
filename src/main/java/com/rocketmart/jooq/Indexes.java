/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbMemMst;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>rocketmart</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index TB_BRAND_MST_PRIMARY = Indexes0.TB_BRAND_MST_PRIMARY;
    public static final Index TB_MEM_MST_IDX_MEM_SEQ = Indexes0.TB_MEM_MST_IDX_MEM_SEQ;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index TB_BRAND_MST_PRIMARY = Internal.createIndex("PRIMARY", TbBrandMst.TB_BRAND_MST, new OrderField[] { TbBrandMst.TB_BRAND_MST.BRAND_SEQ }, true);
        public static Index TB_MEM_MST_IDX_MEM_SEQ = Internal.createIndex("IDX_MEM_SEQ", TbMemMst.TB_MEM_MST, new OrderField[] { TbMemMst.TB_MEM_MST.MEM_SEQ }, false);
    }
}
