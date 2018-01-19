package ru.itpark;

import ru.itpark.repository.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("persistence");

        UsersRepository usersRepository = new UsersRepositoryImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("usersRepository", usersRepository);

        CatsRepository catsRepository = new CatsRepositoryImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("catsRepository", catsRepository);

        DogsRepository dogsRepository = new DogsRepositoryImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("dogsRepository", dogsRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}