package ru.tilman.gb.patterns.ht6;

import ru.tilman.gb.ee.dao.OrderProductDAO;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderProducts;
import ru.tilman.gb.ee.entity.OrderProductsIds;
import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.ee.entity.Product;

import javax.inject.Inject;
import java.util.*;

public class FullOrderMapper {

    @Inject
    private OrdersDAO ordersDAO;

    @Inject
    private OrderProductDAO orderProductDAO;

    public FullOrder findById(String orderId) {
        if (FullOrderIdentityMap.getInstance().isContainsById(orderId))
            return FullOrderIdentityMap.getInstance().get(orderId);

        List<OrderProducts> orderProductsList = orderProductDAO.getOrderProductsListByOrderId(orderId);
        OrderTable orderTable = ordersDAO.getOrderById(orderId);

        FullOrder fullOrder = new FullOrder();
        fullOrder.setId(orderId);
        fullOrder.setUserName(orderTable.getUserName());
        fullOrder.setPhone(orderTable.getPhone());
        fullOrder.setDate(orderTable.getDate());

        HashMap<Product, Integer> productsMap = new HashMap<>();

        for (OrderProducts op : orderProductsList) {
            productsMap.put(op.getProduct(), op.getCount());
        }

        fullOrder.setProductsMap(productsMap);

        FullOrderIdentityMap.getInstance().put(fullOrder);

        return fullOrder;
    }

    public void insert(FullOrder fullOrder) {
        List<OrderProducts> orderProductsList = toOrderProduct(fullOrder);
        if (orderProductsList.isEmpty()) return;

        FullOrderIdentityMap.getInstance().put(fullOrder);

        ordersDAO.persist(orderProductsList.get(0).getOrderTable());
        for (OrderProducts op : orderProductsList) {
            orderProductDAO.persist(op);
        }

    }


    private static List<OrderProducts> toOrderProduct(FullOrder fullOrder) {
        if (fullOrder == null) return null;
        OrderTable orderTable = new OrderTable();
        orderTable.setUserName(fullOrder.getUserName());
        orderTable.setPhone(fullOrder.getPhone());
        orderTable.setDate(fullOrder.getDate());

        List<OrderProducts> orderProductsList = new ArrayList<>();

        for (Map.Entry<Product, Integer> op : fullOrder.getProductsMap().entrySet()) {
            OrderProducts orderProducts = new OrderProducts();

            orderProducts.setProduct(op.getKey());
            orderProducts.setCount(op.getValue());
            orderProducts.setOrderProductsIds(new OrderProductsIds(fullOrder.getId(), op.getKey().getId()));
            orderProducts.setOrderTable(orderTable);

            orderProductsList.add(orderProducts);
        }


        return orderProductsList;

    }

}
