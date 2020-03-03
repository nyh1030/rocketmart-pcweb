/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbCateMst;
import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.jooq.tables.TbContactUs;
import com.rocketmart.jooq.tables.TbInquiryDtl;
import com.rocketmart.jooq.tables.TbInquiryMst;
import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.TbPrdMst;
import com.rocketmart.jooq.tables.TbPrdWholesale;
import com.rocketmart.jooq.tables.TbWishMst;
import com.rocketmart.jooq.tables.records.TbBrandMstRecord;
import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.jooq.tables.records.TbCmAfileRecord;
import com.rocketmart.jooq.tables.records.TbContactUsRecord;
import com.rocketmart.jooq.tables.records.TbInquiryDtlRecord;
import com.rocketmart.jooq.tables.records.TbInquiryMstRecord;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.jooq.tables.records.TbPrdMstRecord;
import com.rocketmart.jooq.tables.records.TbPrdWholesaleRecord;
import com.rocketmart.jooq.tables.records.TbWishMstRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
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
    public static final Identity<TbCateMstRecord, Integer> IDENTITY_TB_CATE_MST = Identities0.IDENTITY_TB_CATE_MST;
    public static final Identity<TbContactUsRecord, Integer> IDENTITY_TB_CONTACT_US = Identities0.IDENTITY_TB_CONTACT_US;
    public static final Identity<TbInquiryMstRecord, Integer> IDENTITY_TB_INQUIRY_MST = Identities0.IDENTITY_TB_INQUIRY_MST;
    public static final Identity<TbMemMstRecord, Integer> IDENTITY_TB_MEM_MST = Identities0.IDENTITY_TB_MEM_MST;
    public static final Identity<TbPrdMstRecord, Integer> IDENTITY_TB_PRD_MST = Identities0.IDENTITY_TB_PRD_MST;
    public static final Identity<TbPrdWholesaleRecord, Integer> IDENTITY_TB_PRD_WHOLESALE = Identities0.IDENTITY_TB_PRD_WHOLESALE;
    public static final Identity<TbWishMstRecord, Integer> IDENTITY_TB_WISH_MST = Identities0.IDENTITY_TB_WISH_MST;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TbBrandMstRecord> KEY_TB_BRAND_MST_PRIMARY = UniqueKeys0.KEY_TB_BRAND_MST_PRIMARY;
    public static final UniqueKey<TbCateMstRecord> KEY_TB_CATE_MST_PRIMARY = UniqueKeys0.KEY_TB_CATE_MST_PRIMARY;
    public static final UniqueKey<TbCmAfileRecord> KEY_TB_CM_AFILE_PRIMARY = UniqueKeys0.KEY_TB_CM_AFILE_PRIMARY;
    public static final UniqueKey<TbContactUsRecord> KEY_TB_CONTACT_US_PRIMARY = UniqueKeys0.KEY_TB_CONTACT_US_PRIMARY;
    public static final UniqueKey<TbInquiryDtlRecord> KEY_TB_INQUIRY_DTL_PRIMARY = UniqueKeys0.KEY_TB_INQUIRY_DTL_PRIMARY;
    public static final UniqueKey<TbInquiryMstRecord> KEY_TB_INQUIRY_MST_PRIMARY = UniqueKeys0.KEY_TB_INQUIRY_MST_PRIMARY;
    public static final UniqueKey<TbInquiryMstRecord> KEY_TB_INQUIRY_MST_TB_INQUIRY_MST_INQUIRY_SEQ_UINDEX = UniqueKeys0.KEY_TB_INQUIRY_MST_TB_INQUIRY_MST_INQUIRY_SEQ_UINDEX;
    public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_PRIMARY = UniqueKeys0.KEY_TB_MEM_MST_PRIMARY;
    public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = UniqueKeys0.KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX;
    public static final UniqueKey<TbPrdMstRecord> KEY_TB_PRD_MST_PRIMARY = UniqueKeys0.KEY_TB_PRD_MST_PRIMARY;
    public static final UniqueKey<TbPrdWholesaleRecord> KEY_TB_PRD_WHOLESALE_PRIMARY = UniqueKeys0.KEY_TB_PRD_WHOLESALE_PRIMARY;
    public static final UniqueKey<TbWishMstRecord> KEY_TB_WISH_MST_PRIMARY = UniqueKeys0.KEY_TB_WISH_MST_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TbInquiryDtlRecord, TbInquiryMstRecord> TB_INQUIRY_DTL_TB_INQUIRY_MST_INQUIRY_SEQ_FK = ForeignKeys0.TB_INQUIRY_DTL_TB_INQUIRY_MST_INQUIRY_SEQ_FK;
    public static final ForeignKey<TbInquiryDtlRecord, TbPrdMstRecord> TB_INQUIRY_DTL_TB_PRD_MST_PRODUCT_SEQ_FK = ForeignKeys0.TB_INQUIRY_DTL_TB_PRD_MST_PRODUCT_SEQ_FK;
    public static final ForeignKey<TbPrdMstRecord, TbBrandMstRecord> TB_PRD_MST_FK1 = ForeignKeys0.TB_PRD_MST_FK1;
    public static final ForeignKey<TbPrdWholesaleRecord, TbPrdMstRecord> TB_PRD_WHOLESALE_FK1 = ForeignKeys0.TB_PRD_WHOLESALE_FK1;
    public static final ForeignKey<TbWishMstRecord, TbPrdMstRecord> TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK = ForeignKeys0.TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<TbBrandMstRecord, Integer> IDENTITY_TB_BRAND_MST = Internal.createIdentity(TbBrandMst.TB_BRAND_MST, TbBrandMst.TB_BRAND_MST.BRAND_SEQ);
        public static Identity<TbCateMstRecord, Integer> IDENTITY_TB_CATE_MST = Internal.createIdentity(TbCateMst.TB_CATE_MST, TbCateMst.TB_CATE_MST.CATE_SEQ);
        public static Identity<TbContactUsRecord, Integer> IDENTITY_TB_CONTACT_US = Internal.createIdentity(TbContactUs.TB_CONTACT_US, TbContactUs.TB_CONTACT_US.CONTACT_SEQ);
        public static Identity<TbInquiryMstRecord, Integer> IDENTITY_TB_INQUIRY_MST = Internal.createIdentity(TbInquiryMst.TB_INQUIRY_MST, TbInquiryMst.TB_INQUIRY_MST.INQUIRY_SEQ);
        public static Identity<TbMemMstRecord, Integer> IDENTITY_TB_MEM_MST = Internal.createIdentity(TbMemMst.TB_MEM_MST, TbMemMst.TB_MEM_MST.MEM_SEQ);
        public static Identity<TbPrdMstRecord, Integer> IDENTITY_TB_PRD_MST = Internal.createIdentity(TbPrdMst.TB_PRD_MST, TbPrdMst.TB_PRD_MST.PRODUCT_SEQ);
        public static Identity<TbPrdWholesaleRecord, Integer> IDENTITY_TB_PRD_WHOLESALE = Internal.createIdentity(TbPrdWholesale.TB_PRD_WHOLESALE, TbPrdWholesale.TB_PRD_WHOLESALE.WHOLESALE_SEQ);
        public static Identity<TbWishMstRecord, Integer> IDENTITY_TB_WISH_MST = Internal.createIdentity(TbWishMst.TB_WISH_MST, TbWishMst.TB_WISH_MST.WISH_SEQ);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<TbBrandMstRecord> KEY_TB_BRAND_MST_PRIMARY = Internal.createUniqueKey(TbBrandMst.TB_BRAND_MST, "KEY_TB_BRAND_MST_PRIMARY", TbBrandMst.TB_BRAND_MST.BRAND_SEQ);
        public static final UniqueKey<TbCateMstRecord> KEY_TB_CATE_MST_PRIMARY = Internal.createUniqueKey(TbCateMst.TB_CATE_MST, "KEY_TB_CATE_MST_PRIMARY", TbCateMst.TB_CATE_MST.CATE_SEQ);
        public static final UniqueKey<TbCmAfileRecord> KEY_TB_CM_AFILE_PRIMARY = Internal.createUniqueKey(TbCmAfile.TB_CM_AFILE, "KEY_TB_CM_AFILE_PRIMARY", TbCmAfile.TB_CM_AFILE.AFILE_SEQ, TbCmAfile.TB_CM_AFILE.AFILE_NO);
        public static final UniqueKey<TbContactUsRecord> KEY_TB_CONTACT_US_PRIMARY = Internal.createUniqueKey(TbContactUs.TB_CONTACT_US, "KEY_TB_CONTACT_US_PRIMARY", TbContactUs.TB_CONTACT_US.CONTACT_SEQ);
        public static final UniqueKey<TbInquiryDtlRecord> KEY_TB_INQUIRY_DTL_PRIMARY = Internal.createUniqueKey(TbInquiryDtl.TB_INQUIRY_DTL, "KEY_TB_INQUIRY_DTL_PRIMARY", TbInquiryDtl.TB_INQUIRY_DTL.INQUIRY_DTL_SEQ);
        public static final UniqueKey<TbInquiryMstRecord> KEY_TB_INQUIRY_MST_PRIMARY = Internal.createUniqueKey(TbInquiryMst.TB_INQUIRY_MST, "KEY_TB_INQUIRY_MST_PRIMARY", TbInquiryMst.TB_INQUIRY_MST.INQUIRY_SEQ);
        public static final UniqueKey<TbInquiryMstRecord> KEY_TB_INQUIRY_MST_TB_INQUIRY_MST_INQUIRY_SEQ_UINDEX = Internal.createUniqueKey(TbInquiryMst.TB_INQUIRY_MST, "KEY_TB_INQUIRY_MST_TB_INQUIRY_MST_INQUIRY_SEQ_uindex", TbInquiryMst.TB_INQUIRY_MST.INQUIRY_SEQ);
        public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_PRIMARY = Internal.createUniqueKey(TbMemMst.TB_MEM_MST, "KEY_TB_MEM_MST_PRIMARY", TbMemMst.TB_MEM_MST.MEM_SEQ);
        public static final UniqueKey<TbMemMstRecord> KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_UINDEX = Internal.createUniqueKey(TbMemMst.TB_MEM_MST, "KEY_TB_MEM_MST_TB_MEM_MST_MEM_ID_uindex", TbMemMst.TB_MEM_MST.MEM_ID);
        public static final UniqueKey<TbPrdMstRecord> KEY_TB_PRD_MST_PRIMARY = Internal.createUniqueKey(TbPrdMst.TB_PRD_MST, "KEY_TB_PRD_MST_PRIMARY", TbPrdMst.TB_PRD_MST.PRODUCT_SEQ);
        public static final UniqueKey<TbPrdWholesaleRecord> KEY_TB_PRD_WHOLESALE_PRIMARY = Internal.createUniqueKey(TbPrdWholesale.TB_PRD_WHOLESALE, "KEY_TB_PRD_WHOLESALE_PRIMARY", TbPrdWholesale.TB_PRD_WHOLESALE.WHOLESALE_SEQ);
        public static final UniqueKey<TbWishMstRecord> KEY_TB_WISH_MST_PRIMARY = Internal.createUniqueKey(TbWishMst.TB_WISH_MST, "KEY_TB_WISH_MST_PRIMARY", TbWishMst.TB_WISH_MST.WISH_SEQ);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<TbInquiryDtlRecord, TbInquiryMstRecord> TB_INQUIRY_DTL_TB_INQUIRY_MST_INQUIRY_SEQ_FK = Internal.createForeignKey(com.rocketmart.jooq.Keys.KEY_TB_INQUIRY_MST_PRIMARY, TbInquiryDtl.TB_INQUIRY_DTL, "TB_INQUIRY_DTL_TB_INQUIRY_MST_INQUIRY_SEQ_fk", TbInquiryDtl.TB_INQUIRY_DTL.INQUIRY_SEQ);
        public static final ForeignKey<TbInquiryDtlRecord, TbPrdMstRecord> TB_INQUIRY_DTL_TB_PRD_MST_PRODUCT_SEQ_FK = Internal.createForeignKey(com.rocketmart.jooq.Keys.KEY_TB_PRD_MST_PRIMARY, TbInquiryDtl.TB_INQUIRY_DTL, "TB_INQUIRY_DTL_TB_PRD_MST_PRODUCT_SEQ_fk", TbInquiryDtl.TB_INQUIRY_DTL.PRODUCT_SEQ);
        public static final ForeignKey<TbPrdMstRecord, TbBrandMstRecord> TB_PRD_MST_FK1 = Internal.createForeignKey(com.rocketmart.jooq.Keys.KEY_TB_BRAND_MST_PRIMARY, TbPrdMst.TB_PRD_MST, "TB_PRD_MST_fk1", TbPrdMst.TB_PRD_MST.BRAND_SEQ);
        public static final ForeignKey<TbPrdWholesaleRecord, TbPrdMstRecord> TB_PRD_WHOLESALE_FK1 = Internal.createForeignKey(com.rocketmart.jooq.Keys.KEY_TB_PRD_MST_PRIMARY, TbPrdWholesale.TB_PRD_WHOLESALE, "TB_PRD_WHOLESALE_fk1", TbPrdWholesale.TB_PRD_WHOLESALE.PRODUCT_SEQ);
        public static final ForeignKey<TbWishMstRecord, TbPrdMstRecord> TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_FK = Internal.createForeignKey(com.rocketmart.jooq.Keys.KEY_TB_PRD_MST_PRIMARY, TbWishMst.TB_WISH_MST, "TB_WISHLIST_TB_PRD_MST_PRODUCT_SEQ_fk", TbWishMst.TB_WISH_MST.PRODUCT_SEQ);
    }
}
