package ru.tilman.gb.ee.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * *@MappedSuperclass Указывает класс, информация о сопоставлении которого применяется к объектам, которые наследуются от него.
 * Отображенный суперкласс не имеет отдельной таблицы, определенной для него.
 * */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    protected String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
