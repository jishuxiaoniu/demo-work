package com.eqx.demowork.util;

import com.eqx.demowork.builder.ResPackage;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.*;

public class PoiUtils {
    private final static int COLUMN_SIZE = 20;
    private final static int MAX_ROW_PER_SHEET = 100000;

    private static OutputStream os = null;

    /**
     * 下载Excel模版
     *
     * @param clazz      导出数据类型
     * @param srcList    导出的书数据
     * @param resPackage 封装response
     * @param <T>
     */
    public static <T> void data2Excel(Class<T> clazz, List<T> srcList, ResPackage resPackage) throws Exception {
        if (clazz == null || !clazz.isAnnotationPresent(ModelTitle.class)) {
            throw new Exception("请在此类型中加上ModelTitle注解");
        }

        final HSSFWorkbook wb = new HSSFWorkbook();

        if (srcList != null && srcList.size() > 0) {

            List<PoiEntity> entityList = Lists.newArrayList();
            // 添加表头属性值
            Arrays.stream(clazz.getDeclaredFields())
                    .filter(e -> e.isAnnotationPresent(ModelProp.class) && e.getAnnotation(ModelProp.class).colIndex() != -1)
                    .forEach(field -> {
                        ModelProp modelProp = field.getAnnotation(ModelProp.class);
                        entityList.add(new PoiEntity(modelProp.colIndex(), field, modelProp.name(), modelProp.style()));
                    });

            List<List<T>> indexList = splitDataList(srcList, Math.min(resPackage.getMaxRowPerSheet(), MAX_ROW_PER_SHEET));
            indexList.stream().forEach(dataList -> {
                HSSFSheet sheet = createTitleSheet(wb, clazz.getAnnotation(ModelTitle.class).name());

                HSSFRow headRow = createHeadRow(wb, sheet, entityList);

                try {
                    createDataRows(wb, sheet, dataList, entityList);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // 合并第一行单元格
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, entityList.size() - 1));
            });
        } else {
            HSSFSheet sheet = createTitleSheet(wb, clazz.getAnnotation(ModelTitle.class).name());

            List<PoiEntity> entityList = Lists.newArrayList();
            // 添加表头属性值
            Arrays.stream(clazz.getDeclaredFields())
                    .filter(e -> e.isAnnotationPresent(ModelProp.class) && e.getAnnotation(ModelProp.class).colIndex() != -1)
                    .forEach(field -> {
                        ModelProp modelProp = field.getAnnotation(ModelProp.class);
                        entityList.add(new PoiEntity(modelProp.colIndex(), field, modelProp.name(), modelProp.style()));
                    });
            HSSFRow headRow = createHeadRow(wb, sheet, entityList);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, entityList.size() - 1));
        }

        try {
            os = resPackage.getOutputStream();
            wb.write(resPackage.getOutputStream());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 把 list 根据容量分成多个list
     *
     * @param srcList 原始集合
     * @param maxSize 拆分阀值
     * @param <T>     集合类型
     * @return
     */
    private static <T> List<List<T>> splitDataList(List<T> srcList, int maxSize) {
        List<List<T>> indexLists = new ArrayList<>();
        if (srcList.size() > maxSize) {
            int times = srcList.size() % maxSize == 0 ? srcList.size() / maxSize : srcList.size() / maxSize + 1;
            for (int i = 0; i < times; i++) {
                List<T> list = Lists.newArrayList();
                int rowJ = i + 1 == times ? srcList.size() % maxSize == 0 ? maxSize : srcList.size() % maxSize : maxSize;
                for (int j = 0; j < rowJ; j++)
                    list.add(srcList.get(i));
                indexLists.add(list);
            }
        } else {
            List<T> list = Lists.newArrayList();
            for (int i = 0; i < srcList.size(); i++) {
                list.add(srcList.get(i));
            }
            indexLists.add(list);
        }
        return indexLists;
    }

    private static <T> void createDataRows(HSSFWorkbook wb, HSSFSheet sheet, List<T> dataList, List<PoiEntity> entityList) throws Exception {

        for (int i = 0; i < dataList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 2);
            for (PoiEntity entity : entityList) {
                T t = dataList.get(i);
                Field field = entity.getField();
                field.setAccessible(true);
                Object obj = field.get(t);
                if (obj == null)
                    continue;
                HSSFCellStyle style = wb.createCellStyle();
                style.setAlignment(entity.getStyle());
                HSSFCell cell = row.createCell(entity.getIndex());
                cell.setCellStyle(style);
                setCellValue(cell, field.get(t));
            }
        }
    }

    private static HSSFRow createHeadRow(HSSFWorkbook wb, HSSFSheet sheet, List<PoiEntity> entityList) {
        HSSFRow headRow = sheet.createRow(1);
        // 设置表头样式
        HSSFCellStyle headStyle = wb.createCellStyle();
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headFont = wb.createFont();
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headFont.setFontHeight((short) 240);
        headStyle.setFont(headFont);

        for (PoiEntity entity : entityList) {
            HSSFCell cell = headRow.createCell(entity.getIndex());
            cell.setCellValue(new HSSFRichTextString(entity.getFieldName()));
            cell.setCellStyle(headStyle);
        }
        return headRow;
    }

    private static HSSFSheet createTitleSheet(HSSFWorkbook wb, String titleName) {
        HSSFSheet sheet = wb.createSheet();
        // 设置标题样式
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeight((short) 400);
        titleStyle.setFont(font);
        HSSFCell titleCell = sheet.createRow(0).createCell(0); // 创建第一行，并在该行创建单元格，设置内容，做为标题行
        /**
         * 获取标题
         */
        titleCell.setCellValue(new HSSFRichTextString(titleName));
        titleCell.setCellStyle(titleStyle);

//        sheet.autoSizeColumn(1, true);
        sheet.setDefaultColumnWidth(COLUMN_SIZE);
        return sheet;
    }

    private static void setCellValue(HSSFCell cell, Object obj) throws Exception {
        if (obj instanceof String) {
            cell.setCellValue((String) obj);
        } else if (obj instanceof Double) {
            cell.setCellValue((Double) obj);
        } else if (obj instanceof Boolean) {
            cell.setCellValue((Boolean) obj);
        } else if (obj instanceof Date) {
            cell.setCellValue((Date) obj);
        } else if (obj instanceof Calendar) {
            cell.setCellValue((Calendar) obj);
        } else if (obj instanceof RichTextString) {
            cell.setCellValue((RichTextString) obj);
        } else {
            cell.setCellValue("" + obj);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ModelProp {
        String name();

        int colIndex() default -1;

        short style() default CellStyle.ALIGN_LEFT;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ModelTitle {
        String name();
    }

    @Data
    @AllArgsConstructor
    static class PoiEntity {
        private Integer index;
        private Field field;
        private String fieldName;
        private short style;
    }

}
