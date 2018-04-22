package ru.tilman.gb.ee.garbage;


import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.entity.Category;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class CategoryConverter implements Converter {

    //    private String id;
//    private String name;
//    private String description;
//
//
//    public Category toCategory() {
//        return new Category(id, name, description);
//    }
//
//    public CategoryConverter(Category category) {
//        this.id = category.getId();
//        this.name = category.getName();
//        this.description = category.getDescription();
//    }
//
////    public CategoryConverter(String id, String name, String description) {
////        this.id = id;
////        this.name = name;
////        this.description = description;
////    }
//
//    public CategoryConverter() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        System.out.println("getAsObject " + submittedValue);
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        Category category = categoryDAO.getCategoryById(submittedValue);
        return category;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        System.out.println("getAsString");
        if (o == null) return "";
        return o.toString();
    }


}
