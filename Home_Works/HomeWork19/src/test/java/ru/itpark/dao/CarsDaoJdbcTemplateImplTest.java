package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.models.Car;

public class CarsDaoJdbcTemplateImplTest {
    private CarsDaoJdbcTemplateImpl testedCarsDao;

    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("HaL_17071991");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/grigoriev_db");

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