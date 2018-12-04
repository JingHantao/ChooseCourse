package com.atmoon.spring.base.java_config.config;

import com.atmoon.spring.base.java_config.core.CustomerB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBConfig {
    @Bean(name = "customerBBean")
    public CustomerB customerB(){
        return new CustomerB();
    }
}
