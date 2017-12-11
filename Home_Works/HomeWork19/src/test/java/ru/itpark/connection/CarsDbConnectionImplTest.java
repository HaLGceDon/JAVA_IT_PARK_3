package ru.itpark.connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itpark.models.Car;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class CarsDbConnectionImplTest {
    private CarsDbConnectionImpl testedCarsDbConnection;
    @Before
    public void setUp() throws Exception {
        String name = "postgres";
        String password = "1234";
        String url = "jdbc:postgresql://localhost:5432/grigoriev_db";
        Connection connection = DriverManager.getConnection(url, name, password);
        testedCarsDbConnection = new CarsDbConnectionImpl(connection);
    }

    @Test
    public void find() throws Exception {
        Car expected = Car.builder()
                .color("red")
                .id(1)
                .model("Tesla")
                .number("x777xx")
                .build();

        Car actual = testedCarsDbConnection.find(1);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedCarsDbConnection.find(44);
    }

}
