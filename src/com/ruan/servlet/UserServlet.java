package com.ruan.servlet;

import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruan.dao.BaseDao;
import com.ruan.mapper.EmployeeMapper;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn;
    private EmployeeMapper mapper = new EmployeeMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");
        String deptment_id = request.getParameter("deptment_id");

        if (action.equals("login")) {
            // 登录
            if (mapper.isLogin(realname, password)) {
                // 登录成功
                System.out.println("登录成功");
                request.setAttribute("status", "success");
            } else {
                // 登录失败
                System.out.println("登录失败");
                request.setAttribute("status", "fail");
            }
        } else if (action.equals("register")) {
            // 注册
            if (mapper.isRegister(realname, password, deptment_id)) {
                // 注册成功
                System.out.println("注册成功");
                request.setAttribute("status", "success");
            } else {
                // 注册失败
                System.out.println("注册失败");
                request.setAttribute("status", "fail");
            }
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
