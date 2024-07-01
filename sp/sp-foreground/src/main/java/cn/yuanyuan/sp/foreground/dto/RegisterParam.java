package cn.yuanyuan.sp.foreground.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterParam {

    @ApiModelProperty(value = "账号", required = true)
    @NotEmpty
    private String account;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;

    @ApiModelProperty(value = "昵称", required = true)
    @NotEmpty
    private String name;


}
