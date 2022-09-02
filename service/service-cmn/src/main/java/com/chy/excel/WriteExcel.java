package com.chy.excel;

import com.alibaba.excel.EasyExcel;
import com.chy.entity.Excel;

import java.util.ArrayList;

/**
 *数据写入到excel
 */
public class WriteExcel {
    public static void main(String[] args) {

        ArrayList<Excel> excels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Excel excel = new Excel();
            excel.setName("chy"+i);
            excel.setAge(i);
            excels.add(excel);
        }

        String filePath="D:\\学习资料\\excel\\新建 XLS 工作表.xls";
        EasyExcel.write(filePath,Excel.class).sheet("用户信息").doWrite(excels);

    }

}
