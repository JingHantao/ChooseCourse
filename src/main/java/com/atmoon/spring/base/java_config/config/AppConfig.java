package com.atmoon.spring.base.java_config.config;

import com.atmoon.spring.base.java_config.hello.HelloWorld;
import com.atmoon.spring.base.java_config.impl.HelloWorldImpl;
import com.sun.xml.internal.bind.v2.runtime.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**导入多个配置类
 * @Import({CustomerAConfig.class,CustomerBConfig.class})
 */
@Import({CustomerAConfig.class,CustomerBConfig.class})
@Configuration
public class AppConfig {

    @Bean(name = "helloBean")
    public HelloWorld helloWorld(){
        return new HelloWorldImpl();
    }
}
