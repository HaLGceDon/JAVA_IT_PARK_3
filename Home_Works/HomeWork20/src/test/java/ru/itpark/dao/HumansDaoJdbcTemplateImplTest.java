package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itpark.ComponentsFactory;
import ru.itpark.models.Human;

import static org.junit.Assert.*;

public class HumansDaoJdbcTemplateImplTest {
    private HumansDaoJdbcTemplateImpl testedHumansDao;

    @Before
    public void setUp() throws Exception {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema_owner.sql")
                .addScript("data_owner.sql")
                .build();
        testedHumansDao = new HumansDaoJdbcTemplateImpl(database);
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
        testedHumansDao.find(2);
    }

}