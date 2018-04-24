package ru.tilman.gb.ee.dao;

import ru.tilman.gb.ee.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    /*
     * @PersistenceContext управление данными, unitName см. persistence.xml
     */
    @PersistenceContext(unitName = "tilman-persistence-unit")
    protected EntityManager em;

    public void removeById(String id, Class<? extends AbstractEntity> entityClass) {
        if (id == null || id.isEmpty()) return;
        AbstractEntity element = em.find(entityClass, id);
        em.remove(element);
    }

    public void persist(AbstractEntity entity) {
        if (entity == null) return;
        em.persist(entity);
    }

    public void merge(AbstractEntity entity) {
        if (entity == null) return;
        em.merge(entity);
    }

}
