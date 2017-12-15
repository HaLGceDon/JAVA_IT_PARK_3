package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Human;

public class HumansDaoJdbcImpTest {
    private HumansDaoJdbcImp testedHumansJdbConnection;
    @Before
    public void setUp() throws Exception {
        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();
        DriverManagerDataSource dataSource = (DriverManagerDataSource) componentsFactory.dataSource();
        testedHumansJdbConnection = new HumansDaoJdbcImp(dataSource);
    }

    @Test
    public void find() throws Exception {
        Human expected = Human.builder()
                .id(2)
                .age(75)
                .name("Авраам")
                .height(180)
                .build();

        Human actual = testedHumansJdbConnection.find(2);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedHumansJdbConnection.find(44);
    }

}