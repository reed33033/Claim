package com.mypackage.servlet;

import com.mypackage.pojo.User;
import com.mypackage.service.UserService;
import com.mypackage.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Part part= req.getPart("headShot");
        // 上传文件名head1.jpg
        String fileName = part.getSubmittedFileName();

        //创建保存文件目录
        //D:\apache-tomcat-8.5.57\webapps\offers
        String dir = this.getServletContext().getRealPath("/applicant/images");
        //判断 目录是否存在
        File imgDir = new File(dir);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
        //上传到服务器文件路径  imgDir+'/'+fileName
        part.write(dir + "/" +fileName);

        User qtUser=new User(username,password,fileName);

        //链接数据库添加
        boolean flag = userService.register(qtUser);


        /*resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //响应
        if(flag){
            out.println("<h1>注册成功<h1>");
        }else {
            out.println("<h1>注册失败<h1>");
        }
        out.flush();
        out.close();*/

        //注册成功 需要跳转到登录页面，注册失败 需要 回到注册页面，继续注册
        if(flag){
            //重定向 就表示重新定位到一个地址
            resp.sendRedirect("index.html");
        }else{
            resp.sendRedirect("index.html");
        }


    }
}
