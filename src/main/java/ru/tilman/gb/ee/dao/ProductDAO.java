package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.AbstractEntity;
import ru.tilman.gb.ee.entity.Product;

import javax.ejb.Stateless;
import java.util.List;

/**
 * @Stateless говорит о том, что это класс доступа к данным,
 * будет являться чатью фреймворка EJB
 * не хранит в себе состояний, для созданных полей не гарантированно сохранение состояний
 */
@Stateless
public class ProductDAO extends AbstractDAO {


    public List<Product> getListProduct() {
        return em.createQuery("SELECT e FROM Product e", Product.class).getResultList();
    }

    public Product getProductById(String id) {
        if (id == null) return null;
        return em.find(Product.class, id);
    }


    public List<Product> getListProductByCategoryId(String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return getListProduct();
        return em.createQuery("SELECT e FROM Product e WHERE e.category.id = :categoryId", Product.class)
                .setParameter("categoryId", categoryId).getResultList();
    }
}
