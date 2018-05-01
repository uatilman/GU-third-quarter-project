package ru.tilman.gb.ee.service;

import ru.tilman.gb.ee.dao.ProductDAO;
import ru.tilman.gb.ee.dto.ProductRecord;
import ru.tilman.gb.ee.dto.ResultRecord;
import ru.tilman.gb.ee.entity.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Endpoint;
import java.util.List;


/**
 * a. Добавлять товар в БД;+
 * b. Удалять товар из БД;+
 * c. Добавлять категорию товара;
 * d. Получить товар по Id;+
 * e. Получить товар по имени;+
 * f. Получить все товары;+
 * g. Получить товары по Id категории.+
 */

//http://localhost:8080/tilman/ProductService?wsdl
@Path("/productservice")
@WebService
public class ProductService {

    @Inject
    private ProductDAO productDAO;


    //http://localhost:8080/tilman/api/productservice/products?categoryid=1
    @GET
    @Path("/products")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProductRecord> getListProductByCategoryId(
            @QueryParam(value = "categoryid")
            @WebParam(name = "categoryid", partName = "categoryid")
                    String id

    ) {
        return ProductRecord.toList(productDAO.getListProductByCategoryId(id));
    }


    //http://localhost:8080/tilman/api/productservice/allproducts
    @GET
    @Path("/allproducts")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public List<ProductRecord> getListProduct() {
        return ProductRecord.toList(productDAO.getListProduct());
    }

    // TODO: 30.04.18 конфлик имен при одинаковых выходных параметрах
    //http://localhost:8080/tilman/api/productservice/productsname?name=chair
    @GET
    @Path("/productsname")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProductRecord> getProductByName(
            @QueryParam(value = "name") String productName
    ) {
        return ProductRecord.toList(productDAO.getProductsByName(productName));
    }

    //http://localhost:8080/tilman/api/productservice/product?id=1
    @GET
    @Path("/product")
    @Produces({MediaType.APPLICATION_JSON})
    public ProductRecord getProductById(
            @QueryParam(value = "id") String productId
    ) {
        if (productId != null) return new ProductRecord(productDAO.getProductById(productId));
        return null;
    }

    // TODO: 30.04.18 синхронизировать с отетами бд, если товар не найден
    //http://localhost:8080/tilman/api/productservice/removeproduct?id=de284049-aaf7-4895-be32-6247806dd96d
    @GET
    @Path("/removeproduct")
    @Produces({MediaType.APPLICATION_JSON})
    public ResultRecord removeProductById(
            @QueryParam(value = "id") String productId
    ) {

        ResultRecord resultRecord = new ResultRecord();

        if (productId != null) {
            productDAO.removeById(productId, Product.class);
        } else {
            resultRecord.setSuccess(false);
        }
        return resultRecord;
    }


    //http://localhost:8080/tilman/api/productservice/addproducts?name=chair&description=chairdescriotion&imgUrl=product10.jpg
    @GET
    @Path("/addproducts")
    @Produces({MediaType.APPLICATION_JSON})
    public ResultRecord addProduct(
            @QueryParam(value = "name") String name,
            @QueryParam(value = "description") String description,
            @QueryParam(value = "imgUrl") String imgUrl
    ) {

        final Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImgUrl(imgUrl);
        productDAO.merge(product);

        return new ResultRecord();
    }


    //http://localhost:8000/productservice?wsdl
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/productservice", new ProductService());
    }
}
