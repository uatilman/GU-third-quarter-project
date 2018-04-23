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

    public List<Category> getCategories() {
        return em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
//                .stream()
//                .map(CategoryConverter::new)
//                .collect(Collectors.toList());
    }


    public void persist(Category category) {
        if (category == null) return;
        em.persist(category);
    }

    public Category getCategoryById(String id) {
        if (id == null) {
            System.out.println("getCategoryById return null");
            return null;
        }
        return em.find(Category.class, id);
    }

    public void merge(Category category) {
        if (category == null) return;
        em.merge(category);
    }

//
//    public void removeCategorytById(String categoryId) {
//        // TODO: 22.04.2018 проверка на товар с такой категорией или обработка ошибки удаления
//        if (categoryId == null || categoryId.isEmpty()) return;
//        Category category = em.find(Category.class, categoryId);
//        em.remove(category);
//    }

}
