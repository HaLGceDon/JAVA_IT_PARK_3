package ru.itpark.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.models.Car;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class CarsDaoJdbcTemplateImpl implements CarsDao {

    private static final String SQL_SELECT_USER_BY_ID =  "SELECT * FROM cars WHERE id = ?";

    private JdbcTemplate template;

    private Map<Integer, Car> carsMap;


    public CarsDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        carsMap = new HashMap<>();
    }

    private RowMapper<Car> carRowMapper = (resultSet, i) -> Car.builder()
            .id(resultSet.getInt("id"))
            .model(resultSet.getString("model"))
            .color(resultSet.getString("color"))
            .number(resultSet.getString("number"))
            .build();


    @Override
    public Car find(int id) {
        // перехватываем исключение, если такого id нету
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_ID, carRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // выбрасываем новое исключение с комментарием
            throw new IllegalArgumentException("User with id <" + id + "> not found");
        }
    }



}
