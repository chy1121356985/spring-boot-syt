package com.chy.common.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 11213
 * 乐观锁插件
 */
@Configuration
@MapperScan("com.chy.mapper")
public class MpConfig {


    /**
     * @author 11213
     * 乐观锁插件
     */
    @Bean
    public OptimisticLockerInterceptor
    optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     *
     * @author 11213
     * 分页查询插件
     */

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
