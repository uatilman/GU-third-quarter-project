package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderTable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrdersController extends AbstractController {

    @Inject
    private OrdersDAO ordersDAO;

    public void removeOrder(OrderTable orderTable) {
        ordersDAO.removeById(orderTable.getId(), orderTable.getClass());
    }

    public List<OrderTable> getOrders() {
        return new ArrayList<>(ordersDAO.getListOrders());
    }


}
