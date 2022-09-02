package com.chy.controller;

import com.chy.common.result.Result;
import com.chy.model.cmn.Dict;
import com.chy.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 11213
 */
@Api(tags = "获取字典数据")
@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @ApiOperation(value = "根据id查询")
    @GetMapping("/findByID/{id}")
    public Result findAByID(@PathVariable Long id){
        List<Dict> dictList = dictService.findByID(id);
        return Result.ok(dictList);
    }

}
