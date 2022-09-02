package com.chy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chy.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11213
 * DictService接口
 */
public interface DictService extends IService<Dict> {

     List<Dict> findByID(Long id);


}
