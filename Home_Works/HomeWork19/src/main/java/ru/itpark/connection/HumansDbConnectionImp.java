package ru.itpark.connection;

import ru.itpark.models.Human;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HumansDbConnectionImp implements HumansDbConnection {

    private Connection connection;

    public HumansDbConnectionImp(Connection connection) {
        this.connection = connection;

    }

    @Override
    public Human find(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM owner");
            Human humaRresultSet = null;
            while (resultSet.next()) {
                int k = resultSet.getInt("id");
                if (k == id) {
                    humaRresultSet = Human.builder()
                            .id(resultSet.getInt("id"))
                            .age(resultSet.getInt("age"))
                            .name(resultSet.getString("name"))
                            .height(resultSet.getInt("height"))
                            .build();
                }
            }

            if (humaRresultSet != null) {
                return humaRresultSet;
            } else throw new IllegalArgumentException("User with id <" + id + "> not found");



        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
