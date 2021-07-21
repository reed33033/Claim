package com.mypackage.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mypackage.pojo.Account;
import com.mypackage.service.AccountService;
import com.mypackage.service.AccountServiceImpl;
import com.mypackage.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //取参数值
        req.setCharacterEncoding("utf-8");
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        //将String的年龄转换为int类型
//        String content=req.getParameter("content");
//        String date = req.getParameter("bxdate");
//        //将String日期类型转换为java.util.Date
//        Date bxdate = DateUtil.strToUtilDate(date);
//        Float money = Float.parseFloat(req.getParameter("money"));
//        int dept = Integer.parseInt(req.getParameter("deptname"));

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = resp.getWriter();

        String s=req.getParameter("info");
        System.out.println(s);

        //jsion字符串转换为java对象
        Account account = JSONObject.parseObject(s, Account.class);

        System.out.println(account);
        //实现修改逻辑
        boolean flag = accountService.updateAccount(account);
        if(flag){
            //修改成功
            resp.sendRedirect("ListPageServlet");
        }else{
            //修改失败
            resp.sendRedirect("update.jsp");
        }
        String data= JSON.toJSONString(account);
        out.write(data);
        System.out.println(data);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
