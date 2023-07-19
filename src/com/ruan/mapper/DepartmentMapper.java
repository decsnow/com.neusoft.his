package com.ruan.mapper;

import com.ruan.bean.Department;
import com.ruan.dao.BaseDao;
import com.ruan.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.ruan.util.PinyinHelperUtil.convertStringToUpperCase;

/**
 * 操作科室方法类
 */
public class DepartmentMapper {
    private final Connection conn; // 成员变量用于保存数据库连接

    public DepartmentMapper() {
        this.conn = BaseDao.getConnection();
    }
public List<Department> selectAllDept(String deptName){
   //编写sql语句
    String sql = "select * from department where 1=1";
    if (deptName!=null&&!deptName.equals("")){
        sql+=" and dept_name like '%"+deptName+"%'";
    }
    //调用CRUDUtil工具类的CRUD方法
    return (List<Department>) CRUDUtil.CRUD(sql,Department.class,null,false,true);
}
    public boolean delDept(String id){
        //默认删除失败
        boolean res = false;
        String sql = "delete from department where id = "+id;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //若影响行数 > 0 则删除成功
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public boolean addDept(String deptName,String deptType){
        //默认添加失败
        boolean res = false;
        String sql = "insert into department (dept_code,dept_name, dept_type) " + "values(?,?,?)";
        try {
            if (isDeptExists(deptName, conn)) {
                //System.out.println("科室已存在");
                return false;
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,convertStringToUpperCase(deptName));
            ps.setString(2,deptName);
            ps.setString(3,deptType);
            //若影响行数 > 0 则添加成功
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    private boolean isDeptExists(String deptName, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM department WHERE dept_name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, deptName);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
