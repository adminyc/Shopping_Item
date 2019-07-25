package com.wykl.listener;

import com.wykl.pojo.Users;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class MyListener implements ServletContextListener,HttpSessionListener {
    //application只有一个
    private ServletContext application;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application初始化");
        application=sce.getServletContext();
        application.setAttribute("users",new ArrayList<Users>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(2*60);
        System.out.println("创建sessionid:"+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        System.out.println("销毁sessionid:"+session.getId());
        //销毁
        Users user=(Users) session.getAttribute("user");
        List<Users> list=(List<Users>) application.getAttribute("users");
        for (Users u :list){
            if(u.getUsername().contains(user.getUsername())){
                System.out.println("u.getUserName()；"+u.getUsername()+"\tuser.getUserName():"+user.getUsername());
                list.remove(user.getUsername());
                break;
            }
        }
    }
}
