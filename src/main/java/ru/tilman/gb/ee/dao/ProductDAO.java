package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.logger.ProjectLogger;
import ru.tilman.gb.ee.entity.Product;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;



/**
 * @Stateless говорит о том, что это класс доступа к данным,
 * будет являться чатью фреймворка EJB
 * не хранит в себе состояний, для созданных полей не гарантированно сохранение состояний
 */
@Stateless
//@PermitAll
//@ServletSecurity(@HttpConstraint(rolesAllowed = { "quickstarts" }))
//@RolesAllowed("{quickstarts}")
//@SecurityDomain("servlet-security-quickstart")
@Interceptors(ProjectLogger.class)
public class ProductDAO extends AbstractDAO {


    public List<Product> getListProduct() {
        return em.createQuery("SELECT e FROM product e", Product.class).getResultList();
    }

    public Product getProductById(String id) {
        if (id == null) return null;
        return em.find(Product.class, id);
    }


    public List<Product> getListProductByCategoryId(String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return null;
        return em.createQuery("SELECT e FROM product e WHERE e.category.id = :categoryId", Product.class)
                .setParameter("categoryId", categoryId).getResultList();
    }

    public List<Product> getProductsByName(String productName) {
        System.out.println(productName);
        if (productName == null || productName.isEmpty()) return null;
        return  em.createQuery("SELECT e FROM product e WHERE e.name = :productName", Product.class)
                .setParameter("productName", productName).getResultList();
    }
}
