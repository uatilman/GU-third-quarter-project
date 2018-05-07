package ru.tilman.gb.patterns.ht6;

import ru.tilman.gb.ee.entity.Product;

import java.util.Date;
import java.util.HashMap;

public class FullOrder {

    private String id;

    private String userName;

    private String phone;

    private Date date;

    private HashMap<Product, Integer> productsMap = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<Product, Integer> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(HashMap<Product, Integer> productsMap) {
        this.productsMap = productsMap;
    }
}
