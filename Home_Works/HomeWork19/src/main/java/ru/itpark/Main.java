package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.*;

import ru.itpark.connection.CarsDbConnection;
import ru.itpark.connection.CarsDbConnectionImpl;
import ru.itpark.connection.HumansDbConnection;
import ru.itpark.connection.HumansDbConnectionImp;
import ru.itpark.dao.CarsDaoJdbcTemplateImpl;
import ru.itpark.dao.HumansDaoJdbcTemplateImpl;


public class Main  {
    public static void main(String[] args)  {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/grigoriev_db");

        HumansDaoJdbcTemplateImpl humansDaoJdbcTemplate = new HumansDaoJdbcTemplateImpl(dataSource);
        System.out.println(humansDaoJdbcTemplate.find(2));

        CarsDaoJdbcTemplateImpl carsDaoJdbcTemplate = new CarsDaoJdbcTemplateImpl(dataSource);
        System.out.println(carsDaoJdbcTemplate.find(1));


        String name = "postgres";
        String password = "1234";
        String url = "jdbc:postgresql://localhost:5432/grigoriev_db";

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            //human connection
            HumansDbConnection humansDbConnection = new HumansDbConnectionImp(connection);
            System.out.println(humansDbConnection.find(4));


            //car connection
            CarsDbConnection carsDbConnection = new CarsDbConnectionImpl(connection);
            System.out.println(carsDbConnection.find(2));

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
