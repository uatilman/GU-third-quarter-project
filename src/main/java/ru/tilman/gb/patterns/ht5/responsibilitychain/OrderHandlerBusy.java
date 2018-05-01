package ru.tilman.gb.patterns.ht5.responsibilitychain;

import ru.tilman.gb.ee.entity.OrderTable;


public class OrderHandlerBusy extends AbstractOrderHandler {

    private OrderTable orderTable;

    @Override
    AbstractOrderHandler link(AbstractOrderHandler next) {
        return super.link(next);
    }

    @Override
    public void handle(OrderTable orderTable) {
        if (this.orderTable == orderTable) {
            System.out.println("All managers are busy, please wait.");
        } else {
            this.orderTable = orderTable;
        }
        super.handle(orderTable);
    }


}
