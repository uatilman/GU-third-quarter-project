package ru.tilman.gb.ee.servlet;

import ru.tilman.gb.ee.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tests")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("productsAttribute", Product.getTestProductList());
        req.setAttribute("url","/header");
//        req.setAttribute("tests-active-link","class=\"active-link\"");
//        req.setAttribute("date", new Date());
//        req.setAttribute("menu", MenuItems.getMenuItems());
        req.getRequestDispatcher("tests.jsp").forward(req, resp);
    }
}
