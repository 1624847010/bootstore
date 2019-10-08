package com.neusoft.bookstore.customer.mapper;

import com.neusoft.bookstore.customer.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CustomerMapper {
    /**
     * 查询用户名是否重复
     * @param customer
     * @return
     */
    int listUserAcctCount(Customer customer);

    int listPhoneAcctCount(Customer customer);

    int saveCustomer(Customer customer);

    Customer loginCustomer(Customer customer);

    void registCustomerpwd(Customer customer);
    //两种都可以
    // int deleteCustomer(@Param("idList") List idList);
    int deleteCustomer(Map<String, Object> map);

    void updateCustomer(Customer customer);

    Customer getCustomerById(Customer customer);

    List<Customer> listCustomerByPage(Customer customer);

    void setCustomerScore(Customer customer);
}
