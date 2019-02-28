package com.zkp.fp.utils;

import java.math.BigDecimal;

/**
 * @date: 2019/2/27
 */
public final class Util {

    /**
     * 资金数额计算
     * @param first
     * @param second
     * @param type
     * @return
     */
    public static double computeFundValue(final double first, final double second, final int type) {
        BigDecimal firstDecimal = new BigDecimal(first);
        BigDecimal secondDecimal = new BigDecimal(second);
        if (type == 1) {
            return firstDecimal.add(secondDecimal).doubleValue();
        } else if (type == 2) {
            return firstDecimal.subtract(secondDecimal).doubleValue();
        } else if (type == 3) {
            return firstDecimal.multiply(secondDecimal).doubleValue();
        } else if (type == 4) {
            return firstDecimal.divide(secondDecimal).doubleValue();
        }
        else {
            throw new IllegalStateException("illegal type value");
        }
    }

    /**
     * 资金数额比较
     * @param first
     * @param second
     * @return
     */
    public static int compareFundValue(final double first, final double second) {
        BigDecimal firstDecimal = new BigDecimal(first);
        BigDecimal secondDecimal = new BigDecimal(second);
        return firstDecimal.compareTo(secondDecimal);
    }
}
