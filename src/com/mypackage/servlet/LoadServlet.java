package com.mypackage.servlet;

import com.mypackage.pojo.Account;
import com.mypackage.service.AccountService;
import com.mypackage.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoadServlet",urlPatterns ="/load" )
public class LoadServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        //根据id查询单个
        Account account=accountService.queryOneAccountById(id);
        req.setAttribute("a",account);
        System.out.println(id+" "+account);
        //请求转发
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
