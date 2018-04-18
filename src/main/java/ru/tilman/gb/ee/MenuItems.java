package ru.tilman.gb.ee;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {
    String path;
    String name;

    public MenuItems(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<MenuItems> getMenuItems() {
        List<MenuItems> menuItems = new ArrayList<MenuItems>();
        menuItems.add(new MenuItems("/tilman", "HOME"));
        menuItems.add(new MenuItems("catalog", "CATALOG"));
        menuItems.add(new MenuItems("product", "PRODUCT"));
        menuItems.add(new MenuItems("cart", "CART"));
        menuItems.add(new MenuItems("order", "ORDER"));
        menuItems.add(new MenuItems("contact", "CONTACT"));
        menuItems.add(new MenuItems("tests", "TESTS"));

        return menuItems;
    }
}
