package com.eqx.demowork.designPaterns.factory.service;

import com.eqx.demowork.designPaterns.factory.api.ExportFileApi;
import com.eqx.demowork.designPaterns.factory.api.ExportTxtFile;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:58 2018/7/11
 */
public class ExportTxtFileOperate extends AbstractExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        // 创建导出成文本格式的对象
        return new ExportTxtFile();
    }
}
