package ru.tilman.gb.ee.controllers;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.dao.MenuDao;
import ru.tilman.gb.ee.entity.MenuItems;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ApplicationScoped
@Interceptors(ProjectLogger.class)
public class MenuController extends AbstractController {

    @Inject
    private MenuDao menuDao;

    public List<MenuItems> getMenuItems() {
        return new ArrayList<>(menuDao.getMenuList());
    }

    public String getStyleClass(String itemUri) {
        HttpServletRequest request = getHttpServletRequest();

        String pageName = request
                .getRequestURI()
                .substring(
                        request.getRequestURI().lastIndexOf("/") + 1,
                        request.getRequestURI().lastIndexOf(".xhtml") + 6);
        String pagItemName = itemUri
                .substring(
                        itemUri.lastIndexOf("/") + 1,
                        itemUri.lastIndexOf(".xhtml") + 6);

        if (pageName.equals(pagItemName))
            return "active-link";
        return "";
    }

    public String getStyleByAttributeName(String itemUri, String attributeURI) {
        String tagItemName = itemUri
                .substring(
                        itemUri.lastIndexOf("/") + 1,
                        itemUri.lastIndexOf(".xhtml") + 6);

        System.out.println(tagItemName.equals(attributeURI) ? "active-link" : "");
        return tagItemName.equals(attributeURI) ? "active-link" : "";
    }

}

/*
<!--          <p:dataList value="${menuController.menuItems}" var="item" styleClass="menu" >
<li><a href="${request.contextPath}/admin/products/ #{item.url}">#{item.name}</a></li>
</p:dataList>-->*/
