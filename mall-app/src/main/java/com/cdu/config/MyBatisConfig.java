package com.cdu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@MapperScan("com.cdu.mapper")
public class MyBatisConfig {

}
