package com.atmoon.spring;

import com.atmoon.spring.base.beans.Student;
import com.atmoon.spring.base.beans.Teacher;
import com.atmoon.spring.base.customer.dao.CustomerDao;
import com.atmoon.spring.base.customer.model.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseTest {

    @Test
    public void studentTest(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("ApplicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
    @Test
    public void teacherTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("ApplicationContext.xml");
        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        System.out.println(teacher);
    }
    @Test
    public void customerTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("ApplicationContext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDAO");
        Customer customer = new Customer(002,"THJ",21);
        customerDao.insert(customer);

        Customer customer1 = customerDao.findCustomerById(001);
        System.out.println(customer1);
    }

}
