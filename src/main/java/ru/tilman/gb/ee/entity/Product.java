package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.logger.ProjectLogger;

import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.util.Objects;

@Entity (name = "product")
@Interceptors(ProjectLogger.class)
public class Product extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column
    private Double price;

    @ManyToOne
    private Category category;

    @Column (name = "img_url")
    private String imgUrl;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(category, product.category) &&
                Objects.equals(imgUrl, product.imgUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, price, category, imgUrl);
    }
}
