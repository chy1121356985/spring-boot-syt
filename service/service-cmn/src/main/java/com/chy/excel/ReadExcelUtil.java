package com.chy.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chy.entity.ExcelTwo;

import java.util.Map;

/**
 *
 * @author 11213
 * 读excel表格数据
 */
public class ReadExcelUtil extends AnalysisEventListener<ExcelTwo> {


    //一行一行读取 从第二行开始
    @Override
    public void invoke(ExcelTwo excelTwo, AnalysisContext analysisContext) {
        System.out.println(excelTwo);
    }

    //读取表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息"+headMap);
    }



    //读取之后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
