package ru.itpark;

import java.sql.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.dao.*;
import ru.itpark.models.Human;

import javax.sql.DataSource;


public class Main  {
    public static void main(String[] args)  {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        DataSource dataSource0 = context.getBean("dataSource", DataSource.class);
        HumansDao humansDao0 = new HumansDaoJdbcTemplateImpl( dataSource0);

        Human h1 = humansDao0.find(1);
        System.out.println(h1);

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
