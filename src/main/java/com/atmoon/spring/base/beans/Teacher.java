package com.atmoon.spring.base.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Teacher {

    /**@Autowired 注解自动装配bean(3中方法)
     * 1.@Autowired 字段
     * 2.构造方法中使用@Autowired
     * 3.set方法中使用@Autowired
     */
    /**
     * @Autowired 字段
     */
    @Autowired
    @Qualifier(value = "studentA")
    private Student student;

    //默认构造函数
    public Teacher(){
    }

    /**
     * 构造方法中使用@Autowired
     * @param student
     */
    //@Autowired
    public Teacher(Student student) {
        this.student = student;
    }

    /**
     * set方法中使用@Autowired
     * @param student
     */
   // @Autowired
    //@Qualifier("studentA")
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "student=" + student +
                '}';
    }
}
