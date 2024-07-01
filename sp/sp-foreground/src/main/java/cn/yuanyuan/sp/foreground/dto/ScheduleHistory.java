package cn.yuanyuan.sp.foreground.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ScheduleHistory {

    private int count;

    private String[] top3PNANS;

    private String food;

    private String professionalBook;

    private String interestedBook;

    private String app;

    private String game;

    private Map<String, Long> getUpCount;

    private Map<String, Long> getToBedCount;

    private Map<String, Long> categoryCount;
}
