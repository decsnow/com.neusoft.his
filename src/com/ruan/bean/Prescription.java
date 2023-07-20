package com.ruan.bean;

import java.util.Date;

public class Prescription {
    private int id;
    private int registerId;
    private int drugId;
    private String drugUsage;
    private int drugNumber;
    private Date creationTime;
    private String drugState;

    public Prescription() {
    }

    public Prescription(int id, int registerId, int drugId, String drugUsage, int drugNumber, Date creationTime, String drugState) {
        this.id = id;
        this.registerId = registerId;
        this.drugId = drugId;
        this.drugUsage = drugUsage;
        this.drugNumber = drugNumber;
        this.creationTime = creationTime;
        this.drugState = drugState;
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
     * @return registerId
     */
    public int getRegisterId() {
        return registerId;
    }

    /**
     * 设置
     * @param registerId
     */
    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    /**
     * 获取
     * @return drugId
     */
    public int getDrugId() {
        return drugId;
    }

    /**
     * 设置
     * @param drugId
     */
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    /**
     * 获取
     * @return drugUsage
     */
    public String getDrugUsage() {
        return drugUsage;
    }

    /**
     * 设置
     * @param drugUsage
     */
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    /**
     * 获取
     * @return drugNumber
     */
    public int getDrugNumber() {
        return drugNumber;
    }

    /**
     * 设置
     * @param drugNumber
     */
    public void setDrugNumber(int drugNumber) {
        this.drugNumber = drugNumber;
    }

    /**
     * 获取
     * @return creationTime
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 设置
     * @param creationTime
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 获取
     * @return drugState
     */
    public String getDrugState() {
        return drugState;
    }

    /**
     * 设置
     * @param drugState
     */
    public void setDrugState(String drugState) {
        this.drugState = drugState;
    }

    public String toString() {
        return "Prescription{id = " + id + ", registerId = " + registerId + ", drugId = " + drugId + ", drugUsage = " + drugUsage + ", drugNumber = " + drugNumber + ", creationTime = " + creationTime + ", drugState = " + drugState + "}";
    }
}
