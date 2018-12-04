package com.atmoon.spring.base.java_config.impl;

import com.atmoon.spring.base.java_config.hello.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello(String hello) {
        System.out.println("hello!"+hello);
    }
}
