package ru.tilman.gb.ee.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/*https://docs.oracle.com/javaee/7/api/javax/persistence/MapsId.html*/
@Embeddable
public class OrderProductsIds implements Serializable {
    private String orderId;
    private String productId;


    public OrderProductsIds() {
    }

    public OrderProductsIds(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductsIds that = (OrderProductsIds) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, productId);
    }
}
