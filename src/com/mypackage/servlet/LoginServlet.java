package com.mypackage.servlet;

import com.mypackage.pojo.User;
import com.mypackage.service.UserService;
import com.mypackage.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取前台提交的账户和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User qtUser=new User(username,password);

        System.out.println(qtUser);

        //连数据库查询
        User htUser=userService.login(qtUser);
        //响应
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //判断是否登录成功
        if(htUser!=null){
            //将登录用户对象保存到session
//            request.getSession().setAttribute("SESSION_APPLICANT",htUser);
            request.getSession().setAttribute("user", htUser);
//            out.println("<h1>登录成功</h1>");
//            response.sendRedirect("/Claim/index.jsp");
            request.getRequestDispatcher("ListServlet").forward(request,response);
        }else{
//            out.println("<h1>登录失败</h1>");
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write(" alert('用户名或密码错误！');");
            writer.write("window.location.href='index.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }
//        out.flush();
//        out.close();
    }
}
