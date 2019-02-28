package com.zkp.fp.model;

import java.math.BigDecimal;

/**
 * @date: 2019/2/27
 */
public class Fund implements Comparable {

    /**
     * 资金池编号
     */
    private long id;

    /**
     * 资金数
     */
    protected double fund;

    /**
     *
     * @param id
     * @param fund
     */

    public Fund(long id, double fund) {
        this.id = id;
        this.fund = fund;
    }

    @Override
    public int compareTo(Object o) {
        Fund fd = (Fund) o;
        BigDecimal fundNum = new BigDecimal(fund);
        BigDecimal fdNum = new BigDecimal(fd == null ? 0.0 : fd.getFund());
        return fundNum.compareTo(fdNum);
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
