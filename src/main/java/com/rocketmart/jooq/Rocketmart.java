/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq;


import com.rocketmart.jooq.tables.TbBrandMst;
import com.rocketmart.jooq.tables.TbMemMst;

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

    private static final long serialVersionUID = 1688551500;

    /**
     * The reference instance of <code>rocketmart</code>
     */
    public static final Rocketmart ROCKETMART = new Rocketmart();

    /**
     * 브랜드_정보
     */
    public final TbBrandMst TB_BRAND_MST = com.rocketmart.jooq.tables.TbBrandMst.TB_BRAND_MST;

    /**
     * 회원정보 마스터
     */
    public final TbMemMst TB_MEM_MST = com.rocketmart.jooq.tables.TbMemMst.TB_MEM_MST;

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
            TbMemMst.TB_MEM_MST);
    }
}
