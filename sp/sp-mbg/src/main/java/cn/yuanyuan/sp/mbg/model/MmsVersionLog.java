package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MmsVersionLog implements Serializable {
    private Integer id;

    @ApiModelProperty(value = " 标题")
    private String title;

    @ApiModelProperty(value = " 内容")
    private String content;

    @ApiModelProperty(value = " 版本号")
    private String version;

    @ApiModelProperty(value = " 时间")
    private Long timePoint;

    @ApiModelProperty(value = "版本更新类型 0-日常更新 1-大版本更新 2-bug修复")
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(Long timePoint) {
        this.timePoint = timePoint;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", version=").append(version);
        sb.append(", timePoint=").append(timePoint);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}