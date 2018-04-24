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

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
//        System.out.println("getAsObject " + submittedValue);
//        if (submittedValue == null || submittedValue.isEmpty()) {
//            return null;
//        }
//        return categoryDAO.getCategoryById(submittedValue);
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        System.out.println("getAsString");
        if (o == null) return "";
        return o.toString();
    }


}
