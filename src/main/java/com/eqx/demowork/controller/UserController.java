package com.eqx.demowork.controller;

import com.eqx.demowork.annotation.Auth;
import com.eqx.demowork.annotation.CurrentUser;
import com.eqx.demowork.form.UserForm;
import com.eqx.demowork.model.User;
import com.eqx.demowork.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:58 2018/4/12
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户信息", tags = "users")
@Slf4j
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Auth
    @PostMapping("/add")
    @ApiOperation(value = "新增用户", tags = {"users"})
    public User addUser(@RequestBody @Valid UserForm userForm, BindingResult result) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        userService.addUser(user);
        return user;
    }

    @GetMapping("/print")
    @ApiOperation(value = "打印当前用户信息", tags = {"users"})
    public User printUser(@ApiIgnore @CurrentUser User user) {
        return user;
    }
}
