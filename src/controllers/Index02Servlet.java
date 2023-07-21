package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message02;
import utils.DBUtil02;

@WebServlet("/index")
public class Index02Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Index02Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil02.createEntityManager();

        List<Message02> messages = em.createNamedQuery("getAllMessages", Message02.class).getResultList();
        response.getWriter().append(Integer.valueOf(messages.size()).toString());

        em.close();
    }
}