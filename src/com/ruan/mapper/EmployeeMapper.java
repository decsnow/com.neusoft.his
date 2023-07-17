package com.ruan.mapper;

import com.ruan.bean.Employee;
import com.ruan.bean.dto.EmployeeDto;
import com.ruan.dao.BaseDao;
import com.ruan.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper extends BaseDao {
    private final Connection conn; // 成员变量用于保存数据库连接

    public EmployeeMapper() {
        this.conn = BaseDao.getConnection();
    }

    // 判断是否登录成功
    public EmployeeDto isLogin(String realname, String password) {
        String sql = "SELECT * FROM employee "+
                "left join department d on employee.deptment_id = d.id "+
                "left join regist_level rl on employee.regist_level_id = rl.id"+
                " left join scheduling s on employee.scheduling_id = s.id"+
                " where realname = ? and password = ?";
        List<Object> list = new ArrayList<>();
        list.add(realname);
        list.add(password);
        return (EmployeeDto) CRUDUtil.CRUD(sql, EmployeeDto.class, list, true, false);
    }

    //注册用户
    public boolean isRegister(String realname, String password, Integer deptment_id,Integer regist_level_id, Integer scheduling_id){
        try {
            // 检查用户名是否已存在
            if (isUsernameExists(realname, conn)) {
                System.out.println("用户名已存在");
                return false;
            }

            // 执行插入操作
            String sql = "INSERT INTO employee (realname, password, deptment_id,regist_level_id,scheduling_id )"+" VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, realname);
            stmt.setString(2, password);
            stmt.setInt(3, deptment_id);
            stmt.setInt(4, regist_level_id);
            stmt.setInt(5, scheduling_id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //查询所有用户
    public List<EmployeeDto> listAll(){
            //编写sql语句
            String sql = "SELECT * FROM employee "+
                    "left join department d on employee.deptment_id = d.id "+
                    "left join regist_level rl on employee.regist_level_id = rl.id"+
                    " left join scheduling s on employee.scheduling_id = s.id";
            //System.out.println((List<EmployeeDto>) CRUDUtil.CRUD(sql, EmployeeDto.class, null, true, true));
        //将最终所有的感思信总返回
            return (List<EmployeeDto>) CRUDUtil.CRUD(sql, EmployeeDto.class, null, true, true);
    }
    private boolean isUsernameExists(String realname, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM employee WHERE realname = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, realname);
            rs = stmt.executeQuery();
            return rs.next();
        } finally {
            closeResources(rs, stmt, null);
        }
    }
    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
