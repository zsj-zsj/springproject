package com.shop.eduservice.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.shop.eduservice.entity.ExcelTestRead;
import com.shop.eduservice.entity.ExcelTestWrite;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/eduservice")
@CrossOrigin
public class ExcelWriteController {

    @GetMapping("excelWrite")
    public void excelData(){
        String fileName = "D:\\xieru.xlsx";
        EasyExcel.write(fileName, ExcelTestWrite.class).sheet("sheet").doWrite(getExcelTest());
    }

    private static List<ExcelTestWrite> getExcelTest(){
        List<ExcelTestWrite> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelTestWrite excelTest = new ExcelTestWrite();
            excelTest.setName(i+"");
            excelTest.setName2("name2"+i);
            list.add(excelTest);
        }
        return list;
    }

//    @GetMapping("excelRead")
//    public void excelRead(){
//        String fileName = "D:xieru.xlsx";
//        ExcelReader build = EasyExcel.read(fileName)
//                .build();
//        List<ReadSheet> readSheets = build.excelExecutor()
//                .sheetList();
//        ReadSheet data = readSheets.get(0);
//        String sheetName = data.getSheetName();
//        EasyExcel.write(fileName, Excel.class).sheet(sheetName).doWrite();

//    }


    @GetMapping("excelRead")
    public void excelRead(){
        String fileName = "D:\\xieru.xlsx";
        EasyExcel.read(fileName,ExcelTestRead.class,new ExcelReadController()).sheet().doRead();
    }

}

