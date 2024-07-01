package cn.yuanyuan.sp.security.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountForbidException extends AuthenticationException {
    public AccountForbidException(String msg, Throwable t) {
        super(msg, t);
    }

    public AccountForbidException(String msg) {
        super(msg);
    }
}
