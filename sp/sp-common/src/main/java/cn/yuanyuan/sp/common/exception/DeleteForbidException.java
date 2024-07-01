package cn.yuanyuan.sp.common.exception;

public class DeleteForbidException extends RuntimeException{
    public DeleteForbidException() {
    }

    public DeleteForbidException(String message) {
        super(message);
    }

    public DeleteForbidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteForbidException(Throwable cause) {
        super(cause);
    }

    public DeleteForbidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
