package com.mypackage.servlet;

import com.mypackage.pojo.Account;
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

@WebServlet(name = "ListPageServlet",urlPatterns = "/ListPageServlet")
public class ListPageServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    private DeptService deptService=new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Dept> dlist=deptService.queryAllDepts();
        req.setAttribute("dlist",dlist);
        //取当前页
        String currentPage= req.getParameter("currentPage");
        //第一次访问，默认currentPage 访问第一页
        if(currentPage==null) {
            currentPage = "1";
        }
        Integer currentPageNum=Integer.parseInt(currentPage);
        //页面大小暂设置成固定值2

        //分页查询所有
        PageBean<Account> pageBean = accountService.queryAccounttsByPage(currentPageNum,2);
        //servlet重在业务逻辑，取值传值 jsp侧重于页面显示
        req.setAttribute("page",pageBean);
        //请求转发
        req.getRequestDispatcher("listpage.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
