package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    /**
     * @PersistenceContext управление данными, unitName см. persistence.xml
     */
    @PersistenceContext(unitName = "tilman-persistence-unit")
    protected EntityManager em;

    public void removeById(String id, Class<? extends AbstractEntity> entity) {
        if (id == null || id.isEmpty()) return;
        AbstractEntity element = em.find(entity, id);
        em.remove(element);
    }

}
