package ru.tilman.gb.ee.controllers.products;


import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class EditProductController extends AbstractController {

    private String id = getParamString("id");

    @Inject
    private ProductDAO productDAO;

    private Product product;

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
        productDAO.merge(product);
        return "productList.xhtml" + "?faces-redirect=true";
    }

}
