package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderTable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrdersController extends AbstractController {

    @Inject
    private OrdersDAO ordersDAO;

    private OrderTable orderTable;

    @PostConstruct
    private void init() {
        orderTable = new OrderTable();
    }

    public void removeOrder(OrderTable orderTable) {
        ordersDAO.removeById(orderTable.getId(), orderTable.getClass());
    }

    public List<OrderTable> getOrders() {
        return new ArrayList<>(ordersDAO.getListOrders());
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }

    public String save() {
        ordersDAO.persist(orderTable);
        orderTable.setDate(new Date());

        return "orders.xhtml" + "?faces-redirect=true";
    }
}
