package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Car;

public class CarsDaoJdbcTemplateImplTest {
    private CarsDaoJdbcTemplateImpl testedCarsDao;

    @Before
    public void setUp() throws Exception {
        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();
        DriverManagerDataSource dataSource = (DriverManagerDataSource) componentsFactory.dataSource();
        testedCarsDao = new CarsDaoJdbcTemplateImpl(dataSource);
    }

    @Test
    public void find() throws Exception {
        Car expected = Car.builder()
                .color("red")
                .id(1)
                .model("Tesla")
                .number("x777xx")
                .build();

        Car actual = testedCarsDao.find(1);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedCarsDao.find(44);
    }

}