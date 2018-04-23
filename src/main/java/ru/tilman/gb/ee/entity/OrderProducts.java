package ru.tilman.gb.ee.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
/*https://docs.oracle.com/javaee/7/api/javax/persistence/MapsId.html*/

@Entity
public class OrderProducts implements Serializable {

    @EmbeddedId
    private
    OrderProductsIds orderProductsIds;
    @MapsId("orderId")
    @ManyToOne
    private
    Orders orders;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @Column
    private Integer count;


    public OrderProductsIds getOrderProductsIds() {
        return orderProductsIds;
    }

    public void setOrderProductsIds(OrderProductsIds orderProductsIds) {
        this.orderProductsIds = orderProductsIds;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
