package ru.tilman.gb.ee.controllers.orders;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import ru.tilman.gb.ee.entity.Product;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "viewProducts")
public class ProductDialogViewController {

    public void chooseProduct() {
        System.out.println("chooseProduct");
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        options.put("contentHeight", 320);
//        RequestContext.getCurrentInstance().openDialog("1", options, null);
        PrimeFaces.current().dialog().openDynamic("1");
//        PrimeFaces.current().dialog().openDynamic("1", options, null);
    }

    public String testStart() {
        String s = "dialog  start";
        System.out.println(s);
        return s;
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
}
