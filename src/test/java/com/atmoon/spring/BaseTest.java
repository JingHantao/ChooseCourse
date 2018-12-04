package com.atmoon.spring;

import com.atmoon.spring.base.beans.Student;
import com.atmoon.spring.base.beans.Teacher;
import com.atmoon.spring.base.customer.dao.CustomerDao;
import com.atmoon.spring.base.customer.model.Customer;
import com.atmoon.spring.base.java_config.config.AppConfig;
import com.atmoon.spring.base.java_config.core.CustomerA;
import com.atmoon.spring.base.java_config.core.CustomerB;
import com.atmoon.spring.base.java_config.hello.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void customerJdbcTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("Applicationcontext.xml");
        Customer customer = new Customer(10004,"Spring",18);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.insert(customer);
        Customer customer1 = customerDao.findCustomerById(customer.getCustId());
        System.out.println(customer1);
    }
    @Test
    public void customersJdbcTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("Applicationcontext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        List<Customer> customers = customerDao.findAll();
        for (Customer customer:customers
             ) {
            System.out.println(customer);
        }
    }
    @Test
    public void findCustomerNameByIdTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("Applicationcontext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        String name = customerDao.findCustomerNameById(10003);
        System.out.println(name);
    }
    @Test
    public void findTotalCustomerNumberTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("Applicationcontext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        int total = customerDao.findTotalCustomerNumber();
        System.out.println(total);
    }
    @Test
    public void insertBatchTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("Applicationcontext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer(10005,"SpringBoot",10);
        Customer customer2 = new Customer(10006,"SpringBoot",10);
        Customer customer3 = new Customer(10007,"SpringBoot",10);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customerDao.insertBatch(customers);
    }

    @Test
    public void appConfigTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");
        helloWorld.sayHello("Spring Java Config");
    }
    @Test
    public void appConfigsTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerA customerA = (CustomerA) applicationContext.getBean("customerABean");
        CustomerB customerB = (CustomerB) applicationContext.getBean("customerBBean");
        customerA.print("i am customerA.");
        customerB.print("i am customerB.");
    }

}
