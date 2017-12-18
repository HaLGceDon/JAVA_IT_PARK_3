package ru.itpark.dao;


import ru.itpark.models.Human;

import javax.sql.DataSource;
import java.sql.*;


public class HumansDaoJdbcImp implements HumansDao {

    private Connection connection;

    public HumansDaoJdbcImp(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }


    @Override
    public Human find(int id) {
        try {
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM owner WHERE id = ?");
           preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Human humanResultSet = null;
            while (resultSet.next()) {
                humanResultSet = Human.builder()
                        .id(resultSet.getInt("id"))
                        .age(resultSet.getInt("age"))
                        .name(resultSet.getString("name"))
                        .height(resultSet.getInt("height"))
                        .build();
            }


            if (humanResultSet != null) {
                return humanResultSet;
            } else throw new IllegalArgumentException("User with id <" + id + "> not found");



        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
