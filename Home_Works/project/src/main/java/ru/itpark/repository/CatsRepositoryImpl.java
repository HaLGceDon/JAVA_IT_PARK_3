package ru.itpark.repository;

import ru.itpark.models.Cat;

import javax.persistence.EntityManager;
import java.util.List;

public class CatsRepositoryImpl implements CatsRepository {

    private EntityManager entityManager;

    public CatsRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cat> findAll() {
        return entityManager
                .createQuery("from Cat cat order by cat.id", Cat.class)
                .getResultList();
    }

    @Override
    public void save(Cat model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Cat cat = entityManager.find(Cat.class, id);
        if (cat != null) {
            entityManager.remove(cat);
        }
        entityManager.getTransaction().commit();
    }


}
