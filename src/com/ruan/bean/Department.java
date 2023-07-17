package com.ruan.bean;

public class Department {


    private int id;
    private String dept_code;
    private String dept_name;
    private String dept_type;

    public Department(int id, String dept_code, String dept_name, String dept_type) {
        this.id = id;
        this.dept_code = dept_code;
        this.dept_name = dept_name;
        this.dept_type = dept_type;
    }

    public int getId() {
        return id;
    }

    public String getDept_code() {
        return dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public String getDept_type() {
        return dept_type;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void setDept_type(String dept_type) {
        this.dept_type = dept_type;
    }

}
