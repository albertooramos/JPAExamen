package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

abstract class Dao<T> {
    EntityManager em = Persistence
            .createEntityManagerFactory("default")
            .createEntityManager();
    public EntityManager getEntityManager() {
        return this.em;
    }
    public T create(T t) {
        EntityTransaction entityTransaction= em.getTransaction();
        entityTransaction.begin();
        em.persist(t);
        entityTransaction.commit();
        return t;
    }
    public T update(T t) {
        EntityTransaction entityTransaction= em.getTransaction();
        entityTransaction.begin();
        em.merge(t);
        entityTransaction.commit();
        return t;
    }
    public void delete(T t) {
        EntityTransaction entityTransaction= em.getTransaction();
        entityTransaction.begin();
        em.remove(t);
        entityTransaction.commit();
    }

    private void checkTransaction() {
        if (!em.getTransaction().isActive()) throw new
                RuntimeException("Transacción inactiva");
    }

}