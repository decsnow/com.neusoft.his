package com.ruan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruan.bean.Employee;
import com.ruan.mapper.EmployeeMapper;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeMapper mapper = new EmployeeMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String realname = request.getParameter("realname");
        //String password = request.getParameter("password");
        String encryptedPassword = request.getParameter("encryptedPassword");
        String deptment_id = request.getParameter("deptment_id");
        String regist_level_id = request.getParameter("regist_level_id");
        String scheduling_id = request.getParameter("scheduling_id");

        switch (action) {
            case "login":
            // 登录
            Employee employeeSession = mapper.isLogin(realname, encryptedPassword);
            if (employeeSession != null) {
                // 登录成功
                //设置session，保存登录状态，设置session的有效期为30分钟
                request.getSession().setAttribute("employee", employeeSession);
                // 跳转到main.jsp页面
                response.sendRedirect("main.jsp");
            } else {
                // 登录失败
                System.out.println("登录失败");
                request.setAttribute("status", "fail");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            break;
            case "register":
            // 注册
            if (mapper.isRegister(realname, encryptedPassword, Integer.parseInt(deptment_id), Integer.parseInt(regist_level_id), Integer.parseInt(scheduling_id))) {
                // 注册成功
                System.out.println("注册成功");
                request.setAttribute("status", "success");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                // 注册失败
                System.out.println("注册失败");
                request.setAttribute("status", "fail");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            break;
            case "listAll":
                System.out.println(mapper.listAll());
            request.setAttribute("userlist", mapper.listAll());
            request.getRequestDispatcher("userList.jsp").forward(request, response);
            break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
            doPost(request,response);
    }
}
