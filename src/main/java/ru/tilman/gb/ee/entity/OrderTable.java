package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.ProjectLogger;

import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Entity
@Interceptors(ProjectLogger.class)
public class OrderTable extends AbstractEntity {

    @Column
    private String userName;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column
    private Date date;

//    @ManyToOne
//    private OrderProducts orderProducts;

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
