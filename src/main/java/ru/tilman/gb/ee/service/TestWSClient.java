package ru.tilman.gb.ee.service;

import ru.tilman.gb.ee.service.mojo.ProductRecord;
import ru.tilman.gb.ee.service.mojo.ProductService;
import ru.tilman.gb.ee.service.mojo.ProductServiceService;

import javax.xml.ws.WebServiceRef;

public class TestWSClient {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/tilman/ProductService?wsdl")
    private static ProductServiceService service = new ProductServiceService();

    public static void main(String[] args) {
        ProductService productService = service.getProductServicePort();
        for (ProductRecord pr:productService.getListProductByCategoryId("1")) {
            System.out.println(pr.getName());
        }
    }
}
