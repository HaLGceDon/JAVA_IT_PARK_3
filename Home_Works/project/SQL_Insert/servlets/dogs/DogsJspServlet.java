package ru.itpark.servlets.dogs;

import ru.itpark.models.Dog;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DogsJspServlet extends HttpServlet {

    private DogsRepository dogsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.dogsRepository = (DogsRepository) config.getServletContext().getAttribute("dogsRepository");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs", dogsRepository.findAll());
        req.getRequestDispatcher("/jsp/dogs.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        int weight = Integer.parseInt(req.getParameter("weight"));
        String health = req.getParameter("health");

        Dog dog = Dog.builder()
                .name(name)
                .age(age)
                .breed(breed)
                .color(color)
                .weight(weight)
                .health(health)
                .build();

        dogsRepository.save(dog);
        resp.sendRedirect(req.getContextPath() + "/dogs");
    }
}

