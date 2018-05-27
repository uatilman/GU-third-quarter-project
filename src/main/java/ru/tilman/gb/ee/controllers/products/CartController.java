package ru.tilman.gb.ee.controllers.products;

import ru.tilman.gb.ee.entity.OrderProducts;
import ru.tilman.gb.ee.entity.OrderProductsIds;
import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class CartController {

    private List<OrderProducts> orderProductsList;

    private OrderTable orderTable;

    @PostConstruct
    public void init() {
        orderTable = new OrderTable();
        orderProductsList = new ArrayList<>();
    }

    public void add(Product product) {
        OrderProducts orderProducts = new OrderProducts();
        orderProducts.setOrderProductsIds(new OrderProductsIds(orderTable.getId(), product.getId()));

        if (!orderProductsList.contains(orderProducts)) {
            orderProducts.setProduct(product);
            orderProducts.setOrderTable(orderTable);
            orderProducts.setCount(1);
            orderProductsList.add(orderProducts);
        } else {
            OrderProducts existingOrderProducts =
                    orderProductsList.get(orderProductsList.indexOf(orderProducts));
            existingOrderProducts.setCount(existingOrderProducts.getCount() + 1);
        }

    }

    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }
}
