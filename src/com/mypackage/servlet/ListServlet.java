package com.mypackage.servlet;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Dept;
import com.mypackage.service.AccountService;
import com.mypackage.service.AccountServiceImpl;
import com.mypackage.service.DeptService;
import com.mypackage.service.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = "/ListServlet")
public class ListServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    private DeptService deptService=new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有学生
        List<Account> list = accountService.queryAllAccounts();
        List<Dept> dlist=deptService.queryAllDepts();

        //吧学生信息放在request对象里面
        req.setAttribute("list",list);
        req.setAttribute("dlist",dlist);
        //请求转发
//        req.getRequestDispatcher("index.jsp").forward(req,resp);
//        resp.sendRedirect("listpage.jsp");
        req.getRequestDispatcher("ListPageServlet").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
