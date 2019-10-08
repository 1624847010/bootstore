package com.neusoft.bookstore.customer;

import com.neusoft.bookstore.BookStoreApplicationTests;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.base.VerifyCode;
import com.neusoft.bookstore.customer.model.Customer;
import com.neusoft.bookstore.customer.service.CustomerService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerTest extends BookStoreApplicationTests {
    @Autowired
    private CustomerService customerService;

    @Test
    public void saveCustomerTest(){
        Customer customer=new Customer();
        customer.setUserName("王五");
        customer.setUserAcct("wangwu");
        customer.setPhone("13469129812");
        customer.setUserPwd("abc123");
        customer.setEmail("wangwu@qq.com");
        customer.setIdCard("1351616546465468");
        customer.setRemark("第二次注册");
        customer.setClientId(1235);
        customer.setCreateBy("王五");
        customer.setLastModifiedBy("王五");
        customer.setSex(1);
        VerifyCode verifyCode=new VerifyCode();
        Response response=customerService.savaCustomer(customer, verifyCode);
        System.out.println("code:"+response.getCode()+",msg:"+response.getMsg());
    }
//    @Test
//    public void loginCustomerTest(){
//        Customer customer=new Customer();
//        customer.setUserAcct("wangwu");
//        customer.setUserPwd("abc123");
//        Response response=customerService.loginCustomer(customer);
//        System.out.println(response.getMsg());
//    }
}
