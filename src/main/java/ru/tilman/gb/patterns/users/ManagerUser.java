package ru.tilman.gb.patterns.users;

import ru.tilman.gb.patterns.Cart;

import java.util.List;

public class ManagerUser extends AuthorizedUser {
    List<Cart> cartsList;

    public ManagerUser(UnAuthorizedUser unAuthorizedUser, UsersType usersType) {
        super(unAuthorizedUser, usersType);
    }
}
