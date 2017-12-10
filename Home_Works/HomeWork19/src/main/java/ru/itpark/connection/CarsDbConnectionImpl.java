package ru.itpark.connection;

import ru.itpark.models.Car;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CarsDbConnectionImpl implements CarsDbConnection {

    private Connection connection;

    public CarsDbConnectionImpl(Connection connection) {
        this.connection = connection;

    }

    @Override
    public Car find(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            Car CarResultSet = null;
            while (resultSet.next()) {
                int k = resultSet.getInt("id");
                if (k == id) {
                    CarResultSet = Car.builder()
                            .id(resultSet.getInt("id"))
                            .number(resultSet.getString("number"))
                            .color(resultSet.getString("color"))
                            .model(resultSet.getString("model"))
                            .build();
                }
            }

            if (CarResultSet != null) {
                return CarResultSet;
            } else throw new IllegalArgumentException("User with id <" + id + "> not found");



        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
