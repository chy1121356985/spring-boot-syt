package com.chy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.common.result.Result;
import com.chy.model.hosp.HospitalSet;
import com.chy.service.HospitalSetService;
import com.chy.service.utils.MD5;
import com.chy.util.StringUtils;
import com.chy.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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
    public Result findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }


    @ApiOperation(value = "根据ID删除医院信息")
    @DeleteMapping("/remove/{id}")
    public Result removeHospitalSet(@PathVariable long id) {
        boolean b = hospitalSetService.removeById(id);
        if (b) {
            return Result.ok("删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }


    @ApiOperation(value = "分页查询医院信息")
    @PostMapping("/page/{current}/{limit}")
    public Result pageHospitalSet(@PathVariable Integer current,
                                  @PathVariable Integer limit,
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
        //@RequestBody(required = false) false时json数据可以为null
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        Page<HospitalSet> page = new Page<>(current, limit);
        QueryWrapper<HospitalSet> Query = new QueryWrapper<>();

        //判断查询条件是否为null
        if (StringUtils.isNotEmpty(hosname)) {
            Query.like("hosname", hospitalSetQueryVo.getHosname());
        }
        if (StringUtils.isNotEmpty(hoscode)) {
            Query.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }
        //查询
        Page<HospitalSet> hospitalSets = hospitalSetService.page(page, Query);
        return Result.ok(hospitalSets);
    }


    @ApiOperation(value = "添加医院信息")
    @PostMapping("/save")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet) {

        //Status  1:使用 0:不可用
        hospitalSet.setStatus(1);
        //签字秘钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000)));

        boolean save = hospitalSetService.save(hospitalSet);
        if (save) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


    @ApiOperation(value = "根据ID获取医院信息")
    @GetMapping("/findID/{id}")
    public Result findByIdHospitalSet(@PathVariable String id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        if (StringUtils.isNotNull(hospitalSet)) {
            return Result.ok(hospitalSet);
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据ID修改医院信息")
    @PostMapping("/updateID")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean update = hospitalSetService.updateById(hospitalSet);
        if (update) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据id批量删除医院信息")
    @DeleteMapping("removeHospitalSets")
    public Result removeHospitalSets(@RequestBody List<Long> idsList) {
        boolean remove = hospitalSetService.removeByIds(idsList);
        if (remove) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


    @ApiOperation(value = "修改医院状态")
    @GetMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        HospitalSet hospitalSet = new HospitalSet();
        hospitalSet.setId(id);
        hospitalSet.setStatus(status);
        boolean update = hospitalSetService.updateById(hospitalSet);
        if (update) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


    @ApiOperation(value = "获取医院秘钥")
    @GetMapping("/getSignKey/{id}")
    public Result getSignKey(@PathVariable Long id){
        int a=1/0;
        HospitalSet HospitalSet = hospitalSetService.getById(id);
        String signKey = HospitalSet.getSignKey();
        String hoscode = HospitalSet.getHoscode();
        String hosname = HospitalSet.getHosname();

        return  Result.ok();

        //
    }


}
