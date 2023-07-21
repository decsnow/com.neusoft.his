package com.ruan.bean;

import java.util.Date;

public class Register {
    private int id;
    private String case_number;
    private String real_name;
    private String gender;
    private String card_number;
    private Date birthday;
    private int age;
    private String age_type;
    private String home_address;
    private Date visit_date;
    private String noon;
    private int dept_id;
    private int employee_id;
    private int registLevel_id;
    private int settleCategory_id;
    private String is_book;
    private String regist_method;
    private int visit_state;
    private Float regist_money;


    public Register() {
    }

    public Register(int id, String case_number, String real_name, String gender, String card_number, Date birthday, int age, String age_type, String home_address, Date visit_date, String noon, int dept_id, int employee_id, int registLevel_id, int settleCategory_id, String is_book, String regist_method, int visit_state, Float regist_money) {
        this.id = id;
        this.case_number = case_number;
        this.real_name = real_name;
        this.gender = gender;
        this.card_number = card_number;
        this.birthday = birthday;
        this.age = age;
        this.age_type = age_type;
        this.home_address = home_address;
        this.visit_date = visit_date;
        this.noon = noon;
        this.dept_id = dept_id;
        this.employee_id = employee_id;
        this.registLevel_id = registLevel_id;
        this.settleCategory_id = settleCategory_id;
        this.is_book = is_book;
        this.regist_method = regist_method;
        this.visit_state = visit_state;
        this.regist_money = regist_money;
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
     * @return case_number
     */
    public String getCase_number() {
        return case_number;
    }

    /**
     * 设置
     * @param case_number
     */
    public void setCase_number(String case_number) {
        this.case_number = case_number;
    }

    /**
     * 获取
     * @return real_name
     */
    public String getReal_name() {
        return real_name;
    }

    /**
     * 设置
     * @param real_name
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return card_number
     */
    public String getCard_number() {
        return card_number;
    }

    /**
     * 设置
     * @param card_number
     */
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return age_type
     */
    public String getAge_type() {
        return age_type;
    }

    /**
     * 设置
     * @param age_type
     */
    public void setAge_type(String age_type) {
        this.age_type = age_type;
    }

    /**
     * 获取
     * @return home_address
     */
    public String getHome_address() {
        return home_address;
    }

    /**
     * 设置
     * @param home_address
     */
    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    /**
     * 获取
     * @return visit_date
     */
    public Date getVisit_date() {
        return visit_date;
    }

    /**
     * 设置
     * @param visit_date
     */
    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    /**
     * 获取
     * @return noon
     */
    public String getNoon() {
        return noon;
    }

    /**
     * 设置
     * @param noon
     */
    public void setNoon(String noon) {
        this.noon = noon;
    }

    /**
     * 获取
     * @return dept_id
     */
    public int getDept_id() {
        return dept_id;
    }

    /**
     * 设置
     * @param dept_id
     */
    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    /**
     * 获取
     * @return employee_id
     */
    public int getEmployee_id() {
        return employee_id;
    }

    /**
     * 设置
     * @param employee_id
     */
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    /**
     * 获取
     * @return registLevel_id
     */
    public int getRegistLevel_id() {
        return registLevel_id;
    }

    /**
     * 设置
     * @param registLevel_id
     */
    public void setRegistLevel_id(int registLevel_id) {
        this.registLevel_id = registLevel_id;
    }

    /**
     * 获取
     * @return settleCategory_id
     */
    public int getSettleCategory_id() {
        return settleCategory_id;
    }

    /**
     * 设置
     * @param settleCategory_id
     */
    public void setSettleCategory_id(int settleCategory_id) {
        this.settleCategory_id = settleCategory_id;
    }

    /**
     * 获取
     * @return is_book
     */
    public String getIs_book() {
        return is_book;
    }

    /**
     * 设置
     * @param is_book
     */
    public void setIs_book(String is_book) {
        this.is_book = is_book;
    }

    /**
     * 获取
     * @return regist_method
     */
    public String getRegist_method() {
        return regist_method;
    }

    /**
     * 设置
     * @param regist_method
     */
    public void setRegist_method(String regist_method) {
        this.regist_method = regist_method;
    }

    /**
     * 获取
     * @return visit_state
     */
    public int getVisit_state() {
        return visit_state;
    }

    /**
     * 设置
     * @param visit_state
     */
    public void setVisit_state(int visit_state) {
        this.visit_state = visit_state;
    }

    /**
     * 获取
     * @return regist_money
     */
    public Float getRegist_money() {
        return regist_money;
    }

    /**
     * 设置
     * @param regist_money
     */
    public void setRegist_money(Float regist_money) {
        this.regist_money = regist_money;
    }

    public String toString() {
        return "Register{id = " + id + ", case_number = " + case_number + ", real_name = " + real_name + ", gender = " + gender + ", card_number = " + card_number + ", birthday = " + birthday + ", age = " + age + ", age_type = " + age_type + ", home_address = " + home_address + ", visit_date = " + visit_date + ", noon = " + noon + ", dept_id = " + dept_id + ", employee_id = " + employee_id + ", registLevel_id = " + registLevel_id + ", settleCategory_id = " + settleCategory_id + ", is_book = " + is_book + ", regist_method = " + regist_method + ", visit_state = " + visit_state + ", regist_money = " + regist_money + "}";
    }
}
