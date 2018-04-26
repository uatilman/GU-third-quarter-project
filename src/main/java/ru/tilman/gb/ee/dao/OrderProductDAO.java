package ru.tilman.gb.ee.dao;

import com.sun.org.apache.bcel.internal.generic.Select;
import ru.tilman.gb.ee.entity.OrderProductsIds;
import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.ee.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

@Stateless
public class OrderProductDAO extends AbstractDAO {

    public List<Product> getListProductsByOrderId(String id) {
        System.out.println("getListProductsByOrderId");
        Query query = em.createQuery(
                "SELECT orderproducts.orderProductsIds.productId, product.name, orderproducts.count " +
                        "FROM OrderProducts orderproducts " +
                        "LEFT JOIN Product product " +
                        "ON (orderproducts.orderProductsIds.productId = product.id) " +
                        "WHERE orderproducts.orderProductsIds.orderId " +
                        "LIKE :id").setParameter("id", "111");
        List<Object[]> list1 = query.getResultList();
        System.out.println("length list1" + list1.size());


        List<Product> list = em.createQuery(
                "SELECT product " +
                        "FROM OrderProducts orderproducts " +
                        "LEFT JOIN Product product " +
                        "ON (orderproducts.orderProductsIds.productId = product.id) " +
                        "WHERE orderproducts.orderProductsIds.orderId " +
                        "LIKE :id", Product.class).setParameter("id", "111").getResultList();

        System.out.println("length list" + list.size());
        System.out.println(list);

//        for (String result : list) {
//            System.out.println("in for");
//            System.out.println(result[0].toString() + "+++" + result[1].toString() + "+++" + result[1].toString());
//        }


        List<Product> productList = em.createQuery(
                "SELECT p from Product p WHERE p.id IN (" +
                        "SELECT e.orderProductsIds.productId FROM OrderProducts e WHERE e.orderProductsIds.orderId LIKE :id)", Product.class
        ).setParameter("id", id).getResultList();
        System.out.println(productList);

        return productList;

    }
}
