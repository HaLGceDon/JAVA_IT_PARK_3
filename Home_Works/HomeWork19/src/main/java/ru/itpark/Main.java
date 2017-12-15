package ru.itpark;

import java.sql.*;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.dao.*;


public class Main  {
    public static void main(String[] args)  {
        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();
        DriverManagerDataSource dataSource = (DriverManagerDataSource) componentsFactory.dataSource();

        CarsDaoJdbcTemplateImpl carsDaoJdbcTemplate = new CarsDaoJdbcTemplateImpl(dataSource);
        System.out.println(carsDaoJdbcTemplate.find(2));

        HumansDaoJdbcImp humansDaoJdbcImp = new HumansDaoJdbcImp(dataSource);
        System.out.println(humansDaoJdbcImp.find(2));

        HumansDao humansDao = ComponentsFactory.humansDao();
        System.out.println(humansDao.find(4));

        CarsDao carsDao = ComponentsFactory.carsDao();
        System.out.println(carsDao.find(1));
    }
}
