package cn.yuanyuan.sp.foreground.controller;

import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.foreground.constant.ResponseCode;
import cn.yuanyuan.sp.foreground.domain.UserAccountDetail;
import cn.yuanyuan.sp.foreground.dto.LoginParam;
import cn.yuanyuan.sp.foreground.dto.LoginResponse;
import cn.yuanyuan.sp.foreground.dto.RegisterParam;
import cn.yuanyuan.sp.foreground.exception.AccountIsExistExcetion;
import cn.yuanyuan.sp.foreground.service.UmsUserService;
import cn.yuanyuan.sp.mbg.model.UmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@Api(tags = "前台用户控制器")
public class UmsUserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    final UmsUserService userService;

    public UmsUserController(UmsUserService userService) {
        this.userService = userService;
    }

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public CommonResult<LoginResponse> login(@RequestBody LoginParam loginParam) {
        Optional<String> token = userService.login(loginParam.getAccount(), loginParam.getPassword());
        if (!token.isPresent()) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UmsUser umsUser = ((UserAccountDetail) authentication.getPrincipal()).getUmsUser();
        LoginResponse data = new LoginResponse();
        BeanUtils.copyProperties(umsUser, data);
        data.setTokenHead(tokenHead);
        data.setToken(token.get());
        return CommonResult.success(data);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public CommonResult<UmsUser> register(@Validated @RequestBody RegisterParam registerParam) {
        UmsUser user;
        try {
            user = userService.register(registerParam.getAccount(), registerParam.getPassword(), registerParam.getName());
        } catch (AccountIsExistExcetion accountIsExistExcetion) {
            return CommonResult.getInstance(ResponseCode.AccountIsExist.getCode(), ResponseCode.AccountIsExist.getMessage());
        }
        return CommonResult.success(user, "注册成功");
    }
}
