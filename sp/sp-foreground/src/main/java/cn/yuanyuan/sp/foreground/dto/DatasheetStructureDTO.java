package cn.yuanyuan.sp.foreground.dto;

import lombok.Data;

@Data
public class DatasheetStructureDTO {

    private Integer userId;
    private String tableName;
    private String comment;
    private String tableStructureJson;

}
