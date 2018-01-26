package ru.itpark.servlets.dogs;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DogsJspServletForDelete extends HttpServlet {
    private DogsRepository dogsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.dogsRepository = (DogsRepository) config.getServletContext().getAttribute("dogsRepository");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(req.getParameter("id"));
        dogsRepository.delete(id);
        resp.sendRedirect(req.getContextPath() + "/dogs");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/dogs");
    }
}