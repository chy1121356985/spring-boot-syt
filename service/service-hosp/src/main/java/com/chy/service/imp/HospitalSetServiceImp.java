package com.chy.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chy.mapper.HospitalSetMapper;
import com.chy.model.hosp.HospitalSet;
import com.chy.service.HospitalSetService;
import org.springframework.stereotype.Service;

/**
 * @author 11213
 * HospitalSetService实现类
 */
@Service
public class HospitalSetServiceImp extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
}
