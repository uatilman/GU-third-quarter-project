package ru.tilman.gb.ee.controllers.orders;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrderProductDAO;
import ru.tilman.gb.ee.dao.OrdersDAO;
import ru.tilman.gb.ee.entity.OrderProducts;
import ru.tilman.gb.ee.entity.OrderTable;
import ru.tilman.gb.ee.entity.Product;
import ru.tilman.gb.ee.logger.Loggable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named(value = "orderProductController")
@ViewScoped
@Loggable
public class OrderProductController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private OrdersDAO ordersDAO;

    @Inject
    private OrderProductDAO orderProductDAO;

    private List<OrderProducts> orderProductsList;

    private OrderTable orderTable;

    private int count;

    @PostConstruct
    private void init() {
        orderProductsList = orderProductDAO.getOrderProductsListByOrderId(id);
        orderTable = ordersDAO.getOrderById(id);
    }

    public void chooseProduct() {
        Map<String,Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("1", options, null);
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public void onProductChosen(SelectEvent event) {
        Product product = (Product) event.getObject();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Product Selected", "Id:" + product.getId());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getProductTotal(int rowIndex) {
        Double total = orderProductsList.get(rowIndex).getCount() *
                orderProductsList.get(rowIndex).getProduct().getPrice();
        return String.format("%.2f", total);
    }

    public String getTotal() {
        Double total = 0.0;
        for (OrderProducts op : orderProductsList) {
            total += op.getCount() * op.getProduct().getPrice();
        }

        return String.format("%.2f", total);
    }


    public List<OrderProducts> getOrderProductsList() {

        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    /**
     * unchecked
     */
    public void save(OrderProducts orderProduct) {
        orderProductDAO.merge(orderProduct);
    }

    public String getId() {
        return id;
    }

    public OrderProductDAO getOrderProductDAO() {
        return orderProductDAO;
    }

    public void setOrderProductDAO(OrderProductDAO orderProductDAO) {
        this.orderProductDAO = orderProductDAO;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }
}
