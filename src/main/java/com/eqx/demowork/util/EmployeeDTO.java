package com.eqx.demowork.util;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.Serializable;

@PoiUtils.ModelTitle(name = "人员列表")
@Data
@Builder
public class EmployeeDTO implements Serializable {

    @PoiUtils.ModelProp(name = "ID", colIndex = 1)
    private Long id;
    @PoiUtils.ModelProp(name = "电话", colIndex = 1, style = CellStyle.ALIGN_LEFT)
    private String telephone;
    @PoiUtils.ModelProp(name = "名称", colIndex = 0, style = CellStyle.ALIGN_CENTER)
    private String name;
    @PoiUtils.ModelProp(name = "性别", colIndex = 2, style = CellStyle.ALIGN_RIGHT)
    private Integer sex;

}
