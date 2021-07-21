package com.mypackage.servlet;

import com.mypackage.service.AccountService;
import com.mypackage.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns ="/delete" )
public class DeleteServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参
        String ids = req.getParameter("id");
        //类型转换
        Integer id=Integer.parseInt(ids);

        boolean flag = accountService.deleteAccountById(id);

        if(flag){
            resp.sendRedirect("ListPageServlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
