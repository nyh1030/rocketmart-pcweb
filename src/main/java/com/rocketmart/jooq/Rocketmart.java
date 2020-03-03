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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Rocketmart extends SchemaImpl {

    private static final long serialVersionUID = 1751735140;

    /**
     * The reference instance of <code>rocketmart</code>
     */
    public static final Rocketmart ROCKETMART = new Rocketmart();

    /**
     * 브랜드_정보
     */
    public final TbBrandMst TB_BRAND_MST = com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;

    /**
     * 카테고리_정보
     */
    public final TbCateMst TB_CATE_MST = com.rocketmart.jooq.tables.TbCateMst.TB_CATE_MST;

    /**
     * 첨부파일
     */
    public final TbCmAfile TB_CM_AFILE = com.rocketmart.jooq.tables.TbCmAfile.TB_CM_AFILE;

    /**
     * 관리자 문의
     */
    public final TbContactUs TB_CONTACT_US = com.rocketmart.jooq.tables.TbContactUs.TB_CONTACT_US;

    /**
     * 상품 문의내역 상세
     */
    public final TbInquiryDtl TB_INQUIRY_DTL = com.rocketmart.jooq.tables.TbInquiryDtl.TB_INQUIRY_DTL;

    /**
     * 상품 문의내역
     */
    public final TbInquiryMst TB_INQUIRY_MST = com.rocketmart.jooq.tables.TbInquiryMst.TB_INQUIRY_MST;

    /**
     * 회원정보 마스터
     */
    public final TbMemMst TB_MEM_MST = com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;

    /**
     * 상품 마스터
     */
    public final TbPrdMst TB_PRD_MST = com.rocketmart.jooq.tables.TbPrdMst.TB_PRD_MST;

    /**
     * 상품별 도매가격(FOB)
     */
    public final TbPrdWholesale TB_PRD_WHOLESALE = com.rocketmart.jooq.tables.TbPrdWholesale.TB_PRD_WHOLESALE;

    /**
     * WISH LIST 마스터
     */
    public final TbWishMst TB_WISH_MST = com.rocketmart.jooq.tables.TbWishMst.TB_WISH_MST;

    /**
     * No further instances allowed
     */
    private Rocketmart() {
        super("rocketmart", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            TbBrandMst.TB_BRAND_MST,
            TbCateMst.TB_CATE_MST,
            TbCmAfile.TB_CM_AFILE,
            TbContactUs.TB_CONTACT_US,
            TbInquiryDtl.TB_INQUIRY_DTL,
            TbInquiryMst.TB_INQUIRY_MST,
            TbMemMst.TB_MEM_MST,
            TbPrdMst.TB_PRD_MST,
            TbPrdWholesale.TB_PRD_WHOLESALE,
            TbWishMst.TB_WISH_MST);
    }
}
