package com.chy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.chy.mapper")
public class HospitalSetConfig {
}
