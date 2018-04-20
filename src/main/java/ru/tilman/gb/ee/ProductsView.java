package ru.tilman.gb.ee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
@ManagedBean(name = "list", eager = true)
указывает на то, что java-класс, является управляемым бином
с именем list и параметром eager,
который указывает, в какой момент времени будет создан бин.
Если значения этого параметра равно true, то бин будет создан при первом запросе к нему,
так называемая ленивая инициализация.
Альтернатива в faces-config.xml указать
    <managed-bean>
        <managed-bean-name>product</managed-bean-name>
        <managed-bean-class>ru.tilman.gb.ee.Product</managed-bean-class>
        <managed-bean-scope>request</managed-bean-scope>
    </managed-bean>
*/
@ManagedBean(name = "list", eager = true)
@RequestScoped
public class ProductsView implements Serializable {
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
