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

    public Employee listEmployee(String id){
        //编写sql语句
        String sql = "SELECT * FROM employee where id = ?";
        try {
            // 获取PreparedStatement对象
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            ResultSet rs = ps.executeQuery();
            // 判断是否有数据
            if (rs.next()) {
                // 获取数据
                String realname = rs.getString("realname");
                String password = rs.getString("password");
                int deptment_id = rs.getInt("deptment_id");
                int regist_level_id = rs.getInt("regist_level_id");
                int scheduling_id = rs.getInt("scheduling_id");
                // 封装成对象
                // 返回对象
                return new Employee(Integer.parseInt(id), realname, password, deptment_id, regist_level_id, scheduling_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public boolean deleteEmployee(String id){
        //默认删除失败
        boolean res = false;
        String sql = "delete from employee where id = "+id;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //若影响行数 > 0 则删除成功
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    //更新用户信息
    public boolean updateEmployee(Employee employee){
        //默认更新失败
        boolean res = false;
        String sql = "update employee set realname = ?,password = ?,deptment_id = ?,regist_level_id = ?,scheduling_id = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,employee.getRealname());
            ps.setString(2,employee.getPassword());
            ps.setInt(3,employee.getDeptmentId());
            ps.setInt(4,employee.getRegistLevelId());
            ps.setInt(5,employee.getSchedulingId());
            ps.setInt(6,employee.getId());
            //若影响行数 > 0 则更新成功
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    //条件查询
    public List<EmployeeDto> conditionQuery(String realname, String deptId){
        String sql = "SELECT e.id, e.realname, e.deptment_id, e.regist_level_id," +
                "e.scheduling_id, d.dept_name, r.regist_name, s.rule_name" +
                " from employee e LEFT JOIN department d on" +
                " e.deptment_id = d.id LEFT JOIN regist_level r on" +
                " e.regist_level_id = r.id LEFT JOIN scheduling s ON" +
                " e.scheduling_id = s.id where 1=1";
        //当账号有信息时才添加查询条件
        if (realname!=null && realname.length()>0){
            sql +=" and e.realname like '%"+realname+"%'";
        }
            if((!"0".equals(deptId)) && deptId!=null && deptId.length()>0){
                sql +=" and e.deptment_id=" + deptId;
            }
            sql += " ORDER BY e.id";
            return (List<EmployeeDto>) CRUDUtil.CRUD(sql, EmployeeDto.class, null, true, true);
    }
    // 判断用户名是否已存在
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
