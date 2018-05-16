package ru.tilman.gb.ee.controllers;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    public HttpServletRequest request = getHttpServletRequest();

    protected String getParamString(String paramName) {
        return getHttpServletRequest().getParameter(paramName);
    }

    public HttpServletRequest getHttpServletRequest() {
        final FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public HttpServletRequest getRequest() {
        return request;
    }
}
