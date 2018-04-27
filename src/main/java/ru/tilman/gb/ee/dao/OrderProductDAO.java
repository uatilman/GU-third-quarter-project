package ru.tilman.gb.ee.dao;

import com.sun.org.apache.bcel.internal.generic.Select;
import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.entity.*;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

@Stateless
public class OrderProductDAO extends AbstractDAO {

    @Interceptors(ProjectLogger.class)
    public List<OrderProducts> getOrderProductsListByOrderId(String id) {
        List<OrderProducts> list = em.createQuery(
                "SELECT orderproducts " +
                        "FROM OrderProducts orderproducts " +
                        "WHERE orderproducts.orderProductsIds.orderId " +
                        "LIKE :id", OrderProducts.class).setParameter("id", id).getResultList();
       return em.createQuery(
               "SELECT orderproducts " +
                       "FROM OrderProducts orderproducts " +
                       "WHERE orderproducts.orderProductsIds.orderId " +
                       "LIKE :id", OrderProducts.class).setParameter("id", "111").getResultList();


//
//        return em.createQuery(
//                "SELECT orderproducts.product,  orderproducts.count " +
//                        "FROM OrderProducts orderproducts " +
//                        "LEFT JOIN Product product " +
//                        "ON (orderproducts.orderProductsIds.productId = product.id) " +
//                        "WHERE orderproducts.orderProductsIds.orderId " +
//                        "LIKE :id").setParameter("id", "111").getResultList();
    }

    @Interceptors(ProjectLogger.class)
    public List<Product> getListProductsByOrderId(String id) {

        return em.createQuery(
                "SELECT p from Product p WHERE p.id IN (" +
                        "SELECT e.orderProductsIds.productId FROM OrderProducts e WHERE e.orderProductsIds.orderId LIKE :id)", Product.class
        ).setParameter("id", id).getResultList();

    }

    @Interceptors(ProjectLogger.class)
    public OrderProducts OrderProductsBiId(String id) {
        if (id == null) return null;
        return em.find(OrderProducts.class, id);
    }

//    @Interceptors(ProjectLogger.class)
//    public void merge(List<OrderProducts> orderProducts) {
//        if (orderProducts == null) {
//            System.out.println("merge is null");
//            return;
//        }
//
//        for (OrderProducts op :orderProducts) {
//            em.merge(op);
//
//        }
//    }

}
