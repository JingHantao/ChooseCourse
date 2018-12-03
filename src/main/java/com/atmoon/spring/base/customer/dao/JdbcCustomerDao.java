package com.atmoon.spring.base.customer.dao;

import com.atmoon.spring.base.customer.RowMapper.CustomerRowMapper;
import com.atmoon.spring.base.customer.model.Customer;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcCustomerDao extends JdbcDaoSupport implements CustomerDao {

    @Override
    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[] { customer.getCustId(),
                customer.getName(),customer.getAge()
        });
    }

    /**
     * 使用RowMapper查找单条数据
     * @param custId
     * @return
     */

    @Override
    public Customer findCustomerById(int custId) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        Customer customer = (Customer)getJdbcTemplate().queryForObject(
                sql, new Object[] { custId }, new CustomerRowMapper());
        return customer;
    }
    /*@Override
    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers = new ArrayList<Customer>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setCustId(((Number) (row.get("CUST_ID"))).intValue());
            customer.setName((String)row.get("NAME"));
            customer.setAge(((Number) (row.get("AGE"))).intValue());
            customers.add(customer);
        }
        return customers;
    }*/

    /**
     * 使用BeanPropertyRowMapper
     * @return
     */
    @Override
    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers  = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Customer.class));
        return customers;
    }

    @Override
    public String findCustomerNameById(int custId) {
        String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";
        String name = (String)getJdbcTemplate().queryForObject(sql,new Object[]{custId},String.class);
        return name;
    }

    @Override
    public int findTotalCustomerNumber() {
        //spring 3.2.2之后，jdbctemplate中的queryForInt已经被取消了,全部使用queryForObject.
        String sql = "SELECT COUNT(*) FROM CUSTOMER";
        int total = getJdbcTemplate().queryForObject(sql,new Object[]{},Integer.class);
        return total;
    }

    @Override
    public void insertBatch(List<Customer> customers) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Customer customer = customers.get(i);
                ps.setLong(1, customer.getCustId());
                ps.setString(2, customer.getName());
                ps.setInt(3, customer.getAge() );
            }
            @Override
            public int getBatchSize() {
                return customers.size();
            }
        });
    }
}
