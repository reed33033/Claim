package com.mypackage.servlet;

import com.alibaba.fastjson.JSONObject;
import com.mypackage.pojo.Account;
import com.mypackage.service.AccountService;
import com.mypackage.service.AccountServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mypackage.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "AddServlet",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参数值
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = resp.getWriter();

        String s=req.getParameter("info");
        System.out.println(s);

        //jsion字符串转换为java对象
        Account account = JSONObject.parseObject(s, Account.class);

        System.out.println(account);


//        String name = req.getParameter("name");
//        //将String的年龄转换为int类型
//        String content=req.getParameter("content");
//        String date = req.getParameter("bxdate");
//        //将String日期类型转换为java.util.Date
//        Date bxdate = DateUtil.strToUtilDate(date);
//        Float money = Float.parseFloat(req.getParameter("money"));
//        int dept = Integer.parseInt(req.getParameter("deptname"));
//        Account account=new Account(name,content,bxdate,money,dept);
        //实现修改逻辑
        boolean flag = accountService.addAccount(account);
        if(flag){

            //传入session
//            HttpSession InfoSession=req.getSession();
//            InfoSession.setAttribute("info",account);
//
//            //JSON转文本返回到前端
//            String data=JSON.toJSONString(account);
//            out.write(data);
//            resp.getWriter().print(data);
//
//            out.write("<script>");
//            out.write(" alert('用户名或密码错误！');");
//            out.write("window.location.href='login.html'");
//            out.write("</script>");
//            out.flush();
//            out.close();

//            添加成功
            resp.sendRedirect("ListPageServlet");

        }else{
            System.out.println("add.jsp");
            //添加失败
            resp.sendRedirect("add.jsp");
        }
        String data=JSON.toJSONString(account);
        out.write(data);
        System.out.println(data);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
