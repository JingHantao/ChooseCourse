package com.atmoon.spring.base.java_config.config;

import com.atmoon.spring.base.java_config.core.CustomerA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerAConfig {

    @Bean(name = "customerABean")
    public CustomerA customerA(){
        return new CustomerA();
    }
}
