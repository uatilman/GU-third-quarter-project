package ru.tilman.gb.ee.lesson1.users;

import ru.tilman.gb.ee.lesson1.Cart;

import java.util.List;

public class ManagerUser extends AuthorizedUser {
    List<Cart> cartsList;

    public ManagerUser(UnAuthorizedUser unAuthorizedUser, UsersType usersType) {
        super(unAuthorizedUser, usersType);
    }
}
