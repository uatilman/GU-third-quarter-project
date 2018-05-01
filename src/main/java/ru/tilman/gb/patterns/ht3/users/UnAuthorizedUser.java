package ru.tilman.gb.patterns.ht3.users;

import ru.tilman.gb.patterns.ht3.Cart;

import java.util.ArrayList;

public class UnAuthorizedUser extends User {

    public UnAuthorizedUser(String cookies, String page, Cart cart) {
        this.cookies = cookies;
        this.pageViews = new ArrayList<String>();
        this.pageViews.add(page);
        this.cart = cart;
    }



}
