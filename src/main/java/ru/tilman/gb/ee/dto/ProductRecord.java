package ru.tilman.gb.ee.dto;

import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ProductRecord {

    private String id;

    private String name;

    private String description;

    private Category category;

    private String imgUrl;

    public ProductRecord() {
        id = "";
        name = "";
        description = "";
        imgUrl = "";
    }

    public ProductRecord(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        category = product.getCategory();
        imgUrl = product.getImgUrl();
    }

    public static List<ProductRecord> toList(List<Product> products) {
        return (products == null || products.isEmpty()) ?
                Collections.emptyList() :
                products.stream().filter(Objects::nonNull).map(ProductRecord::new).collect(Collectors.toList());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
