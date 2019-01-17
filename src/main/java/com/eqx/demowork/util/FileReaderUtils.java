package com.eqx.demowork.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午6:22 2018/8/21
 */
@Slf4j
public class FileReaderUtils {



    public static void main(String[] args) throws Exception {
        List<Integer> list = Lists.newArrayList();
        String path = "/Users/duanhuazhen/Downloads/tmp/20180829-142151-6456/enterprise4/data/logs/nginx/bigdataScene.text";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = "";

        while ((line = reader.readLine()) != null) {
//            log.info("line={}", line);
            int begin = line.indexOf("\"");
            int end = line.lastIndexOf("\"");
            try {
                String str = line.substring(begin+1, end);
//                log.info("str:{}", str);
                Double n = Double.parseDouble(str);
                Integer num = (int) (n * 1000);
                list.add(num);
            } catch (Exception e) {
                continue;
            }

        }

        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(e -> e).summaryStatistics();

        log.info("总数：" + intSummaryStatistics.getCount());
        log.info("最大值：" + intSummaryStatistics.getMax());
        log.info("最小值：" + intSummaryStatistics.getMin());
        log.info("平均值：" + intSummaryStatistics.getAverage());
        reader.close();
    }
}