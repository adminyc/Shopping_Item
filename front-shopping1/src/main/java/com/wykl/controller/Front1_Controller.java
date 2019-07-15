package com.wykl.controller;

import com.wykl.pojo.Users;
import com.wykl.service.Front1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RestController
public class Front1_Controller {
    @Autowired
    private Front1Service fs1;
    @RequestMapping("login-wykl")
    public String login_wykl(HttpServletRequest request){
        String mobilephoneno = request.getParameter("mobilephoneno");
        String password = request.getParameter("password");
        Users us = new Users().setMobilephoneno(mobilephoneno).setPassword(password);
        Users users = fs1.wykl_login(us);
        System.out.println("users:"+users);
        return "login";
    }
}
