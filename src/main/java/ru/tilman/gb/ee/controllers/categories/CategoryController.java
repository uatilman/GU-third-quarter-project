package ru.tilman.gb.ee.controllers.categories;

import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.entity.Category;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class CategoryController implements Serializable {

    @Inject
    private CategoryDAO categoryDAO;

    public void removeCategory(Category category) {
        categoryDAO.removeById(category.getId(), category.getClass());
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categoryDAO.getListCategories());
    }



}
