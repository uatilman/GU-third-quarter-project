package ru.tilman.gb.ee.controllers.products;


import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.AbstractEntity;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@ViewScoped
@ManagedBean
@Interceptors(ProjectLogger.class)
public class EditProductController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private ProductDAO productDAO;

    private Product product;

    @PostConstruct
    private void init() {
        product = productDAO.getProductById(id);
    }

    public AbstractEntity getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String save() {
        productDAO.merge(product);
        return "products.xhtml" +  "?faces-redirect=true";
    }

}
