package ru.tilman.gb.ee.controllers;

import ru.tilman.gb.ee.dao.MenuDao;
import ru.tilman.gb.ee.entity.MenuItems;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class MenuController {

    @Inject
    private MenuDao menuDao;

    public List<MenuItems> getMenuItems() {
        return new ArrayList<>(menuDao.getMenuList()) ;
    }
}

/*
<!--          <p:dataList value="${menuController.menuItems}" var="item" styleClass="menu" >
<li><a href="${request.contextPath}/admin/products/ #{item.url}">#{item.name}</a></li>
</p:dataList>-->*/
