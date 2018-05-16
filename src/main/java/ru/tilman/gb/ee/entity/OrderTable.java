package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.logger.Loggable;
import ru.tilman.gb.ee.logger.ProjectLogger;

import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.util.Date;


@Entity (name = "ordertable")
@Interceptors(ProjectLogger.class)
@Loggable
public class OrderTable extends AbstractEntity {

    @Column
    private String userName;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column
    private Date date;

//    @ManyToOne (cascade = CascadeType.ALL)
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

    // Класс для курса по паттернам
    public static OrderTable getTestOrderTable(String userName, String phone, Date date) {
        OrderTable orderTable = new OrderTable();
        orderTable.userName = userName;
        orderTable.phone = phone;
        orderTable.date = date;
        return orderTable;
    }


}
