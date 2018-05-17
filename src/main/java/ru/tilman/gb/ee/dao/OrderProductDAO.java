package ru.tilman.gb.ee.dao;


import ru.tilman.gb.ee.entity.*;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderProductDAO extends AbstractDAO {

    public void remove(OrderProducts element) {
        if (element == null) return;
        em.remove(
                em.find(OrderProducts.class, element.getOrderProductsIds())
        );
    }

    public void merge(OrderProducts entity) {
        if (entity == null) return;
        em.merge(entity);
    }

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


    public void persist(OrderProducts orderProducts) {
        if (orderProducts == null) return;
//        em.persist(orderProducts);
        em.createNativeQuery(
                "INSERT INTO orderproducts (`count`, `orderTable_id`, `product_id`) " +
                        "VALUES (:countproduct, :ordertableid, :productid)")
                .setParameter("countproduct", orderProducts.getCount())
                .setParameter("ordertableid", orderProducts.getOrderTable().getId())
                .setParameter("productid", orderProducts.getProduct().getId())
                .executeUpdate();
    }

}
