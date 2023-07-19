package com.ruan.mapper;

import com.ruan.bean.Department;
import com.ruan.dao.BaseDao;
import com.ruan.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
}
