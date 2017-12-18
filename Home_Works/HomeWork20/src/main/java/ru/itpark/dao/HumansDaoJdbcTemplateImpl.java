package ru.itpark.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.models.Human;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class HumansDaoJdbcTemplateImpl implements HumansDao {

    private static final String SQL_SELECT_USER_BY_ID =  "SELECT * FROM owner WHERE id = ?";

    private JdbcTemplate template;

    private Map<Integer, Human> humansMap;


    public HumansDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        humansMap = new HashMap<>();
    }

    private RowMapper<Human> humanRowMapper = (resultSet, i) -> Human.builder()
            .id(resultSet.getInt("id"))
            .age(resultSet.getInt("age"))
            .name(resultSet.getString("name"))
            .height(resultSet.getInt("height"))
            .build();




    @Override
    public Human find(int id) {
        // перехватываем исключение, если такого id нету
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_ID, humanRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // выбрасываем новое исключение с комментарием
            throw new IllegalArgumentException("User with id <" + id + "> not found");
        }
    }



}
