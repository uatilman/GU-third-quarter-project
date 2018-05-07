package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.entity.OrderTable;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

//@Stateless
@Interceptors(ProjectLogger.class)
public class OrdersDAO extends AbstractDAO {

    public List<OrderTable> getListOrders() {
        return em.createQuery("SELECT e FROM OrderTable e", OrderTable.class).getResultList();
    }


    public OrderTable getOrderById(String id) {
        if (id == null) {
            System.out.println("getCategoryById return null");
            return null;
        }
        return em.find(OrderTable.class, id);
    }

}
