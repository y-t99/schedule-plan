package cn.yuanyuan.sp.common.exception;

public class InsertForbidException extends RuntimeException{
    public InsertForbidException() {
    }

    public InsertForbidException(String message) {
        super(message);
    }

    public InsertForbidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertForbidException(Throwable cause) {
        super(cause);
    }

    public InsertForbidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
