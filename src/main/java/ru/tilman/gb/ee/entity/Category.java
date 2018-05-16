package ru.tilman.gb.ee.entity;

import ru.tilman.gb.ee.logger.ProjectLogger;

import javax.interceptor.Interceptors;
import javax.persistence.*;

@Entity (name = "category")
@Interceptors(ProjectLogger.class)
public class Category extends AbstractEntity {

    @Column private String name;
    @Column private String description;

    /**
     * FetchType.LAZY - загрузка по требованию, т.е. коллекция по умолчанию неквытягивается
     * mappedBy - обратная связь - сообщение Hibernate, какая переменная используется, для представления родительского класса в дочернем.
     * cascade = CascadeType.ALL при удалении категории удалятся и продукты
     * cascade = CascadeType.ALL,  orphanRemoval = true см:
     * https://stackoverflow.com/questions/18813341/what-is-the-difference-between-cascade-and-orphan-removal-from-db
     * при этом в бд стоит соотношение RESTRICT -  Отклоняет операцию удаления или обновления для родительской таблицы.
     * Указание RESTRICT(или NO ACTION) аналогично исключению предложения ON DELETE или ON UPDATE.
     * Т.Е. мы неможем удалить категория пока есть продук, который на него ссылается
     */
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products = new ArrayList<Product>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return name;
    }
}
