package ru.tilman.gb.patterns.ht5.responsibilitychain;

import ru.tilman.gb.ee.entity.OrderTable;


public class OrderHandler extends AbstractOrderHandler {
    private final double probability = 0.9;

    @Override
    public void handle(OrderTable orderTable) {
        if (isBusy()) {
            System.out.printf("Manager %s is busy\n", managerUser.getUserName());
            super.handle(orderTable);
        } else {
            System.out.printf("Manager %s get order %s\n", managerUser.getUserName(), orderTable.getUserName());
            managerUser.getOrderTables().add(orderTable);
        }
    }

    private boolean isBusy() {
        return Math.random() < probability;
    }
}
