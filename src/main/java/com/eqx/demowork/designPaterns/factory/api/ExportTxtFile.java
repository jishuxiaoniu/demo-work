package com.eqx.demowork.designPaterns.factory.api;

/**
 * @Author duan
 * @Description: 将数据导出为文本格式
 * @Date: Created in 下午3:33 2018/7/11
 */
public class ExportTxtFile implements ExportFileApi {
    @Override
    public boolean export(String data) {
        // 在此操作文件
        System.out.println("The result is txt ----> 导出文件");
        return true;
    }
}
