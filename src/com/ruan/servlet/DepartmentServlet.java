package com.ruan.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruan.bean.Department;
import com.ruan.mapper.DepartmentMapper;
import com.ruan.mapper.EmployeeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {
    private DepartmentMapper mapper = new DepartmentMapper();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action){
        case "listDept":
            String deptName = req.getParameter("deptName");
        // 查询所有科室,json格式返回
            List<Department> list = mapper.selectAllDept(deptName);
            //将科室集合数据转换成json字符串格式
            String json = objectMapper.writeValueAsString(list);
            //符json数据返回
            resp.getWriter().print(json);
        break;
        case "delDept":
            // 删除科室
            String deptId = req.getParameter("deptId");
            boolean res = mapper.delDept(deptId);
            String json1=objectMapper.writeValueAsString(res);
            resp.getWriter().print(json1);
            break;
        case "addDept":
            // 添加科室
            String deptName1 = req.getParameter("deptName");
            String deptType = req.getParameter("deptType");
            boolean res1 = mapper.addDept(deptName1,deptType);
            String json2=objectMapper.writeValueAsString(res1);
            resp.getWriter().print(json2);
            break;
        case "updateDept":
            // 修改科室
            String deptId1 = req.getParameter("deptId");
            String deptName2 = req.getParameter("deptName");
            String deptType1 = req.getParameter("deptType");
            boolean res2 = mapper.updateDept(deptId1,deptName2,deptType1);
            String json3=objectMapper.writeValueAsString(res2);
            resp.getWriter().print(json3);
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
