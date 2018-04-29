package ru.tilman.gb.ee.controllers.categories;


import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class CreateCategoryController extends AbstractController {

    @Inject
    private CategoryDAO categoryDAO;

    private List<Category> categories;
    private String categoryId;
    private Category category = new Category();

    @PostConstruct
    private void init() {
        System.out.println("init CreateCategoryController");
    }

    public String save() {
        categoryDAO.persist(category);
        return "categories.xhtml" + "?faces-redirect=true";
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
