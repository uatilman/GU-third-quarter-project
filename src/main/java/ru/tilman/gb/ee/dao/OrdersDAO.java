package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.logger.Loggable;
import ru.tilman.gb.ee.logger.ProjectLogger;
import ru.tilman.gb.ee.entity.OrderTable;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
@Interceptors(ProjectLogger.class)
@Loggable
public class OrdersDAO extends AbstractDAO {

    @Loggable
    public List<OrderTable> getListOrders() {
        return em.createQuery("SELECT e FROM ordertable e", OrderTable.class).getResultList();
    }


    public OrderTable getOrderById(String id) {
        if (id == null) {
            System.out.println("getCategoryById return null");
            return null;
        }
        return em.find(OrderTable.class, id);
    }

}
