/*
 * This file is generated by jOOQ.
 */
package com.rocketmart.jooq.tables.records;


import com.rocketmart.jooq.tables.TbPrdFob;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 상품별 도매가격(FOB)
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbPrdFobRecord extends UpdatableRecordImpl<TbPrdFobRecord> implements Record10<Integer, Integer, Long, Long, Long, Integer, String, String, String, String> {

    private static final long serialVersionUID = -154423009;

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.FOB_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public void setFobSeq(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.FOB_SEQ</code>. 도매가격(FOB) 일련번호
     */
    public Integer getFobSeq() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public void setProductSeq(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.PRODUCT_SEQ</code>. 상품 일련번호
     */
    public Integer getProductSeq() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.RANGE_START</code>. 범위 구간 시작
     */
    public void setRangeStart(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.RANGE_START</code>. 범위 구간 시작
     */
    public Long getRangeStart() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.RANGE_END</code>. 범위 구간 끝
     */
    public void setRangeEnd(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.RANGE_END</code>. 범위 구간 끝
     */
    public Long getRangeEnd() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.TRADING_PRICE</code>. 거래가(U$)
     */
    public void setTradingPrice(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.TRADING_PRICE</code>. 거래가(U$)
     */
    public Long getTradingPrice() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.SUPPLY_RATE</code>. 공급률
     */
    public void setSupplyRate(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.SUPPLY_RATE</code>. 공급률
     */
    public Integer getSupplyRate() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.OPTION_1</code>. 옵션1
     */
    public void setOption_1(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.OPTION_1</code>. 옵션1
     */
    public String getOption_1() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.OPTION_2</code>. 옵션2
     */
    public void setOption_2(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.OPTION_2</code>. 옵션2
     */
    public String getOption_2() {
        return (String) get(7);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.OPTION_3</code>. 옵션3
     */
    public void setOption_3(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.OPTION_3</code>. 옵션3
     */
    public String getOption_3() {
        return (String) get(8);
    }

    /**
     * Setter for <code>rocketmart.TB_PRD_FOB.DEL_YN</code>. 삭제여부
     */
    public void setDelYn(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>rocketmart.TB_PRD_FOB.DEL_YN</code>. 삭제여부
     */
    public String getDelYn() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Integer, Long, Long, Long, Integer, String, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Integer, Long, Long, Long, Integer, String, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbPrdFob.TB_PRD_FOB.FOB_SEQ;
    }

    @Override
    public Field<Integer> field2() {
        return TbPrdFob.TB_PRD_FOB.PRODUCT_SEQ;
    }

    @Override
    public Field<Long> field3() {
        return TbPrdFob.TB_PRD_FOB.RANGE_START;
    }

    @Override
    public Field<Long> field4() {
        return TbPrdFob.TB_PRD_FOB.RANGE_END;
    }

    @Override
    public Field<Long> field5() {
        return TbPrdFob.TB_PRD_FOB.TRADING_PRICE;
    }

    @Override
    public Field<Integer> field6() {
        return TbPrdFob.TB_PRD_FOB.SUPPLY_RATE;
    }

    @Override
    public Field<String> field7() {
        return TbPrdFob.TB_PRD_FOB.OPTION_1;
    }

    @Override
    public Field<String> field8() {
        return TbPrdFob.TB_PRD_FOB.OPTION_2;
    }

    @Override
    public Field<String> field9() {
        return TbPrdFob.TB_PRD_FOB.OPTION_3;
    }

    @Override
    public Field<String> field10() {
        return TbPrdFob.TB_PRD_FOB.DEL_YN;
    }

    @Override
    public Integer component1() {
        return getFobSeq();
    }

    @Override
    public Integer component2() {
        return getProductSeq();
    }

    @Override
    public Long component3() {
        return getRangeStart();
    }

    @Override
    public Long component4() {
        return getRangeEnd();
    }

    @Override
    public Long component5() {
        return getTradingPrice();
    }

    @Override
    public Integer component6() {
        return getSupplyRate();
    }

    @Override
    public String component7() {
        return getOption_1();
    }

    @Override
    public String component8() {
        return getOption_2();
    }

    @Override
    public String component9() {
        return getOption_3();
    }

    @Override
    public String component10() {
        return getDelYn();
    }

    @Override
    public Integer value1() {
        return getFobSeq();
    }

    @Override
    public Integer value2() {
        return getProductSeq();
    }

    @Override
    public Long value3() {
        return getRangeStart();
    }

    @Override
    public Long value4() {
        return getRangeEnd();
    }

    @Override
    public Long value5() {
        return getTradingPrice();
    }

    @Override
    public Integer value6() {
        return getSupplyRate();
    }

    @Override
    public String value7() {
        return getOption_1();
    }

    @Override
    public String value8() {
        return getOption_2();
    }

    @Override
    public String value9() {
        return getOption_3();
    }

    @Override
    public String value10() {
        return getDelYn();
    }

    @Override
    public TbPrdFobRecord value1(Integer value) {
        setFobSeq(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value2(Integer value) {
        setProductSeq(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value3(Long value) {
        setRangeStart(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value4(Long value) {
        setRangeEnd(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value5(Long value) {
        setTradingPrice(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value6(Integer value) {
        setSupplyRate(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value7(String value) {
        setOption_1(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value8(String value) {
        setOption_2(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value9(String value) {
        setOption_3(value);
        return this;
    }

    @Override
    public TbPrdFobRecord value10(String value) {
        setDelYn(value);
        return this;
    }

    @Override
    public TbPrdFobRecord values(Integer value1, Integer value2, Long value3, Long value4, Long value5, Integer value6, String value7, String value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbPrdFobRecord
     */
    public TbPrdFobRecord() {
        super(TbPrdFob.TB_PRD_FOB);
    }

    /**
     * Create a detached, initialised TbPrdFobRecord
     */
    public TbPrdFobRecord(Integer fobSeq, Integer productSeq, Long rangeStart, Long rangeEnd, Long tradingPrice, Integer supplyRate, String option_1, String option_2, String option_3, String delYn) {
        super(TbPrdFob.TB_PRD_FOB);

        set(0, fobSeq);
        set(1, productSeq);
        set(2, rangeStart);
        set(3, rangeEnd);
        set(4, tradingPrice);
        set(5, supplyRate);
        set(6, option_1);
        set(7, option_2);
        set(8, option_3);
        set(9, delYn);
    }
}