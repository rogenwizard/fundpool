package com.zkp.fp;

import com.zkp.fp.exception.ErrorCode;
import com.zkp.fp.exception.ExpensesException;
import com.zkp.fp.model.AllocationSupplyResult;
import com.zkp.fp.model.Fund;
import com.zkp.fp.utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 资金分配管理，资金计算采用高精度方式，确保资金计算可靠
 * @date: 2019/2/27
 */
public class AllocationSupply {

    // 资金排序工具类
    private final static FundPoolQuickSort<Fund> QUICK_SORT = new FundPoolQuickSort<>();

    /**
     * 按一定规则配置资金
     * @param fundPools 资金池集
     * @param exp 支取数量
     * @param maxOverDraft 最大透支额度，所有资金池集的总和
     * @return
     */
    public List<AllocationSupplyResult> allocationSupply(Fund[] fundPools, double exp, double maxOverDraft) throws ExpensesException {
        // 检测入参合法性
        checkArgument(fundPools, exp);
        // 资金池集的总资金
        double total = 0;
        for (Fund fund : fundPools) {
            total = Util.computeFundValue(total, fund.getFund(), 1);
        }
        // 获取支取后资金池剩余资金
        double remain = Util.computeFundValue(total, exp, 2);
        // 总资金不够支出时判断是否超最大透支额度
        if (Util.compareFundValue(remain, 0) == -1) {
            // 检测资金池透支额度是否超出
            if (Util.compareFundValue(Math.abs(remain), maxOverDraft) == 1) {
                // 总资金透支额度草删除
                throw new ExpensesException("insufficient funds", ErrorCode.INSUFFICIENT_FUNDS);
            }
        }

        // 分配资金构造分配结果
        return allocationFund(fundPools, total, exp);
    }

    /**
     * 检测方法参数
     * @param fundPools
     * @param exp
     */
    private void checkArgument(Fund[] fundPools, double exp) {
        if (fundPools == null || Util.compareFundValue(exp, 0) == -1) {
            throw new ExpensesException("input argument error, please check args", ErrorCode.ILLEGAL_FUNDS);
        }
    }

    /**
     * 从资金池集中分配支出
     * @param funds
     * @param total
     * @param exp
     * @return
     */
    private List<AllocationSupplyResult> allocationFund(Fund[] funds, double total, double exp) {
        // 资金池数量
        int size = funds.length;
        // 资金池对应的资金分配信息
        double[] allocationInfos = new double[size];
        // 计算资金支出后的平均值
        double avg = Util.computeFundValue(Util.computeFundValue(total, exp, 2), size, 4);

        if (Util.compareFundValue(avg, 0) != 1) {
            // 资金池不充足时,当前额度减去支出后的平均值
            for (int i = 0; i < size; i++) {
                allocationInfos[i] = Util.computeFundValue(funds[i].getFund(), avg, 2);
            }
            return buildAllocationResult(funds, allocationInfos);
        } else {
            // 资金池充足时,先对资金池集合进行排序，从大到小依次按当前额度减去支出后的平均值
            QUICK_SORT.quickSort(funds, 0, size - 1);
            // 资金池大于支出后平均值的最小索引
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (Util.compareFundValue(funds[i].getFund(), avg) == 1) {
                    index = i;
                    break;
                }
            }
            // 支出剩余金额
            double remain = exp;
            // 遍历
            for (int j = size - 1; j >= index; j--) {
                allocationInfos[j] = Util.computeFundValue(funds[j].getFund(), funds[index].getFund(), 2);
                remain = Util.computeFundValue(remain, allocationInfos[j], 2);
                if (Util.compareFundValue(remain, 0) != 1) {
                    allocationInfos[j] = Util.computeFundValue(remain, allocationInfos[j], 1);
                    break;
                }
            }
            return buildAllocationResult(funds, allocationInfos);
        }
    }

    /**
     * 构造分配结果
     * @param funds 源资金池集
     * @param allocationFunds 资金池对应分配数量
     * @return
     */
    private List<AllocationSupplyResult> buildAllocationResult(Fund[] funds, double[] allocationFunds) {
        List<AllocationSupplyResult> allocationSupplyResults = new ArrayList<>();
        if (allocationFunds == null || allocationFunds.length == 0) {
            return allocationSupplyResults;
        }
        for (int i = 0; i < funds.length; i++) {
            Fund fund = funds[i];
            AllocationSupplyResult allocationSupplyResult = new AllocationSupplyResult();
            allocationSupplyResult.setFundPoolId(fund.getId());
            allocationSupplyResult.setPreAllocationShotfalls(fund.getFund());
            allocationSupplyResult.setAllocationShotfalls(allocationFunds[i]);
            allocationSupplyResult.setAfterAllocationShotfalls(Util.computeFundValue(fund.getFund(), allocationFunds[i], 2));
            allocationSupplyResults.add(allocationSupplyResult);
        }

        return allocationSupplyResults;
    }
}
