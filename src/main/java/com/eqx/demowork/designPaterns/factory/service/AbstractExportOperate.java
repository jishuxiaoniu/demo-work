package com.eqx.demowork.designPaterns.factory.service;

import com.eqx.demowork.designPaterns.factory.api.ExportFileApi;

/**
 * @Author duan
 * @Description: 实现导出数据的业务功能对象
 * @Date: Created in 下午3:54 2018/7/11
 */
public abstract class AbstractExportOperate {

    public boolean export(String data) {
        // 使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     *
     * @return
     */
    protected abstract ExportFileApi factoryMethod();
}
