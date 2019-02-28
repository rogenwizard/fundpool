package com.zkp.fp;

import com.zkp.fp.model.AllocationSupplyResult;
import com.zkp.fp.model.Fund;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @date: 2019/2/28
 */
public class TestAllocationSupply {

    private AllocationSupply allocationSupply = new AllocationSupply();

    @Test
    public void testOne() {
        Fund fund1 = new Fund(1, 1);
        Fund fund2 = new Fund(2, 2);
        Fund fund3 = new Fund(3, 3);
        Fund fund4 = new Fund(4, 4);
        Fund fund5 = new Fund(5, 5);
        Fund fund6 = new Fund(6, 6);
        Fund fund7 = new Fund(7, 7);
        Fund fund8 = new Fund(8, 8);
        Fund fund9 = new Fund(9, 9);
        Fund fund10 = new Fund(10, 10);
        Fund[] funds = new Fund[] {fund1, fund2, fund3, fund4, fund5, fund6, fund7, fund8, fund9, fund10};
        List<AllocationSupplyResult> allocationSupplyResults = allocationSupply.allocationSupply(funds, 15, 100000);
        Assert.assertTrue(allocationSupplyResults.size() == 10);
        Assert.assertTrue(allocationSupplyResults.get(9).getAllocationShotfalls() == 5);
    }

    @Test
    public void testTwo() {
        Fund fund1 = new Fund(1, 20);
        Fund fund2 = new Fund(2, 47);
        Fund fund3 = new Fund(3, 21);
        Fund fund4 = new Fund(4, 41);
        Fund fund5 = new Fund(5, 29);
        Fund fund6 = new Fund(6, 9);
        Fund fund7 = new Fund(7, 76);
        Fund fund8 = new Fund(8, 97);
        Fund fund9 = new Fund(9, 29);
        Fund fund10 = new Fund(10, 66);
        Fund fund11 = new Fund(11, 60);
        Fund fund12 = new Fund(12, 92);
        Fund fund13 = new Fund(13, 94);
        Fund fund14 = new Fund(14, 27);
        Fund fund15 = new Fund(15, 43);
        Fund fund16 = new Fund(16, 75);
        Fund fund17 = new Fund(17, 41);
        Fund fund18 = new Fund(18, 74);
        Fund fund19 = new Fund(19, 64);
        Fund fund20 = new Fund(20, 61);
        Fund[] funds = new Fund[] {fund1, fund2, fund3, fund4, fund5, fund6, fund7, fund8, fund9, fund10,
                fund11, fund12, fund13, fund14, fund15, fund16, fund17, fund18, fund19, fund20};
        List<AllocationSupplyResult> allocationSupplyResults = allocationSupply.allocationSupply(funds, 5000, 100000);
        Assert.assertTrue(allocationSupplyResults.size() == 20);
        Assert.assertTrue(allocationSupplyResults.get(10).getAfterAllocationShotfalls() == 60);
    }

}
