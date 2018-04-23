package ru.tilman.gb.ee.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Entity
//@Embeddable
public class Orders extends AbstractEntity {

//    @EmbeddedId
//    private OrderProducts orderProductsId;

    @Column(nullable = false) private String userName;

    @Column(nullable = false, length = 15) private String phone;

    @Column(nullable = false) private Date date;


//    public OrderProducts getOrderProductsId() {
//        return orderProductsId;
//    }
//
//    public void setOrderProductsId(OrderProducts orderProductsId) {
//        this.orderProductsId = orderProductsId;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
