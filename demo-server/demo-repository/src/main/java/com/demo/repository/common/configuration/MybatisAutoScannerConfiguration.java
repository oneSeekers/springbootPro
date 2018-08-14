package com.demo.repository.common.configuration;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.repository.common.mapper.DemoMapper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;



@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MybatisAutoScannerConfiguration {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setBasePackage("com.demo.repository.mapper");
        mapperScannerConfigurer.setMarkerInterface(DemoMapper.class);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");

        Properties properties = new Properties();
        // 数据库驼峰命名的时候开启，否则关闭
        properties.setProperty("style","normal");

        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
}
