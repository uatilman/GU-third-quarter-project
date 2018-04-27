package ru.tilman.gb.ee.controllers;

import ru.tilman.gb.ee.ProjectLogger;

import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    public HttpServletRequest request = getHttpServletRequest();

    @Interceptors(ProjectLogger.class)
    protected String getParamString(String paramName) {
        return getHttpServletRequest().getParameter(paramName);
    }

    @Interceptors(ProjectLogger.class)
    public HttpServletRequest getHttpServletRequest() {
        final FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }
}
