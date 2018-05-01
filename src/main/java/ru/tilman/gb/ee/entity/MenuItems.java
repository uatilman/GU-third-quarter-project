package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.ProjectLogger;

import javax.interceptor.Interceptors;
import javax.persistence.*;

@Entity
@Interceptors(ProjectLogger.class)
public class MenuItems extends AbstractEntity {

    @Column private String name;
    @Column private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
