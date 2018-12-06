package com.atmoon.spring.base.AOP;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class HelloAfterMethod implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("HelloAfterMethod:aftermethod hello!");
    }
}
