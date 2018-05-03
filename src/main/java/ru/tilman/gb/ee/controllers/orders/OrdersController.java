package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderTable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
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
