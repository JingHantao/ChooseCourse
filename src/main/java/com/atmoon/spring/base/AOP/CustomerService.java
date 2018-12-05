package com.atmoon.spring.base.AOP;

import java.nio.channels.IllegalChannelGroupException;

public class CustomerService {
    private String name;

    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printName(){
        System.out.println("CustomerService name:"+this.name);
    }

    public void printUrl(){
        System.out.println("CustomerService url:"+this.url);
    }

    public void printThrowException(){
        throw new IllegalArgumentException();
    }
}
