package com.ruan.bean;

public class Department {


    private int id;
    private String dept_code;
    private String dept_name;
    private String dept_type;


    public Department() {
    }

    public Department(int id, String dept_code, String dept_name, String dept_type) {
        this.id = id;
        this.dept_code = dept_code;
        this.dept_name = dept_name;
        this.dept_type = dept_type;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return dept_code
     */
    public String getDept_code() {
        return dept_code;
    }

    /**
     * 设置
     * @param dept_code
     */
    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
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
     * @return dept_type
     */
    public String getDept_type() {
        return dept_type;
    }

    /**
     * 设置
     * @param dept_type
     */
    public void setDept_type(String dept_type) {
        this.dept_type = dept_type;
    }

    public String toString() {
        return "Department{id = " + id + ", dept_code = " + dept_code + ", dept_name = " + dept_name + ", dept_type = " + dept_type + "}";
    }
}
