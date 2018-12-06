package com.atmoon.spring.base.EL.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "dogBean")
public class Dog {
    @Value("#{itemBean}")
    private Item item;

    @Value("#{itemBean.name}")
    private String itemName;



}
