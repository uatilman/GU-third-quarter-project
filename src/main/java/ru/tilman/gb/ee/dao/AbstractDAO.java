package ru.tilman.gb.ee.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    /** *@PersistenceContext управление данными, unitName см. persistence.xml */
    @PersistenceContext(unitName = "tilman-persistence-unit")
    protected EntityManager em;

}
