package com.eqx.demowork.builder;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class ResPackage {

    private HttpServletResponse response;

    private String fileName;

    private Integer maxRowPerSheet = 1000;

    public ResPackage(HttpServletResponse response) throws Exception {
        this(response, UUID.randomUUID().toString());
    }

    public ResPackage(HttpServletResponse response, Integer maxRowPerSheet) throws Exception {
        this(response, UUID.randomUUID().toString(), maxRowPerSheet);
    }

    public ResPackage(HttpServletResponse response, String fileName) throws Exception {
        this(response, fileName, null);
    }

    public ResPackage(HttpServletResponse response, String fileName, Integer maxRowPerSheet) throws Exception {
        this.response = response;
        this.fileName = StringUtils.isEmpty(fileName) ? UUID.randomUUID().toString() : fileName;
        if (maxRowPerSheet != null) {
            this.maxRowPerSheet = maxRowPerSheet;
        }
        response.setContentType("application/xls");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes("UTF-8"), "iso-8859-1") + ".xls");
    }

    public OutputStream getOutputStream() throws IOException {
        return this.response.getOutputStream();
    }

    public int getMaxRowPerSheet() {
        return maxRowPerSheet;
    }
}
