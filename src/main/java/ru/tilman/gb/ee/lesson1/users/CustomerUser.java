package ru.tilman.gb.ee.lesson1.users;

public class CustomerUser extends AuthorizedUser {

    public CustomerUser(UnAuthorizedUser unAuthorizedUser, UsersType usersType) {
        super(unAuthorizedUser, usersType);
        this.cart = unAuthorizedUser.getCart();
    }
}
