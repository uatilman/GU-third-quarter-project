package ru.tilman.gb.ee;

import java.util.ArrayList;
import java.util.List;

public class ProductsView {
    private List<Product> products;

    public ProductsView() {
        this.products = Product.getTestProductList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
