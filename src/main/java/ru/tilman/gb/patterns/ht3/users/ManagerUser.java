package ru.tilman.gb.patterns.ht3.users;

import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.patterns.ht3.Cart;

import java.util.ArrayList;
import java.util.List;

public class ManagerUser extends AuthorizedUser {
    List<OrderTable> orderTables;

    public ManagerUser(UnAuthorizedUser unAuthorizedUser, UsersType usersType) {
        super(unAuthorizedUser, usersType);
    }

    public ManagerUser(String userName) {
        super(userName);
        orderTables = new ArrayList<>();
    }

    public List<OrderTable> getOrderTables() {
        return orderTables;
    }

    public void setOrderTables(List<OrderTable> orderTables) {
        this.orderTables = orderTables;
    }
}
