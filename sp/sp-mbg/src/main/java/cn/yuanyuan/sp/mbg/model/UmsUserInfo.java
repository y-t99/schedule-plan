package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsUserInfo implements Serializable {
    @ApiModelProperty(value = " userid")
    private Integer userId;

    @ApiModelProperty(value = "喜欢的书籍")
    private String likedBook;

    @ApiModelProperty(value = "喜欢的东西")
    private String likedThing;

    @ApiModelProperty(value = "个性签名")
    private String saying;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLikedBook() {
        return likedBook;
    }

    public void setLikedBook(String likedBook) {
        this.likedBook = likedBook;
    }

    public String getLikedThing() {
        return likedThing;
    }

    public void setLikedThing(String likedThing) {
        this.likedThing = likedThing;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", likedBook=").append(likedBook);
        sb.append(", likedThing=").append(likedThing);
        sb.append(", saying=").append(saying);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}