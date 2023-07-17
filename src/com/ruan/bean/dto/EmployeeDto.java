package com.ruan.bean.dto;

import com.ruan.bean.Employee;

public class EmployeeDto extends Employee {
    private String dept_name;
    private String regist_level_name;
    private String scheduling_name;


    public EmployeeDto() {
    }

    public EmployeeDto(String dept_name, String regist_level_name, String scheduling_name) {
        this.dept_name = dept_name;
        this.regist_level_name = regist_level_name;
        this.scheduling_name = scheduling_name;
    }

    /**
     * 获取
     * @return dept_name
     */
    public String getDept_name() {
        return dept_name;
    }

    /**
     * 设置
     * @param dept_name
     */
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    /**
     * 获取
     * @return regist_level_name
     */
    public String getRegist_level_name() {
        return regist_level_name;
    }

    /**
     * 设置
     * @param regist_level_name
     */
    public void setRegist_level_name(String regist_level_name) {
        this.regist_level_name = regist_level_name;
    }

    /**
     * 获取
     * @return scheduling_name
     */
    public String getScheduling_name() {
        return scheduling_name;
    }

    /**
     * 设置
     * @param scheduling_name
     */
    public void setScheduling_name(String scheduling_name) {
        this.scheduling_name = scheduling_name;
    }

    public String toString() {
        return "EmployeeDto{dept_name = " + dept_name + ", regist_level_name = " + regist_level_name + ", scheduling_name = " + scheduling_name + "}";
    }
}
