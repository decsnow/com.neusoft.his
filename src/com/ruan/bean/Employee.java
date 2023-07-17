package com.ruan.bean;

public class Employee {

    private int id;
    private String realname;
    private String password;
    private int deptmentId;
    private int registLevelId;
    private int schedulingId;


    public Employee() {
    }

    public Employee(int id, String realname, String password, int deptmentId, int registLevelId, int schedulingId) {
        this.id = id;
        this.realname = realname;
        this.password = password;
        this.deptmentId = deptmentId;
        this.registLevelId = registLevelId;
        this.schedulingId = schedulingId;
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
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return deptmentId
     */
    public int getDeptmentId() {
        return deptmentId;
    }

    /**
     * 设置
     * @param deptmentId
     */
    public void setDeptmentId(int deptmentId) {
        this.deptmentId = deptmentId;
    }

    /**
     * 获取
     * @return registLevelId
     */
    public int getRegistLevelId() {
        return registLevelId;
    }

    /**
     * 设置
     * @param registLevelId
     */
    public void setRegistLevelId(int registLevelId) {
        this.registLevelId = registLevelId;
    }

    /**
     * 获取
     * @return schedulingId
     */
    public int getSchedulingId() {
        return schedulingId;
    }

    /**
     * 设置
     * @param schedulingId
     */
    public void setSchedulingId(int schedulingId) {
        this.schedulingId = schedulingId;
    }

    public String toString() {
        return "Employee{id = " + id + ", realname = " + realname + ", password = " + password + ", deptmentId = " + deptmentId + ", registLevelId = " + registLevelId + ", schedulingId = " + schedulingId + "}";
    }
}
