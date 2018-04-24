package ru.tilman.gb.ee.controllers;

import ru.tilman.gb.ee.dao.OrderDAO;
import ru.tilman.gb.ee.entity.OrderTable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class OrderController {
    @Inject
    private OrderDAO orderDAO;

    public void removeOrder(OrderTable orderTable) {
        orderDAO.removeById(orderTable.getId(), orderTable.getClass());
    }

    public List<OrderTable> getOrders() {
        return new ArrayList<>(orderDAO.getListOrders());
    }


}
