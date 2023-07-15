package com.ruan.bean;
//设计一个实体类（手机类），设计不少于5个属性，设计get和set方法（比如名字或者价格）
public class Phone {
    private String name;
    private String color;
    private String size;
    private String price;
    private String brand;

    public Phone(String name, String color, String size, String price, String brand) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;

    }

    public void setSize(String size) {
        this.size = size;

    }

    public void setPrice(String price) {
        this.price = price;

    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

    //测试运行所有的方法
    public static void main(String[] args) {
        Phone phone = new Phone("小米8", "黑色", "5.5寸", "1999", "小米");
        System.out.println(phone.getName());
        System.out.println(phone.getColor());
        System.out.println(phone.getSize());
        System.out.println(phone.getPrice());
        System.out.println(phone.getBrand());
        //测试set方法
        phone.setName("华为mate");
        phone.setColor("白色");
        phone.setSize("6.0寸");
        phone.setPrice("2999");
        phone.setBrand("华为");
        System.out.println(phone.getName());
        System.out.println(phone.getColor());
        System.out.println(phone.getSize());
        System.out.println(phone.getPrice());
        System.out.println(phone.getBrand());
    }
}

