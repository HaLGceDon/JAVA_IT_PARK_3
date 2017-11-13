package ru.itpark;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.dao.HumansDao;
import ru.itpark.dao.jdbc.template.HumansJdbcTemplateDaoImpl;
import ru.itpark.models.Human;

public class Main {



  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUsername("postgres");
    dataSource.setPassword("HaL_17071991");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/grigoriev_db");

    HumansDao humansDao = new HumansJdbcTemplateDaoImpl(dataSource);
    Human avraam = new Human("Авраам", 75, 180);

    System.out.println(avraam);
    humansDao.save(avraam);
    System.out.println(avraam);



  }
}

