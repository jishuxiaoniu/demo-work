package com.eqx.demowork.controller;

import com.eqx.demowork.annotation.Auth;
import com.eqx.demowork.builder.ResPackage;
import com.eqx.demowork.form.UserForm;
import com.eqx.demowork.model.User;
import com.eqx.demowork.util.EmployeeDTO;
import com.eqx.demowork.util.PoiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanhuazhen
 */
@RestController
@RequestMapping("/hello")
@Slf4j
@Api(value = "用户信息", tags = "hello")
@Validated
public class HelloWorldController {

    @Auth
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户信息")
    public User getUser(@ApiParam(value = "用户id") @PathVariable Integer id) {
        return User.builder()
                .id(id)
                .name("张三")
                .age(11)
                .address("北京市")
                .build();
    }

    @ApiOperation(value = "根据用户id，获取用户姓名")
    @RequestMapping(method = RequestMethod.GET)
    public String getName(@Range(min = 1, max = 100, message = "ID只能从1-100") @ApiParam(value = "用户ID", required = true) @RequestParam Integer userId) {
        return "Hello world" + System.currentTimeMillis();
    }

    @RequestMapping("/excel")
    public void orderDetailExport(HttpServletResponse response, @RequestParam Integer maxLine) {

        try {
            List<EmployeeDTO> list = new ArrayList<>();

            for (int i = 0; i <= maxLine; i++) {
                EmployeeDTO employeeDTO = EmployeeDTO.builder().id(1L).name("asdfas").telephone("123131").sex(1).build();
                list.add(employeeDTO);
            }

            PoiUtils.data2Excel(EmployeeDTO.class, list, new ResPackage(response, "订单"));

        } catch (Exception e) {
            log.error("downloadEmployeeModel() catch Exception ", e);
        }
    }

}
