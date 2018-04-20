package ru.tilman.gb.ee;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ProductsViewToCDI implements Serializable {

    @Inject
    private ProductToCDI productToCDI;

    public ProductsViewToCDI() {
    }

    public ProductToCDI getProductToCDI() {
        return productToCDI;
    }

    public void setProductToCDI(ProductToCDI productToCDI) {
        this.productToCDI = productToCDI;
    }
}
