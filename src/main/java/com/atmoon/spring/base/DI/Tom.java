package com.atmoon.spring.base.DI;

public class Tom {
    private PeopleImpl people;

    public void peopleSay(){
        people.say();
    }

    /**
     * 通过setter实现DI(依赖注入)
     * @param people
     */
    public void setPeople(PeopleImpl people) {
        this.people = people;
    }

    /**
     * 通过constructor实现DI(依赖注入)
     * @param people
     */
    public Tom(PeopleImpl people) {
        this.people = people;
    }
}
