package ru.tilman.gb.ee.entity;

import javax.persistence.*;
import java.io.Serializable;
/*https://docs.oracle.com/javaee/7/api/javax/persistence/MapsId.html*/

@Entity
public class OrderProducts implements Serializable {

    @EmbeddedId
    private
    OrderProductsIds orderProductsIds;
    @MapsId("orderId")
    @ManyToOne
    private OrderTable orderTable;

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

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
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
