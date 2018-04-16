package ru.tilman.gb.ee.servlet;

import ru.tilman.gb.ee.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/tests", "/header"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("date", new Date());
        req.setAttribute("productsAttribute", Product.getTestProductList());
        req.getRequestDispatcher("tests.jsp").forward(req, resp);
    }
}
