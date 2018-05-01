package ru.tilman.gb.ee.service;

import ru.tilman.gb.ee.dao.CategoryDAO;
import ru.tilman.gb.ee.dto.CategoryRecord;
import ru.tilman.gb.ee.dto.ResultRecord;
import ru.tilman.gb.ee.entity.Category;
import ru.tilman.gb.ee.entity.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * c. Добавлять категорию товара;+
 */

@Path("/categoryservice")
@WebService
public class CategoryService {

    @Inject
    private CategoryDAO categoryDAO;

    //http://localhost:8080/tilman/api/categoryservice/allcategories
    @GET
    @Path("/allcategories")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public List<CategoryRecord> getListCategory() {
        return CategoryRecord.toList(categoryDAO.getListCategories());
    }



    //http://localhost:8080/tilman/api/categoryservice/addcategory?name=cat5&description=cat5descriotion
    @GET
    @Path("/addcategory")
    @Produces({MediaType.APPLICATION_JSON})
    public ResultRecord addProduct(
            @QueryParam(value = "name") String name,
            @QueryParam(value = "description") String description
    ) {

        final Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryDAO.merge(category);

        return new ResultRecord();
    }

}
