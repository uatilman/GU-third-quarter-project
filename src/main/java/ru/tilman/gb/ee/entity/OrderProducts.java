package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.ProjectLogger;

import javax.faces.bean.SessionScoped;
import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.io.Serializable;
/*https://docs.oracle.com/javaee/7/api/javax/persistence/MapsId.html*/

@SessionScoped
@Entity (name = "orderproducts")
@Interceptors(ProjectLogger.class)
public class OrderProducts {

    @EmbeddedId
    private OrderProductsIds orderProductsIds;

    @MapsId("orderId")
    @ManyToOne
    private OrderTable orderTable; //add mysql manual CASCADE:

/*    ALTER TABLE `interior`.`orderproducts`
    DROP FOREIGN KEY `FKbnir9uolyq1xe19j8krsya6ft`;
    ALTER TABLE `interior`.`orderproducts`
    ADD CONSTRAINT `FKbnir9uolyq1xe19j8krsya6ft`
    FOREIGN KEY (`orderTable_id`)
    REFERENCES `interior`.`ordertable` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT;*/

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
