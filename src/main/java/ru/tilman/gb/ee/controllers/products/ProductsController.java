package ru.tilman.gb.ee.controllers.products;

import ru.tilman.gb.ee.ProjectLogger;
import ru.tilman.gb.ee.controllers.AbstractController;
import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.entity.AbstractEntity;
import ru.tilman.gb.ee.entity.Product;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * '@ManagedBean(name = "list", eager = true)
 * указывает на то, что java-класс, является управляемым бином
 * с именем list и параметром eager,
 * который указывает, в какой момент времени будет создан бин.
 * Если значения этого параметра равно true, то бин будет создан при первом запросе к нему,
 * так называемая ленивая инициализация.
 * Альтернатива в faces-config.xml указать
 * <managed-bean>
 * <managed-bean-name>product</managed-bean-name>
 * <managed-bean-class>ru.tilman.gb.ee.entity.Product</managed-bean-class>
 * <managed-bean-scope>request</managed-bean-scope>
 * </managed-bean>
 */
@ManagedBean
@ViewScoped
public class ProductsController extends AbstractController {

    @Inject
    private ProductDAO productDAO;

    public void removeProduct(Product product) {
        productDAO.removeById(product.getId(), product.getClass());
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productDAO.getListProduct());
    }

//    public void printUserInfo() throws IOException {
//        Enumeration enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()) {
//            String header = (String) enumeration.nextElement();
//            System.out.println(header + ": " + request.getHeader(header));
//        }
//    }     <!--${productsController.printUserInfo()}-->

}
//standalone.bat.lnk -b 0.0.0.0
//standalone.bat.lnk -b=134.0.106.221
//standalone.bat.lnk -b=192.168.1.1

