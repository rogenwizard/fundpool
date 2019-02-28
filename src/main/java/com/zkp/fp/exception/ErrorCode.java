package com.zkp.fp.exception;

public enum ErrorCode {

    INSUFFICIENT_FUNDS(1, "资金不足"),
    ILLEGAL_FUNDS(1, "资金参数不合法");


    private int code;
    private String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

}