package ru.tilman.gb.patterns.users;

public class CustomerUser extends AuthorizedUser {

    public CustomerUser(UnAuthorizedUser unAuthorizedUser, UsersType usersType) {
        super(unAuthorizedUser, usersType);
        this.cart = unAuthorizedUser.getCart();
    }
}
