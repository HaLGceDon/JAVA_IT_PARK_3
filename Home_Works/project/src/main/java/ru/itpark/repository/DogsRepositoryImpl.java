package ru.itpark.repository;

import ru.itpark.models.Dog;

import javax.persistence.EntityManager;
import java.util.List;

public class DogsRepositoryImpl implements DogsRepository {
    private EntityManager entityManager;

    public DogsRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Dog> findAll() {
        return entityManager
                .createQuery("from Dog dog order by dog.id", Dog.class)
                .getResultList();
    }

    @Override
    public void save(Dog model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Dog dog = entityManager.find(Dog.class, id);
        if (dog != null) {
            entityManager.remove(dog);
        }
        entityManager.getTransaction().commit();
    }


}
