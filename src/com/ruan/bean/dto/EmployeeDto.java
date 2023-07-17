package com.ruan.bean.dto;

import com.ruan.bean.Employee;

public class EmployeeDto extends Employee {
    private String dept_name;
    private String regist_name;
    private String rule_name;


    public EmployeeDto() {
    }

    public EmployeeDto(String dept_name, String regist_name, String rule_name) {
        this.dept_name = dept_name;
        this.regist_name = regist_name;
        this.rule_name = rule_name;
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
     * @return regist_name
     */
    public String getregist_name() {
        return regist_name;
    }

    /**
     * 设置
     * @param regist_name
     */
    public void setregist_name(String regist_name) {
        this.regist_name = regist_name;
    }

    /**
     * 获取
     * @return rule_name
     */
    public String getrule_name() {
        return rule_name;
    }

    /**
     * 设置
     * @param rule_name
     */
    public void setrule_name(String rule_name) {
        this.rule_name = rule_name;
    }

    public String toString() {
        return "EmployeeDto{dept_name = " + dept_name + ", regist_name = " + regist_name + ", rule_name = " + rule_name + "}";
    }
}
