package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.Category;

import javax.ejb.Stateless;
import java.util.List;

/**
 * @Stateless говорит о том, что это класс доступа к данным,
 * будет являться чатью фреймворка EJB
 * не хранит в себе состояний, для созданных полей не гарантированно сохранение состояний
 */
@Stateless
public class CategoryDAO extends AbstractDAO {

    public List<Category> getListCategories() {
        return em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
    }


    public Category getCategoryById(String id) {
        if (id == null) {
            System.out.println("getCategoryById return null");
            return null;
        }
        return em.find(Category.class, id);
    }


}
