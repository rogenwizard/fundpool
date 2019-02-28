package com.zkp.fp.exception;

/**
 * 资金支取异常
 * @date: 2019/2/27
 */
public class ExpensesException extends RuntimeException {

    private static final long serialVersionUID = -7120201445145592600L;

    protected ErrorCode errorCode;

    public ExpensesException() {
    }

    public ExpensesException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ExpensesException(String message) {
        super(message);
    }

    public ExpensesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpensesException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ExpensesException(Throwable cause) {
        super(cause);
    }
}
