package ru.itpark.servlets.cats;


import ru.itpark.models.Cat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CatsJspServlet extends HttpServlet {

    private CatsRepository catsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.catsRepository = (CatsRepository) config.getServletContext().getAttribute("catsRepository");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats", catsRepository.findAll());
        req.getRequestDispatcher("/jsp/cats.jsp").forward(req, resp);

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

        Cat cat = Cat.builder()
                .name(name)
                .age(age)
                .breed(breed)
                .color(color)
                .weight(weight)
                .health(health)
                .build();

        catsRepository.save(cat);
        resp.sendRedirect(req.getContextPath() + "/cats");
    }
}
