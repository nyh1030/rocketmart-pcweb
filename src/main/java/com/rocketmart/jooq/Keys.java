/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.TbOtherContactUs;
import com.rocketmart.jooq.tables.records.TbBrandMstRecord;
import com.rocketmart.jooq.tables.records.TbCmAfileRecord;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.jooq.tables.records.TbOtherContactUsRecord;

import javax.annotation.processing.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>rocketmart</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<TbBrandMstRecord, Integer> IDENTITY_TB_BRAND_MST = Identities0.IDENTITY_TB_BRAND_MST;
    public static final Identity<TbMemMstRecord, Integer> IDENTITY_TB_MEM_MST = Identities0.IDENTITY_TB_MEM_MST;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TbBrandMstRecord> KEY_TB_BRAND_MST_PRIMARY = UniqueKeys0.KEY_TB_BRAND_MST_PRIMARY;
    public static final UniqueKey<TbCmAfileRecord> KEY_TB_CM_AFILE_PRIMARY = UniqueKeys0.KEY_TB_CM_AFILE_PRIMARY;
    public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_PRIMARY = UniqueKeys0.KEY_TB_MEM_MST_PRIMARY;
    public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = UniqueKeys0.KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX;
    public static final UniqueKey<TbOtherContactUsRecord> KEY_TB_OTHER_CONTACT_US_PRIMARY = UniqueKeys0.KEY_TB_OTHER_CONTACT_US_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<TbBrandMstRecord, Integer> IDENTITY_TB_BRAND_MST = Internal.createIdentity(TbBrandMst.TB_BRAND_MST, TbBrandMst.TB_BRAND_MST.BRAND_SEQ);
        public static Identity<TbMemMstRecord, Integer> IDENTITY_TB_MEM_MST = Internal.createIdentity(TbMemMst.TB_MEM_MST, TbMemMst.TB_MEM_MST.MEM_SEQ);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<TbBrandMstRecord> KEY_TB_BRAND_MST_PRIMARY = Internal.createUniqueKey(TbBrandMst.TB_BRAND_MST, "KEY_TB_BRAND_MST_PRIMARY", TbBrandMst.TB_BRAND_MST.BRAND_SEQ);
        public static final UniqueKey<TbCmAfileRecord> KEY_TB_CM_AFILE_PRIMARY = Internal.createUniqueKey(TbCmAfile.TB_CM_AFILE, "KEY_TB_CM_AFILE_PRIMARY", TbCmAfile.TB_CM_AFILE.AFILE_SEQ, TbCmAfile.TB_CM_AFILE.AFILE_NO);
        public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_PRIMARY = Internal.createUniqueKey(TbMemMst.TB_MEM_MST, "KEY_TB_MEM_MST_PRIMARY", TbMemMst.TB_MEM_MST.MEM_SEQ);
        public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = Internal.createUniqueKey(TbMemMst.TB_MEM_MST, "KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_uindex", TbMemMst.TB_MEM_MST.MEM_ID);
        public static final UniqueKey<TbOtherContactUsRecord> KEY_TB_OTHER_CONTACT_US_PRIMARY = Internal.createUniqueKey(TbOtherContactUs.TB_OTHER_CONTACT_US, "KEY_TB_OTHER_CONTACT_US_PRIMARY", TbOtherContactUs.TB_OTHER_CONTACT_US.CONTACT_SEQ);
    }
}
