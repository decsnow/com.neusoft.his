package com.ruan.mapper;

import com.ruan.bean.Department;
import com.ruan.util.CRUDUtil;

import java.util.List;

/**
 * 操作科室方法类
 */
public class DepartmentMapper {
public List<Department> selectAllDept(String deptName){
   //编写sql语句
    String sql = "select * from department where 1=1";
    if (deptName!=null&&!deptName.equals("")){
        sql+=" and dept_name like '%"+deptName+"%'";
    }
    //调用CRUDUtil工具类的CRUD方法
    return (List<Department>) CRUDUtil.CRUD(sql,Department.class,null,false,true);
}
}
