package com.zkp.fp.model;

/**
 * @date: 2019/2/27
 */
public class AllocationSupplyResult {

    /**
     * 资金池标示
     */
    private long fundPoolId;

    /**
     * 支取前资金
     */
    private Double preAllocationShotfalls;

    /**
     * 支取资金
     */
    private Double allocationShotfalls;

    /**
     * 支取后资金
     */
    private Double afterAllocationShotfalls;

    public long getFundPoolId() {
        return fundPoolId;
    }

    public void setFundPoolId(long fundPoolId) {
        this.fundPoolId = fundPoolId;
    }

    public Double getPreAllocationShotfalls() {
        return preAllocationShotfalls;
    }

    public void setPreAllocationShotfalls(Double preAllocationShotfalls) {
        this.preAllocationShotfalls = preAllocationShotfalls;
    }

    public Double getAllocationShotfalls() {
        return allocationShotfalls;
    }

    public void setAllocationShotfalls(Double allocationShotfalls) {
        this.allocationShotfalls = allocationShotfalls;
    }

    public Double getAfterAllocationShotfalls() {
        return afterAllocationShotfalls;
    }

    public void setAfterAllocationShotfalls(Double afterAllocationShotfalls) {
        this.afterAllocationShotfalls = afterAllocationShotfalls;
    }
}
