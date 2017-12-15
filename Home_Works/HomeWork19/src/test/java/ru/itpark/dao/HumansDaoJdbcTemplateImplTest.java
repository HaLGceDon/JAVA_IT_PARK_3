package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Human;

import static org.junit.Assert.*;

public class HumansDaoJdbcTemplateImplTest {
    private HumansDaoJdbcTemplateImpl testedHumansDao;

    @Before
    public void setUp() throws Exception {
        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();
        DriverManagerDataSource dataSource = (DriverManagerDataSource) componentsFactory.dataSource();
        testedHumansDao = new HumansDaoJdbcTemplateImpl(dataSource);
    }

    @Test
    public void find() throws Exception {
        Human expected = Human.builder()
                .id(2)
                .age(75)
                .name("Авраам")
                .height(180)
                .build();

        Human actual = testedHumansDao.find(2);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedHumansDao.find(44);
    }

}