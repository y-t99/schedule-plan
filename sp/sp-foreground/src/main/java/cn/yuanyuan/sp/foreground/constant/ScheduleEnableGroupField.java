package cn.yuanyuan.sp.foreground.constant;

public enum ScheduleEnableGroupField {
    IsDelay("isDelay"),
    IsFinish("isFinish"),
    Priority("priority"),
    ScheduleFactorCategoryId("scheduleFactorCategoryId");

    private final String field;

    ScheduleEnableGroupField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
