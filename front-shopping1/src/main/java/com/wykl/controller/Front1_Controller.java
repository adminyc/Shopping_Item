package com.wykl.controller;

import com.wykl.pojo.Users;
import com.wykl.service.Front1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
//@RestController
public class Front1_Controller {
    @Autowired
    private Front1Service fs1;

    @RequestMapping("login-wykl")
    public String login_wykl(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String mobilephoneno = request.getParameter("mobilephoneno");
        String password = request.getParameter("password");
        Users us = new Users().setMobilephoneno(mobilephoneno).setPassword(password);
        Users user = fs1.wykl_login(us);
        System.out.println("users:"+user);
        session.setAttribute("user",user);
        if(user!=null){
            System.out.println("进了？？");
            return "wangyikaola";
        }else{
            return "wykllogin";
        }
        /*String ck = "";
        if(users!=null){
            ck = "true";
        }else{
            ck = "false";
        }
        writer.write(ck);
        writer.flush();
        writer.close();*/
    }
}
