package com.chy.controller;

import com.chy.model.hosp.HospitalSet;
import com.chy.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 11213
 */
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "获取所有的医院设置信息")
    @GetMapping("/find")
    public List<HospitalSet> findAllHospitalSet(){
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }

    @DeleteMapping("/remove/{id}")
    public Boolean removeHospitalSet(@PathVariable long id){
        boolean b = hospitalSetService.removeById(id);
        return b;
    }



}
