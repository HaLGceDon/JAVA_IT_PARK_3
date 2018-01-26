package ru.itpark.servlets.cats;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatsJspServletForDelete  extends HttpServlet {
    private CatsRepository catsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.catsRepository = (CatsRepository) config.getServletContext().getAttribute("catsRepository");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(req.getParameter("id"));
        catsRepository.delete(id);
        resp.sendRedirect(req.getContextPath() + "/cats");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/cats");
    }
}