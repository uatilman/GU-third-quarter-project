package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrderProductDAO;
import ru.tilman.gb.ee.entity.OrderProducts;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrderProductController extends AbstractController {

    private final String id = getParamString("id");


    @Inject
    private OrderProductDAO orderProductDAO;

    private List<OrderProducts> orderProductsList;

    private int count;

    @PostConstruct
    private void init() {
        System.out.println("init OrderProductController");
        orderProductsList = orderProductDAO.getOrderProductsListByOrderId(id);
    }

    public List<OrderProducts> getOrderProducts() {
         return new ArrayList<>(orderProductDAO.getOrderProductsListByOrderId(id));

    }
    /**unchecked*/
    public void save(String id, String count) {
        System.out.println("count: " + count);
        System.out.printf("Id: %s, count: %s count.\n", id, count);
        String countParam = getParamString("count");
        System.out.println(countParam);
        for (OrderProducts op:orderProductsList) {
            System.out.println(op.getCount());
        }
        System.out.println(orderProductsList);
//        System.out.println(orderProduct.getCount());
//        orderProductDAO.merge(orderProduct);
    }

    public String getId() {
        return id;
    }

    public OrderProductDAO getOrderProductDAO() {
        return orderProductDAO;
    }

    public void setOrderProductDAO(OrderProductDAO orderProductDAO) {
        this.orderProductDAO = orderProductDAO;
    }

    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
