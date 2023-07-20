package com.ruan.bean;

import java.util.Date;

public class Register {
    private int id;
    private String caseNumber;
    private String realName;
    private String Gender;
    private String cardNumber;
    private Date birthday;
    private int age;
    private String ageType;
    private String homeAddress;
    private Date visitDate;
    private String noon;
    private int deptId;
    private int employeeId;
    private int registLevelId;
    private int settleCategoryId;
    private String isBook;
    private String registMethod;
    private int visitState;
    private Float registMoney;

    public Register() {
    }

    public Register(int id, String caseNumber, String realName, String Gender, String cardNumber, Date birthday, int age, String ageType, String homeAddress, Date visitDate, String noon, int deptId, int employeeId, int registLevelId, int settleCategoryId, String isBook, String registMethod, int visitState, Float registMoney) {
        this.id = id;
        this.caseNumber = caseNumber;
        this.realName = realName;
        this.Gender = Gender;
        this.cardNumber = cardNumber;
        this.birthday = birthday;
        this.age = age;
        this.ageType = ageType;
        this.homeAddress = homeAddress;
        this.visitDate = visitDate;
        this.noon = noon;
        this.deptId = deptId;
        this.employeeId = employeeId;
        this.registLevelId = registLevelId;
        this.settleCategoryId = settleCategoryId;
        this.isBook = isBook;
        this.registMethod = registMethod;
        this.visitState = visitState;
        this.registMoney = registMoney;
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
     * @return caseNumber
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * 设置
     * @param caseNumber
     */
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    /**
     * 获取
     * @return realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取
     * @return Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * 设置
     * @param Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * 获取
     * @return cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置
     * @param cardNumber
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
     * @return ageType
     */
    public String getAgeType() {
        return ageType;
    }

    /**
     * 设置
     * @param ageType
     */
    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    /**
     * 获取
     * @return homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取
     * @return visitDate
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * 设置
     * @param visitDate
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
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
     * @return deptId
     */
    public int getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置
     * @param employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
     * @return settleCategoryId
     */
    public int getSettleCategoryId() {
        return settleCategoryId;
    }

    /**
     * 设置
     * @param settleCategoryId
     */
    public void setSettleCategoryId(int settleCategoryId) {
        this.settleCategoryId = settleCategoryId;
    }

    /**
     * 获取
     * @return isBook
     */
    public String getIsBook() {
        return isBook;
    }

    /**
     * 设置
     * @param isBook
     */
    public void setIsBook(String isBook) {
        this.isBook = isBook;
    }

    /**
     * 获取
     * @return registMethod
     */
    public String getRegistMethod() {
        return registMethod;
    }

    /**
     * 设置
     * @param registMethod
     */
    public void setRegistMethod(String registMethod) {
        this.registMethod = registMethod;
    }

    /**
     * 获取
     * @return visitState
     */
    public int getVisitState() {
        return visitState;
    }

    /**
     * 设置
     * @param visitState
     */
    public void setVisitState(int visitState) {
        this.visitState = visitState;
    }

    /**
     * 获取
     * @return registMoney
     */
    public Float getRegistMoney() {
        return registMoney;
    }

    /**
     * 设置
     * @param registMoney
     */
    public void setRegistMoney(Float registMoney) {
        this.registMoney = registMoney;
    }

    public String toString() {
        return "register{id = " + id + ", caseNumber = " + caseNumber + ", realName = " + realName + ", Gender = " + Gender + ", cardNumber = " + cardNumber + ", birthday = " + birthday + ", age = " + age + ", ageType = " + ageType + ", homeAddress = " + homeAddress + ", visitDate = " + visitDate + ", noon = " + noon + ", deptId = " + deptId + ", employeeId = " + employeeId + ", registLevelId = " + registLevelId + ", settleCategoryId = " + settleCategoryId + ", isBook = " + isBook + ", registMethod = " + registMethod + ", visitState = " + visitState + ", registMoney = " + registMoney + "}";
    }
}
