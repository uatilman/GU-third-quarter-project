package ru.tilman.gb.ee.controllers;


import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class EditController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private ProductDAO productDAO;

    private Product product;

//    @Inject
//    private ProductsController productsController;


    @PostConstruct
    private void init() {
        product = productDAO.getProductById(id);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String save() {
//        productsView.getProducts().add(new Product(product.getName(), product.getDescription(), product.getImgUrl()));

        productDAO.merge(product);
        return "products.xhtml" +  "?faces-redirect=true";
    }

}
