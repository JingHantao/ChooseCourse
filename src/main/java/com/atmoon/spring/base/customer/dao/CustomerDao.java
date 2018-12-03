package com.atmoon.spring.base.customer.dao;

import com.atmoon.spring.base.customer.model.Customer;

import java.util.List;

/**
 * CustomerDao与数据库交互
 */

public interface CustomerDao {

    /**
     * dao层,向数据库customer表中增加一个customer用户;
     * @param customer
     */
    public void insert(Customer customer);

    /**
     * 查找用户
     * @param custId
     */
    public Customer findCustomerById(int custId);

    public List<Customer> findAll();

    public String findCustomerNameById(int custId);

    public int findTotalCustomerNumber();

    public void insertBatch(final List<Customer> customers);
}
