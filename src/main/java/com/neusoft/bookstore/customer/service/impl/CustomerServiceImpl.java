package com.neusoft.bookstore.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.base.LoginResult;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.base.VerifyCode;
import com.neusoft.bookstore.customer.model.Customer;
import com.neusoft.bookstore.customer.service.CustomerService;
import com.neusoft.bookstore.customer.mapper.CustomerMapper;
import com.neusoft.bookstore.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;


    //注册
    private Response getResponse(Customer customer) {
        if (null == customer.getUserAcct()) {
            return Response.error("用户名不能为空");
        }
        //判断用户名
        int count = customerMapper.listUserAcctCount(customer);
        if (count > 0) {
            return Response.error("用户名已存在");
        }
        //判断手机号
        int countPhone = customerMapper.listPhoneAcctCount(customer);
        if (countPhone > 0) {
            return Response.error("手机已被注册");
        }
        //使用MD5加密密码
        customer.setUserPwd(MD5Util.encryption(customer.getUserPwd()));
        int i = customerMapper.saveCustomer(customer);
        if (i <= 0) {
            return Response.error("注册失败");
        }
        return Response.ok("注册成功");
    }

    /**
     * 注册账号
     * @param customer 用户对象
     * @param verifyCode 验证码
     * @return
     */
    @Override
    public Response savaCustomer(Customer customer,VerifyCode verifyCode) {
        //判断手机号是否为空
        if (null == customer.getPhone() || customer.getPhone().equals("")){
            return Response.error("手机号不能为空");
        }
        //判断密码是否为空
        if (null == customer.getUserPwd() || customer.getUserPwd().equals("")) {
            return Response.error("密码不能为空");
        }
        //获取用户输入的验证码
        Long mycode = customer.getCode();
        //获取发送的验证码
        long getcode = verifyCode.getVerifyCode();
        //获取验证码得创建时间
        Date sendDate = verifyCode.getSendDate();
        //获取当前时间
        Date getdate=new Date();
        //时间差 绝对值
        long inTime=Math.abs(getdate.getTime() - sendDate.getTime());
        //超时时间(毫秒)
        long time=300000;
        //判断验证码是否为空
        if (null == mycode || mycode.equals("")) {
            return Response.error("验证码不能为空");
        }
        //判断验证码是否正确
        if (getcode != mycode) {
            return Response.error("验证码错误");
        }
        //判断超时
        if (inTime>time) {
            return Response.error("验证码已超时");
        }
        //进行注册
        return getResponse(customer);
    }
    /**
     * 验证手机号是否存在
     * @param customer 用户对象
     * @return
     */
    @Override
    public Response checkPhone(Customer customer) {
        int countPhone = customerMapper.listPhoneAcctCount(customer);
        if (countPhone>0) {
            return Response.error("手机已被注册");
        }
        return Response.ok("手机号可用");
    }
    /**
     * 判断用户名是否存在
     * @param customer
     * @return
     */
    @Override
    public Response checkAcct(Customer customer) {
        int count = customerMapper.listUserAcctCount(customer);
        if (count>0) {
            return Response.error("用户名已存在");
        }
        return Response.ok("用户名可用");
    }
    /**
     * 注册账号，模拟发送验证码
     * @param phoneNum 手机号
     * @return
     */
    @Override
    public VerifyCode sendVerifyCode(String phoneNum) {
        return getVerifyCode(phoneNum);
    }

    /**
     * 抽取发送方法
     * @param phoneNum
     * @return
     */
    private VerifyCode getVerifyCode(String phoneNum) {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.setPhoneNum(phoneNum);
        long code =Math.round((Math.random() * 9 +1)*1000);
        verifyCode.setVerifyCode(code);
        verifyCode.setSendDate(new Date());
        System.out.println("验证码是："+code+",有效期五分钟");
        return verifyCode;
    }
    /**
     * 登陆
     * @param customer 用户对象
     * @return
     */
    @Override
    public Response loginCustomer(Customer customer) {
        //账号密码是否为空
        if (null == customer.getUserAcct() || null == customer.getUserPwd()) {
            return Response.error("账号密码为空");
        }
        //判断账号存在
        Customer cs=customerMapper.loginCustomer(customer);
        if (null == cs) {
            return Response.error("账号不存在");
        }
        //如果存在，那么密码是否正确
        String up1 = cs.getUserPwd();
        String up2 =MD5Util.encryption(customer.getUserPwd());
        if (!up1.equals(up2)) {
            return Response.error("密码错误");
        }
        LoginResult loginResult = new LoginResult();
        //用户id
        loginResult.setUserId(cs.getId());
        loginResult.setUserName(cs.getUserName());
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        loginResult.setToken(token);
        return Response.ok(loginResult,"登陆成功");
    }
    /**
     * 找回密码时判断手机号是否已注册
     * @param phoneNum
     * @return
     */
    @Override
    public Response registSendVerifyCode(String phoneNum) {
        Customer customer=new Customer();
        customer.setPhone(phoneNum);
        int count = customerMapper.listPhoneAcctCount(customer);
        if (count == 0) {
            return Response.error("号码未注册");
        }
        VerifyCode verifyCode = getVerifyCode(phoneNum);
        return Response.ok(verifyCode,"发送成功");
    }
    /**
     * 修改密码
     * @param customer
     * @param verifyCode
     * @return
     */
    @Override
    public Response registCustomerpwd(Customer customer, VerifyCode verifyCode) {
        //判断手机号是否为空
        if (null ==customer.getPhone() || customer.getPhone().equals("")) {
            return Response.error("手机号不能为空");
        }
        //判断密码是否为空
        if (null == customer.getUserPwd() || customer.getUserPwd().equals("")) {
            return Response.error("密码不能为空");
        }
        //获取用户输入的验证码
        Long mycode = customer.getCode();
        //获取验证码
        long getcode = verifyCode.getVerifyCode();
        //获取验证码得创建时间
        Date sendDate = verifyCode.getSendDate();
        //获取当前时间
        Date getdate=new Date();
        //时间差 绝对值
        long inTime=Math.abs(getdate.getTime() - sendDate.getTime());
        //超时时间
        long time=300000;
        //判断验证码是否为空
        if (null == mycode || mycode.equals("")) {
            return Response.error("验证码不能为空");
        }
        //判断验证码是否正确
        if (getcode != mycode) {
            return Response.error("验证码错误");
        }
        //判断超时
        if (inTime>time) {
            return Response.error("验证码已超时");
        }

        //使用MD5加密密码
        customer.setUserPwd(MD5Util.encryption(customer.getUserPwd()));
        customerMapper.registCustomerpwd(customer);
        return Response.ok("修改成功");
    }
    /**
     * 新增用户
     * @param customer
     * @return
     */
    @Override
    public Response addCustomer(Customer customer) {
        return getResponse(customer);
    }

    /**
     * 批量删除用户
     * @param idList
     * @return
     */
    @Override
    public Response deleteCustomer(List<Long> idList) {
        Map<String,Object> map=new HashMap<>();
        map.put("idList",idList);
        int i =customerMapper.deleteCustomer(map);
        return Response.ok("成功删除"+i+"条");
    }

    /**
     * 修改用户信息
     * @param customer
     * @return
     */
    @Override
    public Response updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        return Response.ok("修改成功");
    }

    /**
     * 根据id查看用户详情
     * @param customer
     * @return
     */
    @Override
    public Response getCustomerById(Customer customer) {
        if (null == customer.getId()) {
            return Response.error("id不能为空");
        }
        Customer ct=customerMapper.getCustomerById(customer);
        return Response.ok(ct,"查询成功");
    }
    /**
     * 分页查询用户列表
     * @param customer
     * @return
     */
    @Override
    public Response listCustomerByPage(Customer customer) {
        if (null == customer.getPageNum() || null == customer.getPageSize()) {
            return Response.error("参数传递错误");
        }
        PageHelper.startPage(customer.getPageNum(),customer.getPageSize());
        List<Customer> list=customerMapper.listCustomerByPage(customer);
        PageInfo<Customer> customerPageInfo = new PageInfo<>(list);
        return Response.ok(customerPageInfo,"查询成功");
    }

    /**
     * 设置积分
     * @param customer
     * @return
     */
    @Override
    public Response setCustomerScore(Customer customer) {
        if (null == customer.getId() || null == customer.getScore()) {
            return Response.error("参数传递错误");
        }
        customerMapper.setCustomerScore(customer);
        return Response.ok("成功");
    }
}