package com.wykl.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wykl.pojo.Couponpull;
import com.wykl.pojo.Users;
import com.wykl.service.Front1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
//@RestController
public class Front1_Controller {
    @Autowired
    private Front1Service fs1;

    //判断登录
    @RequestMapping("login-wykl")
    public String login_wykl(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mobilephoneno = request.getParameter("mobilephoneno");
        //String password = request.getParameter("password");
        Users us = null;//System.out.println("mobilephoneno:"+mobilephoneno+",password:"+password);
        if (mobilephoneno != null) {
            us = new Users().setMobilephoneno(mobilephoneno);//.setPassword(password);
            System.out.println("user:" + us);
            us = fs1.wykl_login(us);    //判断用户是否存在，拿到完整用户
            //拿到所有用户集合判断此用户是否已经登录在线
            ServletContext application = session.getServletContext();
            List<Users> lists = (List<Users>) application.getAttribute("users");
            for (Users uss : lists) {
                if (uss.getUsername().contains(us.getUsername())) {
                    //model.addAttribute("mess","该用户已在线");
                    System.out.println("该用户已在线");
                    return "wykllogin";
                }
            }
            if (us != null) {
                session.setAttribute("user", us);
                lists.add(us);  //将用户记入已在线用户
                return "wangyikaola";
            } else {
                return "wykllogin";
            }
        } else if (session.getAttribute("user") != null) {
            return "wangyikaola";
        } else {
            return "wangyikaola";
        }
    }

    //退出登录
    @GetMapping("quit-user")
    public String quit_user(HttpSession session,HttpServletRequest request) {
        Users user = (Users) session.getAttribute("user");
        ServletContext application = session.getServletContext();
        List<Users> lists = (List<Users>) application.getAttribute("users");
        for (Users uss : lists) {
            System.out.println("aaa，"+uss.getUsername()+"bbb，"+user.getUsername());
            if (uss.getUsername().contains(user.getUsername())) {
                lists.remove(uss);
                System.out.println("用户已被移除");
                break;
            }
        }
        //session.invalidate();//销毁session
        session.setAttribute("user", null);
        return "redirect:/login-wykl";   //redirect:/  forward:/
    }

    //ajax注册验证用户名是否已经被注册
    @PostMapping("verifyusername")
    public void verify_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("user");
        System.out.println("username:" + username);
        String rs = "";
        int data = fs1.veruname(username);
        if (data == 0) {
            //用户不存在
            rs = "1";
        } else {
            //用户存在
            rs = "0";
        }
        out.print(rs);
        out.flush();
        out.close();
    }
    //ajax判断手机号码是否存在
    @PostMapping("phoneexit")
    public void exitPhone(HttpServletResponse response,HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String mobilephoneno = request.getParameter("phone");
        System.out.println("mobilephoneno:"+mobilephoneno);
        int data = fs1.findByPhone(mobilephoneno);
        System.out.println("查询号码是否存在data:"+data);
        String code = "";
        if(data>0){     //存在该手机号，可以发送验证码ajax
            code= (int)((Math.random()*9+1)*100000)+"";   //六位随机数
            //发送短信验证码
            /*DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI7U05Um6L2czx", "rQUa78stZYtRd2wW52HbQglOJ4hE6K");
            IAcsClient client = new DefaultAcsClient(profile);
            CommonRequest commonRequest = new CommonRequest();
            commonRequest.setMethod(MethodType.POST);
            commonRequest.setDomain("dysmsapi.aliyuncs.com");
            commonRequest.setVersion("2017-05-25");
            commonRequest.setAction("SendSms");
            commonRequest.putQueryParameter("RegionId", "cn-hangzhou");
            commonRequest.putQueryParameter("PhoneNumbers", mobilephoneno);//要发送的手机
            commonRequest.putQueryParameter("SignName", "往忆考拉");
            commonRequest.putQueryParameter("TemplateCode", "SMS_171119074");
            commonRequest.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
            request.setAttribute("code",code);
            try {
                CommonResponse commonResponse = client.getCommonResponse(commonRequest);
                System.out.println(commonResponse.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }else{  //表示该用户尚未注册
            code = "0";
        }
        System.out.println("code:"+code);
        out.print(code);
        out.flush();
        out.close();
    }
    //ajax用户注册
    @PostMapping("registeruser")
    public void register_User(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String uname = request.getParameter("uname");
        System.out.println("uname:" + uname);
        String gender = request.getParameter("gender");
        String idnumber = request.getParameter("idnumber");
        String mobilephoneno = request.getParameter("mobilephoneno");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strbirthday = request.getParameter("birthday");
        //Date birthday = (new SimpleDateFormat("yyyy-MM-dd")).parse(strbirthday);
        Date birthday = sdf.parse(strbirthday);
        System.out.println("strbirthday:" + strbirthday + ",birthday" + birthday);
        String password = request.getParameter("password");
        Users us = new Users().setUsername(username).setUname(uname).setGender(gender).setIdnumber(idnumber).setMobilephoneno(mobilephoneno).setBirthday(birthday).setPassword(password);
        System.out.println("user:" + us);
        //SQL语句
        String rs = "";
        int data = fs1.addUser(us);
        if (data > 0) {
            session.setAttribute("user", us);
            rs = "1";//新增成功
        } else {
            rs = "0";//新增失败
        }
        out.print(rs);
        out.flush();
        out.close();
    }

    //ajax判断用户是否已经有领取的优惠券
    @PostMapping("exitcoupon")
    public void findByPullCoupon(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int cpid = Integer.valueOf(request.getParameter("cpid"));
        Users user = (Users) session.getAttribute("user");
        int uid = user.getUserid();
        System.out.println("uid:" + uid);
        Couponpull cp = new Couponpull().setCpid(cpid).setUid(uid);
        int i = fs1.findByCoupon(cp);
        String rs = "";
        System.out.println("user.getOldandnew():" + user.getOldandnew());
        if (i > 0) {    //表示已经领取过了
            rs = "1";
        } else if (user.getOldandnew() != 0 && cpid <= 4) {  //写死,数据库中的前四条新人专享券
            rs = "2";       //不是新人，不能领取新人券
        } else {           //未领取，也满足新老用户都能领取,去尝试领取
            int data = fs1.couponPulling(cp);
            if (data > 0) {
                System.out.println("领取成功！");
            }
            rs = "0";
        }
        out.print(rs);
        out.flush();
        out.close();
    }

    //测试发送验证码
    @GetMapping("smstest")
    public String testsms() {


        //发送短信验证码
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI7U05Um6L2czx", "rQUa78stZYtRd2wW52HbQglOJ4hE6K");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13142117090");
        request.putQueryParameter("SignName", "往忆考拉");
        request.putQueryParameter("TemplateCode", "SMS_171119074");
        String code= ((Math.random()*9+1)*100000)+"";   //六位随机数
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loca";
    }
}