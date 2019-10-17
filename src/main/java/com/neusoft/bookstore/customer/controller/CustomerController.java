package com.neusoft.bookstore.customer.controller;

import com.neusoft.bookstore.base.LoginResult;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.base.VerifyCode;
import com.neusoft.bookstore.customer.model.Customer;
import com.neusoft.bookstore.customer.service.CustomerService;
import com.neusoft.bookstore.utils.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Api(description = "用户模块")
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "用户注册")
    @ResponseBody
    @PostMapping("/savaCustomer")
    public Response savaCustomer(@RequestBody Customer customer, HttpServletRequest request){
        HttpSession session = request.getSession();
        VerifyCode verifyCode = (VerifyCode)session.getAttribute(customer.getPhone());
        return customerService.savaCustomer(customer,verifyCode);
    }
    @ApiOperation(value = "验证手机号码")
    @ResponseBody
    @PostMapping("/checkPhone")
    public Response checkPhone(@RequestBody Customer customer){
        return customerService.checkPhone(customer);
    }
    @ApiOperation(value = "验证用户名")
    @ResponseBody
    @PostMapping("/checkAcct")
    public Response checkAcct(@RequestBody Customer customer){
        return customerService.checkAcct(customer);
    }
    @ApiOperation(value = "模拟发送验证码")
    @ResponseBody
    @PostMapping("/sendVerifyCode")
    public VerifyCode sendVerifyCode(String phoneNum, HttpServletRequest request){
        VerifyCode verifyCode=customerService.sendVerifyCode(phoneNum);
        HttpSession session = request.getSession();
        session.setAttribute(verifyCode.getPhoneNum(),verifyCode);
        session.getAttribute(verifyCode.getPhoneNum());
        return verifyCode;
    }
    @ApiOperation(value = "用户登陆")
    @ResponseBody
    @PostMapping("/loginCustomer")
    public Response loginCustomer(HttpServletRequest request,@RequestBody Customer customer){
        Response response = customerService.loginCustomer(customer);
        if (null != response.getData()) {
            LoginResult loginResult = (LoginResult)response.getData();
            SessionUtil.setSession(request,loginResult);
        }
        return response;
    }
    @ApiOperation(value = "重置密码发送验证码")
    @ResponseBody
    @PostMapping("/registSendVerifyCode")
    public Response registSendVerifyCode(String phoneNum, HttpServletRequest request){
        Response ResponseCode=customerService.registSendVerifyCode(phoneNum);
        if (ResponseCode.getCode() == -1) {
            return Response.error("号码未注册");
        }
        VerifyCode verifyCode=(VerifyCode)ResponseCode.getData();
        HttpSession session = request.getSession();
        session.setAttribute(verifyCode.getPhoneNum(),verifyCode);
        return ResponseCode;
    }
    @ApiOperation(value = "修改密码")
    @ResponseBody
    @PostMapping("/registCustomerpwd")
    public Response registCustomerpwd(@RequestBody Customer customer,HttpServletRequest request){
        HttpSession session = request.getSession();
        VerifyCode verifyCode = (VerifyCode)session.getAttribute(customer.getPhone());
        return customerService.registCustomerpwd(customer,verifyCode);
    }
    @ApiOperation(value = "新增用户")
    @ResponseBody
    @PostMapping("/addCustomer")
    public Response addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @ApiOperation(value = "删除用户")
    @ResponseBody
    @PostMapping("/deleteCustomer")
    public Response deleteCustomer(@RequestBody Customer customer){
        List<Long> idList = customer.getIdList();
        return customerService.deleteCustomer(idList);
    }
    @ApiOperation(value = "修改用户")
    @ResponseBody
    @PostMapping("/updateCustomer")
    public Response updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @ApiOperation(value = "根据id查看详情")
    @ResponseBody
    @PostMapping("/getCustomerById")
    public Response getCustomerById(@RequestBody Customer customer){
        return customerService.getCustomerById(customer);
    }
    @ApiOperation(value = "分页查询用户列表")
    @ResponseBody
    @PostMapping("/listCustomerByPage")
    public Response listCustomerByPage(@RequestBody Customer customer){
        return customerService.listCustomerByPage(customer);
    }
    @ApiOperation(value = "设置积分")
    @ResponseBody
    @PostMapping("/setCustomerScore")
    public Response setCustomerScore(@RequestBody Customer customer){
        return customerService.setCustomerScore(customer);
    }
}