package com.mypackage.servlet;

import com.mypackage.pojo.Account;
import com.mypackage.pojo.Condition;
import com.mypackage.pojo.Dept;
import com.mypackage.pojo.PageBean;
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

@WebServlet(name = "ConditionServlet",urlPatterns = "/ConditionServlet")
public class ConditionServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    private DeptService deptService=new DeptServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求和响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name=null;
        name=req.getParameter("name");
        int deptId=Integer.parseInt(req.getParameter("dept"));
        Condition condition=new Condition(name,deptId);
        System.out.println(condition);

        List<Account> accounts=accountService.queryAccountsByCondition(condition);
        req.setAttribute("list",accounts);
        System.out.println(accounts);
        List<Dept> dlist=deptService.queryAllDepts();
        req.setAttribute("dlist",dlist);

        PageBean<Account> pageBean = new PageBean<>();
        pageBean.setList(accounts);
        //servlet重在业务逻辑，取值传值 jsp侧重于页面显示
        req.setAttribute("page",pageBean);
        req.getRequestDispatcher("listpage.jsp").forward(req,resp);



    }

}
