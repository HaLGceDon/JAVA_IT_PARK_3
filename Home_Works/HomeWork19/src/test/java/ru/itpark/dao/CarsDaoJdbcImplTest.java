package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Car;

public class CarsDaoJdbcImplTest {
    private CarsDaoJdbcImpl testedCarsJdbConnection;
    @Before
    public void setUp() throws Exception {
        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();
        DriverManagerDataSource dataSource = (DriverManagerDataSource) componentsFactory.dataSource();
        testedCarsJdbConnection = new CarsDaoJdbcImpl(dataSource);
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