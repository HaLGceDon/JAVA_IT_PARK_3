package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Car;

import javax.sql.DataSource;

public class CarsDaoJdbcImplTest {
    private CarsDaoJdbcImpl testedCarsJdbConnection;
    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
        DataSource dataSource = context.getBean(DataSource.class);

        testedCarsJdbConnection =  new CarsDaoJdbcImpl(dataSource);
    }

    @Test
    public void find() throws Exception {
        Car expected = Car.builder()
                .color("red")
                .id(1)
                .model("Tesla")
                .number("x777xx")
                .build();

        Car actual = testedCarsJdbConnection.find(1);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedCarsJdbConnection.find(44);
    }

}