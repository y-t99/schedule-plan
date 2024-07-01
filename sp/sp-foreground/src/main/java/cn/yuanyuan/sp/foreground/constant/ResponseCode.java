package cn.yuanyuan.sp.foreground.constant;

import cn.yuanyuan.sp.common.api.IErrorCode;

public enum ResponseCode implements IErrorCode {

    AccountIsExist(491, "账号存在");

    private final long code;
    private final String message;

    ResponseCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
