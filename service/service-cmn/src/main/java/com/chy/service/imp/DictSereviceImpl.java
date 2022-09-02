package com.chy.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chy.mapper.DictMapper;
import com.chy.model.cmn.Dict;
import com.chy.service.DictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11213
 * DictSerevice实现类
 */
@Service
public class DictSereviceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Override
    public List<Dict> findByID(Long id) {
        QueryWrapper<Dict> query = new QueryWrapper<>();
        query.eq("parent_id", id);
        List<Dict> dicts = baseMapper.selectList(query);
        for (Dict dict : dicts) {
            Long parent_id = dict.getId();
            boolean hasChildren = this.isHasChildren(parent_id);
            dict.setHasChildren(hasChildren);
        }
        return dicts;
    }

    /**
     * @param parent_id
     * @return 判断 当前id是否有子数据
     * true:有   false:无
     */
    private boolean isHasChildren(Long parent_id) {
        QueryWrapper<Dict> query = new QueryWrapper<>();
        query.eq("parent_id", parent_id);
        Integer count = baseMapper.selectCount(query);
        return count > 0;
    }

}
