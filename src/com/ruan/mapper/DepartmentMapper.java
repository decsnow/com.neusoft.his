package com.ruan.mapper;

public class DepartmentMapper {
    public static String getDepartmentById = "select * from department where id = ?";
    public static String getDepartmentByCode = "select * from department where dept_code = ?";
    public static String getDepartmentByName = "select * from department where dept_name = ?";
    public static String getDepartmentByType = "select * from department where dept_type = ?";
    public static String getDepartmentByCodeAndName = "select * from department where dept_code = ? and dept_name = ?";
    public static String getDepartmentByCodeAndType = "select * from department where dept_code = ? and dept_type = ?";
    public static String getDepartmentByNameAndType = "select * from department where dept_name = ? and dept_type = ?";
    public static String getDepartmentByCodeAndNameAndType = "select * from department where dept_code = ? and dept_name = ? and dept_type = ?";
    public static String getAllDepartments = "select * from department";
    public static String insertDepartment = "insert into department(dept_code, dept_name, dept_type) values(?, ?, ?)";
    public static String updateDepartment = "update department set dept_code = ?, dept_name = ?, dept_type = ? where id = ?";
    public static String deleteDepartmentById = "delete from department where id = ?";
    public static String deleteDepartmentByCode = "delete from department where dept_code = ?";
    public static String deleteDepartmentByName = "delete from department where dept_name = ?";
    public static String deleteDepartmentByType = "delete from department where dept_type = ?";
    public static String deleteDepartmentByCodeAndName = "delete from department where dept_code = ? and dept_name = ?";
    public static String deleteDepartmentByCodeAndType = "delete from department where dept_code = ? and dept_type = ?";
    public static String deleteDepartmentByNameAndType = "delete from department where dept_name = ? and dept_type = ?";
    public static String deleteDepartmentByCodeAndNameAndType = "delete from department where dept_code = ? and dept_name = ? and dept_type = ?";

    
}
