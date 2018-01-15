package com.eqx.demowork.controller;

import com.eqx.demowork.annotation.Auth;
import com.eqx.demowork.builder.ResPackage;
import com.eqx.demowork.model.User;
import com.eqx.demowork.util.EmployeeDTO;
import com.eqx.demowork.util.PoiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldController {

    @Auth
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {

        return User.builder()
                .id(id)
//                .name("张三")
                .age(11)
                .address("北京市")
                .build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getName() {
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
//        return "hello";
    }

}
