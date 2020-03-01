/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbCmAfile;
import com.rocketmart.jooq.tables.TbMemMst;
import com.rocketmart.jooq.tables.TbOtherContactUs;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in rocketmart
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 브랜드_정보
     */
    public static final TbBrandMst TB_BRAND_MST = TbBrandMst.TB_BRAND_MST;

    /**
     * 첨부파일
     */
    public static final TbCmAfile TB_CM_AFILE = TbCmAfile.TB_CM_AFILE;

    /**
     * 회원정보 마스터
     */
    public static final TbMemMst TB_MEM_MST = TbMemMst.TB_MEM_MST;

    /**
     * 관리자 문의
     */
    public static final TbOtherContactUs TB_OTHER_CONTACT_US = TbOtherContactUs.TB_OTHER_CONTACT_US;
}
