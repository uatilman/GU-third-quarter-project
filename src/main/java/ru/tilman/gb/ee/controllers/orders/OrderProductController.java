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

    public String getProductTotal(int rowIndex) {
        Double total = orderProductsList.get(rowIndex).getCount() *
                orderProductsList.get(rowIndex).getProduct().getPrice();

        return String.format("%.2f", total);
    }

    public String getTotal() {
        Double total = 0.0;
        for (OrderProducts op : orderProductsList) {
            total += op.getCount() * op.getProduct().getPrice();
        }

        return String.format("%.2f", total);
    }


    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    /**
     * unchecked
     */
    public void save(OrderProducts orderProduct) {
        orderProductDAO.merge(orderProduct);
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


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
