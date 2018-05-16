package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.ee.logger.Loggable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
@Loggable
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

    @Loggable
    public List<OrderTable> getOrders() {
        return new ArrayList<>(ordersDAO.getListOrders());
    }

    @Loggable
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
