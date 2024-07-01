package cn.yuanyuan.sp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsUser implements Serializable {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "禁止;是否禁止 0 否 1 是")
    private Integer isForbid;

    @ApiModelProperty(value = "账号状态 0 申请中 1 使用中 2 注销 3拒绝申请")
    private Integer statue;

    @ApiModelProperty(value = "是否需要提示账号状态")
    private Integer isNotify;

    @ApiModelProperty(value = "账户类型 0 前台用户 1 后台管理员")
    private Integer type;

    private String likedBook;

    private String likedThing;

    private String saying;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsForbid() {
        return isForbid;
    }

    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(Integer isNotify) {
        this.isNotify = isNotify;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", isForbid=").append(isForbid);
        sb.append(", statue=").append(statue);
        sb.append(", isNotify=").append(isNotify);
        sb.append(", type=").append(type);
        sb.append(", likedBook=").append(likedBook);
        sb.append(", likedThing=").append(likedThing);
        sb.append(", saying=").append(saying);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}