package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.logger.ProjectLogger;
import ru.tilman.gb.ee.entity.MenuItems;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
@Interceptors(ProjectLogger.class)
public class MenuDao extends AbstractDAO {

    public List<MenuItems> getMenuList(){
        return em.createQuery("SELECT e FROM menuitems e", MenuItems.class).getResultList();
    }

}
