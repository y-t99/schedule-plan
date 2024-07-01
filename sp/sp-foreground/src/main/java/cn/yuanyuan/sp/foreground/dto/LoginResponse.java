package cn.yuanyuan.sp.foreground.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录成功返回信息")
public class LoginResponse {
    @ApiModelProperty(value = "ID号")
    private Integer id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty("token 令牌头部")
    private String tokenHead;

    @ApiModelProperty("token 令牌")
    private String token;

    private String likedBook;

    private String likedThing;

    private String saying;
}
