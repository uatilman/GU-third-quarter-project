package ru.tilman.gb.ee.filter;


import ru.tilman.gb.ee.MenuItems;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = "*")
public class CharsetFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setAttribute("date", new Date());
        servletRequest.setAttribute("menu", MenuItems.getMenuItems());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
