package com.ruan.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruan.bean.Register;
import com.ruan.mapper.RegisterMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
private RegisterMapper RegisterMapper = new RegisterMapper();
private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
switch (action){
    case "getRegisterList":
    // 获取挂号列表
        List<Register> registers = null;
        try {
            registers = RegisterMapper.getRegisterList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String json = objectMapper.writeValueAsString(registers);
        response.getWriter().print(json);
        break;
    default:
        throw new IllegalStateException("Unexpected value: " + action);
}
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

}
