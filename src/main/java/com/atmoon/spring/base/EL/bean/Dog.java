package com.atmoon.spring.base.EL.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "dogBean")
public class Dog {
    @Value(value = "#{itemBean}")
    private Item item;

    @Value(value = "#{itemBean.name}")
    private String itemName;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
