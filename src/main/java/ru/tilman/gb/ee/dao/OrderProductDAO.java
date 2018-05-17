package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.logger.Loggable;
import ru.tilman.gb.ee.logger.ProjectLogger;
import ru.tilman.gb.ee.entity.*;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Interceptors(ProjectLogger.class)
@Loggable
public class OrderProductDAO extends AbstractDAO {

    public void merge(OrderProducts entity) {
        if (entity == null) return;
        em.merge(entity);
    }

    //    @Loggable
    public List<OrderProducts> getOrderProductsListByOrderId(String id) {
        return em.createQuery(
                "SELECT orderproducts " +
                        "FROM orderproducts orderproducts " +
                        "WHERE orderproducts.orderProductsIds.orderId " +
                        "LIKE :id", OrderProducts.class).setParameter("id", id).getResultList();
    }

    public List<Product> getListProductsByOrderId(String id) {
        return em.createQuery(
                "SELECT p from product p WHERE p.id IN (" +
                        "SELECT e.orderProductsIds.productId FROM orderproducts e WHERE e.orderProductsIds.orderId LIKE :id)", Product.class
        ).setParameter("id", id).getResultList();

    }

    public OrderProducts OrderProductsBiId(String id) {
        if (id == null) return null;
        return em.find(OrderProducts.class, id);
    }

    public void persist(OrderProducts orderProducts) {
        if (orderProducts == null) return;
        em.createNativeQuery(
                "INSERT INTO orderproducts (`count`, `orderTable_id`, `product_id`, `id`) " +
                        "VALUES (:countproduct, :ordertableid, :productid, :id)")
                .setParameter("countproduct", Integer.toString(orderProducts.getCount()))
                .setParameter("ordertableid", orderProducts.getOrderTable().getId())
                .setParameter("productid", orderProducts.getProduct().getId())
                .setParameter("id", orderProducts.getId()).executeUpdate();
    }

}
