package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.MenuItems;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MenuDao extends AbstractDAO {

    public List<MenuItems> getMenuList(){
        return em.createQuery("SELECT e FROM MenuItems e", MenuItems.class).getResultList();
    }

}
