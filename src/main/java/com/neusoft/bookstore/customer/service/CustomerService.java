package com.neusoft.bookstore.customer.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.base.VerifyCode;
import com.neusoft.bookstore.customer.model.Customer;

import java.util.List;

public interface CustomerService {
     //注册
     Response savaCustomer(Customer customer,VerifyCode verifyCode);
     //验证手机
     Response checkPhone(Customer customer);
     //验证账号
     Response checkAcct(Customer customer);
     //发送验证码
     VerifyCode sendVerifyCode(String phoneNum);
     //登陆
     Response loginCustomer(Customer customer);
     //重置密码发送验证码
     Response registSendVerifyCode(String phoneNum);
     //修改密码
     Response registCustomerpwd(Customer customer, VerifyCode verifyCode);
     //新增用户
     Response addCustomer(Customer customer);
     //批量删除用户
     Response deleteCustomer(List<Long> idList);
     //修改用户信息
     Response updateCustomer(Customer customer);
     //根据id查看用户详情
     Response getCustomerById(Customer customer);
     //分页查询用户列表
     Response listCustomerByPage(Customer customer);
     //积分
     Response setCustomerScore(Customer customer);
}
