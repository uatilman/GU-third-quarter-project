package ru.tilman.gb.ee.lesson1.users;

import ru.tilman.gb.ee.lesson1.Cart;

import java.util.List;

abstract class User {
    String cookies;
    List<String> pageViews;
    Cart cart;


    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public List<String> getPageViews() {
        return pageViews;
    }

    public void setPageViews(List<String> pageViews) {
        this.pageViews = pageViews;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
