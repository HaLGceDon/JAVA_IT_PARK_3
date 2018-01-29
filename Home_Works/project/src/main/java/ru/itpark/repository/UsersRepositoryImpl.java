package ru.itpark.repository;

import ru.itpark.models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersRepositoryImpl implements UsersRepository {

  private EntityManager entityManager;

  public UsersRepositoryImpl(EntityManager entityManager) {

    this.entityManager = entityManager;
  }

  @Override
  public List<User> findAll() {
    return entityManager
            .createQuery("from User user order by user.id", User.class)
            .getResultList();
  }

  @Override
  public void save(User model) {
    entityManager.getTransaction().begin();
    entityManager.persist(model);
    entityManager.getTransaction().commit();
  }

  @Override
  public void delete(Long id) {
    entityManager.getTransaction().begin();
    User user = entityManager.find(User.class, id);
    if (user != null) {
      entityManager.remove(user);
    }
    entityManager.getTransaction().commit();
  }


}