package ru.tilman.gb.ee;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String description;
    private String imgUrl;

    public Product(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Product> getTestProductList() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Fishnet Chair0", "The majesty of Mountains — Ugmonk style.", "img/product-1.jpg"));
        products.add(new Product("Fishnet Chair1", "The majesty of Mountains — Ugmonk style.", "img/product-3.jpg"));
        products.add(new Product("Fishnet Chair2", "The majesty of Mountains — Ugmonk style.", "img/product10.jpg"));
        products.add(new Product("Fishnet Chair3", "The majesty of Mountains — Ugmonk style.", "img/product1.jpg"));
        return products;
    }
}
