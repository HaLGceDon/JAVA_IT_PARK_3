package ru.itpark.connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itpark.models.Human;

import java.sql.Connection;
import java.sql.DriverManager;

public class HumansDbConnectionImpTest {
    private HumansDbConnectionImp testedHumansDbConnection;
    @Before
    public void setUp() throws Exception {
        String name = "postgres";
        String password = "HaL_17071991";
        String url = "jdbc:postgresql://localhost:5432/grigoriev_db";
        Connection connection = DriverManager.getConnection(url, name, password);
        testedHumansDbConnection = new HumansDbConnectionImp(connection);
    }

    @Test
    public void find() throws Exception {
        Human expected = Human.builder()
                .id(2)
                .age(75)
                .name("Авраам")
                .height(180)
                .build();

        Human actual = testedHumansDbConnection.find(2);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedHumansDbConnection.find(44);
    }

}