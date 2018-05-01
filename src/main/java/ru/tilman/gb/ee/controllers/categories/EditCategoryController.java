package ru.tilman.gb.ee.controllers.categories;


import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.AbstractEntity;
import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@ViewScoped
@ManagedBean
@Interceptors(ProjectLogger.class)
public class EditCategoryController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private CategoryDAO categoryDAO;

    private Category category;

    @PostConstruct
    private void init() {
        category = categoryDAO.getCategoryById(id);
    }

    public AbstractEntity getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public String save() {
        categoryDAO.merge(category);
        return "categories.xhtml" +  "?faces-redirect=true";
    }

}
