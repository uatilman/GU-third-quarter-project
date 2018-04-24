package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.OrderTable;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderDAO extends AbstractDAO {

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
