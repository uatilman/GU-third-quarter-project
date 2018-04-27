package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrderProductDAO;
import ru.tilman.gb.ee.entity.OrderProducts;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrderProductController extends AbstractController {

    private final String id = getParamString("id");

//    private List<OrderProducts> orderProductsList;

    @Inject
    private OrderProductDAO orderProductDAO;

//    private List<OrderProducts> orderProductsList;
//    @PostConstruct
//    private void init() {
//        orderProductsList = orderProductDAO.getOrderProductsListByOrderId(id);
//    }

    @Interceptors(ProjectLogger.class)
    public List<OrderProducts> getOrderProducts() {
         return new ArrayList<>(orderProductDAO.getOrderProductsListByOrderId(id));

    }

    @Interceptors(ProjectLogger.class)
    public void save(OrderProducts orderProduct) {
        orderProductDAO.merge(orderProduct);
    }


}
