package com.ruan.bean.dto;

public class DrugDto {
    private int drugId;
    private String drugCode;
    private String drugName;
    private String drugFormat;
    private String drugUnit;
    private String manufacturer;
    private String drugPrice;
    private int drugNum;

    public DrugDto(int id, int register_id1, int drug_id, String drug_name, String drug_format, String drug_unit, String drug_price, int drug_number, String drug_money, String drug_state) {
    }

    public DrugDto(String drugCode, String drugName, String drugFormat, String drugUnit, String manufacturer, String drugPrice, int drugNum) {
        this.drugCode = drugCode;
        this.drugName = drugName;
        this.drugFormat = drugFormat;
        this.drugUnit = drugUnit;
        this.manufacturer = manufacturer;
        this.drugPrice = drugPrice;
        this.drugNum = drugNum;
    }

    public DrugDto() {
    }

    public DrugDto(int drugId, String drugCode, String drugName, String drugFormat, String drugUnit, String manufacturer, String drugPrice, int drugNum) {
        this.drugId = drugId;
        this.drugCode = drugCode;
        this.drugName = drugName;
        this.drugFormat = drugFormat;
        this.drugUnit = drugUnit;
        this.manufacturer = manufacturer;
        this.drugPrice = drugPrice;
        this.drugNum = drugNum;
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
     * @return drugNum
     */
    public int getDrugNum() {
        return drugNum;
    }

    /**
     * 设置
     * @param drugNum
     */
    public void setDrugNum(int drugNum) {
        this.drugNum = drugNum;
    }

    public String toString() {
        return "DrugDto{drugCode = " + drugCode + ", drugName = " + drugName + ", drugFormat = " + drugFormat + ", drugUnit = " + drugUnit + ", manufacturer = " + manufacturer + ", drugPrice = " + drugPrice + ", drugNum = " + drugNum + "}";
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
}
