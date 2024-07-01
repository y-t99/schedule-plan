package cn.yuanyuan.sp.mbg.constant;

public enum FieldValueEnum {

    UMS_USER_NOT_FORBID(0),
    UMS_USER_FORBID(1),
    ;

    private int status;

    FieldValueEnum(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
