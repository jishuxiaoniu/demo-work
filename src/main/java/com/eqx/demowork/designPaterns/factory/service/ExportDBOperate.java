package com.eqx.demowork.designPaterns.factory.service;

import com.eqx.demowork.designPaterns.factory.api.ExportDB;
import com.eqx.demowork.designPaterns.factory.api.ExportFileApi;

/**
 * @Author duan
 * @Description: 具体的创建器实现对象，实现创建导出数据库备份文件形式的对象
 * @Date: Created in 下午3:59 2018/7/11
 */
public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        // 创建导出数据库文件形式的对象
        return new ExportDB();
    }
}
