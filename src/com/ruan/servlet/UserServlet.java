package com.ruan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruan.bean.Employee;
import com.ruan.bean.dto.EmployeeDto;
import com.ruan.mapper.DepartmentMapper;
import com.ruan.mapper.EmployeeMapper;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeMapper mapper = new EmployeeMapper();
    private DepartmentMapper departmentMapper = new DepartmentMapper();

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
            EmployeeDto employeeSession = mapper.isLogin(realname, encryptedPassword);
            if (employeeSession.getRealname() != null) {
                // 登录成功
                //设置session，保存登录状态，设置session的有效期为30分钟
                request.getSession().setAttribute("employeeSession", employeeSession);
                // 跳转到main.jsp页面
                response.sendRedirect("main.jsp");
            } else {
                // 登录失败
                System.out.println("登录失败");
                request.setAttribute("status", "fail");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            break;
            case "registerEntry":
                request.setAttribute("deptlist", departmentMapper.selectAllDept(null));
                //System.out.println(departmentMapper.selectAllDept());
                request.getRequestDispatcher("signup.jsp").forward(request, response);
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
            queryListMain(request, response);
            break;
            case "listUser":
            String id2 = request.getParameter("id");
            request.setAttribute("user", mapper.listEmployee(id2));
            request.setAttribute("deptlist", departmentMapper.selectAllDept(null));
            request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
            break;
            case "logout":
            request.getSession().removeAttribute("employeeSession");
            response.sendRedirect("index.jsp");
            break;
            case "delUser":
            String id = request.getParameter("id");
            if (mapper.deleteEmployee(id)) {
                System.out.println("删除成功");
                request.setAttribute("userlist", mapper.listAll());
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            } else {
                System.out.println("删除失败");
                request.setAttribute("userlist", mapper.listAll());
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            }
            break;
            case "updateUser":
            String id1 = request.getParameter("id");
            String realname1 = request.getParameter("realname");
            String password1 = request.getParameter("password");
            String deptment_id1 = request.getParameter("deptment_id");
            String regist_level_id1 = request.getParameter("regist_level_id");
            String scheduling_id1 = request.getParameter("scheduling_id");
            System.out.println(id1);
            System.out.println(realname1);
            System.out.println(password1);
            System.out.println(deptment_id1);
            System.out.println(regist_level_id1);
            System.out.println(scheduling_id1);
            Employee updateEmployee= new Employee(Integer.parseInt(id1), realname1, password1, Integer.parseInt(deptment_id1), Integer.parseInt(regist_level_id1), Integer.parseInt(scheduling_id1));
            if (mapper.updateEmployee(updateEmployee)){
                System.out.println("更新成功");
                request.setAttribute("userlist", mapper.listAll());
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            } else {
                System.out.println("更新失败");
                request.setAttribute("userlist", mapper.listAll());
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            }
            break;
            case "conditionQuery":// 条件查询
            String realname2 = request.getParameter("realname");
            String deptment_id2 = request.getParameter("deptment_id");
            request.setAttribute("userlist", mapper.conditionQuery(realname2, deptment_id2));
            request.setAttribute("deptlist", departmentMapper.selectAllDept(null));
            request.getRequestDispatcher("userList.jsp").forward(request, response);
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
            doPost(request,response);
    }

    //拉取所有用户和部门信息
    public void queryListMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userlist", mapper.listAll());
        request.setAttribute("deptlist", departmentMapper.selectAllDept(null));
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }
}
