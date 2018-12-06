package com.atmoon.spring.base.AOP;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class HelloBeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("HelloBeforeMethod:beforemethod hello!");
    }
}
