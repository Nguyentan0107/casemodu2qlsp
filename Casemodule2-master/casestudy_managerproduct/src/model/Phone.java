package model;

import java.io.Serializable;

public abstract class Phone implements Discount,Serializable {
    private String id;
    private String name;
    private String trademark;
    private double price;
    public Phone() {}

    public Phone(String id, String name, String trademark, double price) {
        this.id = id;
        this.name = name;
        this.trademark = trademark;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double getAmount();

}
