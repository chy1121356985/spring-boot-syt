package com.chy.excel;

import com.alibaba.excel.EasyExcel;
import com.chy.entity.ExcelTwo;

public class ReadExcel {
    public static void main(String[] args) {
        String filePath="D:\\学习资料\\excel\\新建 XLS 工作表.xls";

        EasyExcel.read(filePath, ExcelTwo.class,new ReadExcelUtil()).sheet().doRead();
    }
}
