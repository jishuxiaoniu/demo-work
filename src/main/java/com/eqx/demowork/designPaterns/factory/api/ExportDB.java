package com.eqx.demowork.designPaterns.factory.api;

/**
 * @Author duan
 * @Description: 将数据导出为数据库格式
 * @Date: Created in 下午3:34 2018/7/11
 */
public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("The result is DB ----> 数据导出");
        return true;
    }
}