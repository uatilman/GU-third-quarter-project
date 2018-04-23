package ru.tilman.gb.ee.controllers;

import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.AbstractEntity;
import ru.tilman.gb.ee.entity.Product;

import javax.faces.bean.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
'@ManagedBean(name = "list", eager = true)
указывает на то, что java-класс, является управляемым бином
с именем list и параметром eager,
который указывает, в какой момент времени будет создан бин.
Если значения этого параметра равно true, то бин будет создан при первом запросе к нему,
так называемая ленивая инициализация.
Альтернатива в faces-config.xml указать
    <managed-bean>
        <managed-bean-name>product</managed-bean-name>
        <managed-bean-class>ru.tilman.gb.ee.entity.Product</managed-bean-class>
        <managed-bean-scope>request</managed-bean-scope>
    </managed-bean>
*/
@ManagedBean
@ApplicationScoped
public class ProductsController implements Serializable {

    @Inject
    private ProductDAO productDAO;

    private AbstractEntity product = new Product();

    public void removeProduct(Product product) {
        productDAO.removeById(product.getId(), product.getClass());
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productDAO.getListProduct());
    }

    public String edit(Product product) {
        return "edit.xhtml";
    }


}
