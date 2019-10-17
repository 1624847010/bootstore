package com.neusoft.bookstore.utils;

import com.neusoft.bookstore.base.LoginResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    /**
     * 设置Session
     * @param request
     * @param loginResult
     */
    public static void setSession(HttpServletRequest request,LoginResult loginResult){
        HttpSession session = request.getSession();
        session.setAttribute(loginResult.getToken(),loginResult);
    }

    /**
     * 获取Session
     * @param request
     * @param token
     * @return
     */
    public static LoginResult getSession(HttpServletRequest request,String token){
        HttpSession session = request.getSession();
        LoginResult loginResult = (LoginResult)session.getAttribute(token);
        return loginResult;
    }
}
