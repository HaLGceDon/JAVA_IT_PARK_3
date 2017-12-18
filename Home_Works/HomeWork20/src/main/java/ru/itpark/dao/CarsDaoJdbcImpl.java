package ru.itpark.dao;


import ru.itpark.models.Car;

import javax.sql.DataSource;
import java.sql.*;


public class CarsDaoJdbcImpl implements CarsDao{

    private Connection connection;


    public CarsDaoJdbcImpl(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public Car find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car CarResultSet = null;
            while (resultSet.next()) {
                CarResultSet = Car.builder()
                        .id(resultSet.getInt("id"))
                        .number(resultSet.getString("number"))
                        .color(resultSet.getString("color"))
                        .model(resultSet.getString("model"))
                        .build();
            }
            if (CarResultSet != null) {
                return CarResultSet;
            } else throw new IllegalArgumentException("User with id <" + id + "> not found");



        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
