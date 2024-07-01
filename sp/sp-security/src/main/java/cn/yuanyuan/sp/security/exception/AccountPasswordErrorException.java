package cn.yuanyuan.sp.security.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountPasswordErrorException extends AuthenticationException {
    public AccountPasswordErrorException(String msg, Throwable t) {
        super(msg, t);
    }

    public AccountPasswordErrorException(String msg) {
        super(msg);
    }
}
