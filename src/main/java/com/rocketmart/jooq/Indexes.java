/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.TbOtherContactUs;
import com.rocketmart.jooq.tables.TbPrdMst;
import com.rocketmart.jooq.tables.TbPrdWholesale;

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
    public static final Index TB_CM_AFILE_PRIMARY = Indexes0.TB_CM_AFILE_PRIMARY;
    public static final Index TB_MEM_MST_IDX_MEM_SEQ = Indexes0.TB_MEM_MST_IDX_MEM_SEQ;
    public static final Index TB_MEM_MST_PRIMARY = Indexes0.TB_MEM_MST_PRIMARY;
    public static final Index TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = Indexes0.TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX;
    public static final Index TB_OTHER_CONTACT_US_PRIMARY = Indexes0.TB_OTHER_CONTACT_US_PRIMARY;
    public static final Index TB_PRD_MST_PRIMARY = Indexes0.TB_PRD_MST_PRIMARY;
    public static final Index TB_PRD_WHOLESALE_PRIMARY = Indexes0.TB_PRD_WHOLESALE_PRIMARY;
    public static final Index TB_PRD_WHOLESALE_TB_PRD_WHOLESALE_FK1 = Indexes0.TB_PRD_WHOLESALE_TB_PRD_WHOLESALE_FK1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index TB_BRAND_MST_PRIMARY = Internal.createIndex("PRIMARY", TbBrandMst.TB_BRAND_MST, new OrderField[] { TbBrandMst.TB_BRAND_MST.BRAND_SEQ }, true);
        public static Index TB_CM_AFILE_PRIMARY = Internal.createIndex("PRIMARY", TbCmAfile.TB_CM_AFILE, new OrderField[] { TbCmAfile.TB_CM_AFILE.AFILE_SEQ, TbCmAfile.TB_CM_AFILE.AFILE_NO }, true);
        public static Index TB_MEM_MST_IDX_MEM_SEQ = Internal.createIndex("IDX_MEM_SEQ", TbMemMst.TB_MEM_MST, new OrderField[] { TbMemMst.TB_MEM_MST.MEM_SEQ }, false);
        public static Index TB_MEM_MST_PRIMARY = Internal.createIndex("PRIMARY", TbMemMst.TB_MEM_MST, new OrderField[] { TbMemMst.TB_MEM_MST.MEM_SEQ }, true);
        public static Index TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = Internal.createIndex("TB_MEM_MST_MEM_ID_uindex", TbMemMst.TB_MEM_MST, new OrderField[] { TbMemMst.TB_MEM_MST.MEM_ID }, true);
        public static Index TB_OTHER_CONTACT_US_PRIMARY = Internal.createIndex("PRIMARY", TbOtherContactUs.TB_OTHER_CONTACT_US, new OrderField[] { TbOtherContactUs.TB_OTHER_CONTACT_US.CONTACT_SEQ }, true);
        public static Index TB_PRD_MST_PRIMARY = Internal.createIndex("PRIMARY", TbPrdMst.TB_PRD_MST, new OrderField[] { TbPrdMst.TB_PRD_MST.PRODUCT_SEQ }, true);
        public static Index TB_PRD_WHOLESALE_PRIMARY = Internal.createIndex("PRIMARY", TbPrdWholesale.TB_PRD_WHOLESALE, new OrderField[] { TbPrdWholesale.TB_PRD_WHOLESALE.WHOLESALE_SEQ }, true);
        public static Index TB_PRD_WHOLESALE_TB_PRD_WHOLESALE_FK1 = Internal.createIndex("TB_PRD_WHOLESALE_fk1", TbPrdWholesale.TB_PRD_WHOLESALE, new OrderField[] { TbPrdWholesale.TB_PRD_WHOLESALE.PRODUCT_SEQ }, false);
    }
}
