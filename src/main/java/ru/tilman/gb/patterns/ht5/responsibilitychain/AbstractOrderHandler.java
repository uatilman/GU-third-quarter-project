package ru.tilman.gb.patterns.ht5.responsibilitychain;

import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.patterns.ht3.users.ManagerUser;


public abstract class AbstractOrderHandler {

    private AbstractOrderHandler next;

    ManagerUser managerUser;

    AbstractOrderHandler link(AbstractOrderHandler next) {
        link(next, next.managerUser);
        return next;
    }

    AbstractOrderHandler link(AbstractOrderHandler next, ManagerUser managerUser) {
        this.next = next;
        this.managerUser = managerUser;
        return next;
    }

    public void handle(OrderTable orderTable) {
        if (next != null)
            next.handle(orderTable);
    }


}
