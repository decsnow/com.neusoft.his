package com.ruan.bean;

import java.util.Date;

public class Drug {
    private int id;
    private String drugCode;
    private String drugName;
    private String drugFormat;
    private String drugUnit;
    private String manufacturer;
    private String drugDosage;
    private String drugType;
    private String drugPrice;
    private String mnemonicCode;
    private Date creationDate;

    public Drug() {
    }

    public Drug(int id, String drugCode, String drugName, String drugFormat, String drugUnit, String manufacturer, String drugDosage, String drugType, String drugPrice, String mnemonicCode, Date creationDate) {
        this.id = id;
        this.drugCode = drugCode;
        this.drugName = drugName;
        this.drugFormat = drugFormat;
        this.drugUnit = drugUnit;
        this.manufacturer = manufacturer;
        this.drugDosage = drugDosage;
        this.drugType = drugType;
        this.drugPrice = drugPrice;
        this.mnemonicCode = mnemonicCode;
        this.creationDate = creationDate;
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
     * @return drugCode
     */
    public String getDrugCode() {
        return drugCode;
    }

    /**
     * 设置
     * @param drugCode
     */
    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    /**
     * 获取
     * @return drugName
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * 设置
     * @param drugName
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * 获取
     * @return drugFormat
     */
    public String getDrugFormat() {
        return drugFormat;
    }

    /**
     * 设置
     * @param drugFormat
     */
    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat;
    }

    /**
     * 获取
     * @return drugUnit
     */
    public String getDrugUnit() {
        return drugUnit;
    }

    /**
     * 设置
     * @param drugUnit
     */
    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }

    /**
     * 获取
     * @return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 设置
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * 获取
     * @return drugDosage
     */
    public String getDrugDosage() {
        return drugDosage;
    }

    /**
     * 设置
     * @param drugDosage
     */
    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    /**
     * 获取
     * @return drugType
     */
    public String getDrugType() {
        return drugType;
    }

    /**
     * 设置
     * @param drugType
     */
    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    /**
     * 获取
     * @return drugPrice
     */
    public String getDrugPrice() {
        return drugPrice;
    }

    /**
     * 设置
     * @param drugPrice
     */
    public void setDrugPrice(String drugPrice) {
        this.drugPrice = drugPrice;
    }

    /**
     * 获取
     * @return mnemonicCode
     */
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    /**
     * 设置
     * @param mnemonicCode
     */
    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    /**
     * 获取
     * @return creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 设置
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String toString() {
        return "Drug{id = " + id + ", drugCode = " + drugCode + ", drugName = " + drugName + ", drugFormat = " + drugFormat + ", drugUnit = " + drugUnit + ", manufacturer = " + manufacturer + ", drugDosage = " + drugDosage + ", drugType = " + drugType + ", drugPrice = " + drugPrice + ", mnemonicCode = " + mnemonicCode + ", creationDate = " + creationDate + "}";
    }
}
