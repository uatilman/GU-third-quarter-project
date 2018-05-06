package ru.tilman.gb.patterns.ht5.responsibilitychain;

import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.patterns.ht3.users.ManagerUser;

import java.lang.reflect.Field;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        AbstractOrderHandler orderHandlerBusy = new OrderHandlerBusy();

        orderHandlerBusy
                .link(new OrderHandler(), new ManagerUser("Bob1"))
                .link(new OrderHandler(), new ManagerUser("Bob2"))
                .link(new OrderHandler(), new ManagerUser("Bob3"))
                .link(new OrderHandler(), new ManagerUser("Bob4"))
                .link(orderHandlerBusy);


        for (int i = 1; i < 10; i++) {
            orderHandlerBusy.handle(OrderTable.getTestOrderTable(
                    String.format("*Tom %s*", i),
                    String.format("8-10-12-%d", i),
                    new Date()
            ));
        }
    }

}
