package ru.tilman.gb.ee.dto;

import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class CategoryRecord {

    private String id;

    private String name;

    private String description;

    public CategoryRecord() {
    }

    public CategoryRecord(Category category) {
        id = category.getId();
        name = category.getName();
        description = category.getDescription();
    }

    public static List<CategoryRecord> toList(List<Category> categories) {
        return (categories == null || categories.isEmpty()) ?
                Collections.emptyList() :
                categories.stream().filter(Objects::nonNull).map(CategoryRecord::new).collect(Collectors.toList());
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


}
