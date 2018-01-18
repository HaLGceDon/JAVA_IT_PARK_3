package com.company.repository;

import com.company.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component(value = "userrepository")
public class UsersRepositoryImpl implements UsersRepository {


    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM owner";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, (row, rowNumber) -> User.builder()
                .id(row.getLong("id"))
                .name(row.getString("name"))
                .build());
    }

    @Override
    @Transactional
    public void save(Object model) {
        entityManager.persist(model);
    }
}
