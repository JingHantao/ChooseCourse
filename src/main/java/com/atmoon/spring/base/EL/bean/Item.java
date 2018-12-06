package com.atmoon.spring.base.EL.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "itemBean")
public class Item {
    @Value(value = "itemA")
    private String name;

    @Value(value = "10")
    private int number;

    public String getName() {
        return name;
    }
}
