package cn.yuanyuan.sp.common.exception;

public class UpdateForbidException extends RuntimeException{
    public UpdateForbidException() {
    }

    public UpdateForbidException(String message) {
        super(message);
    }

    public UpdateForbidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateForbidException(Throwable cause) {
        super(cause);
    }

    public UpdateForbidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
