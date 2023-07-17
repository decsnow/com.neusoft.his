package com.ruan.bean;

public class Employee {

    private int id;
    private String realname;
    private String password;
    private int deptmentId;
    private int registLevelId;
    private int schedulingId;

    public Employee(int id, String realname, String password, int deptmentId, int registLevelId, int schedulingId) {
this.id = id;
this.realname = realname;
this.password = password;
this.deptmentId = deptmentId;
this.registLevelId = registLevelId;
this.schedulingId = schedulingId;
    }

    public int getId() {
        return id;
    }

    public String getRealname() {
        return realname;
    }

    public String getPassword() {
        return password;
    }

    public int getDeptmentId() {
        return deptmentId;
    }

    public int getRegistLevelId() {
        return registLevelId;
    }

    public int getSchedulingId() {
        return schedulingId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeptmentId(Integer deptmentId) {
        this.deptmentId = deptmentId;
    }

    public void setRegistLevelId(Integer registLevelId) {
        this.registLevelId = registLevelId;
    }

    public void setSchedulingId(Integer schedulingId) {
        this.schedulingId = schedulingId;
    }




}
