package com.eqx.demowork.common;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午5:44 2018/4/11
 */
@ApiModel(value = "返回基类")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> {

    private int code;

    private String message;

    private List<T> list;

    private Map<String, String> map;

    public ResultData<T> success() {
        return new ResultData<>();
    }
}
