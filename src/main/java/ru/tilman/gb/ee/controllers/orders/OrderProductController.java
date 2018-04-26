package ru.tilman.gb.ee.controllers.orders;

import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.OrderProductDAO;
import ru.tilman.gb.ee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrderProductController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private OrderProductDAO orderProductDAO;


    public List<Product> getProducts() {
        return new ArrayList<>(orderProductDAO.getListProductsByOrderId(id));

    }


}
