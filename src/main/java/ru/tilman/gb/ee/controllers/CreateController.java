package ru.tilman.gb.ee.controllers;


import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Predicate;

@ViewScoped
@ManagedBean
public class CreateController extends AbstractController {


    @Inject
    private ProductDAO productDAO;

    @Inject
    private CategoryDAO categoryDAO;

    private List<Category> categories;
    private String categoryId;
    private Product product = new Product();

    @PostConstruct
    private void init() {
        categories = categoryDAO.getCategories();
        System.out.println("init");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String save() {
        product.setCategory(categories
                .stream()
                .filter(category -> category.getId().equals(categoryId))
                .findAny().orElse(null));

        productDAO.persist(product);
        return "products.xhtml" + "?faces-redirect=true";
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}