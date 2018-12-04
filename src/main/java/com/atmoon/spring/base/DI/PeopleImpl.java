package com.atmoon.spring.base.DI;

public class PeopleImpl implements People {
    public PeopleImpl() {
    }

    @Override
    public void say() {
        System.out.println("PeopleImpl:hi!");
    }
}
