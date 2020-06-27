package Servlets;

import model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BeerServlet", value = "/beer")
public class BeerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("beerAdvice.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String beerType = req.getParameter("beerType");
        Person person = null;
        if (beerType.equalsIgnoreCase("strong")) {
            person = new Person(username, beerType, "Warka Strong");
        } else if (beerType.equalsIgnoreCase("dark")) {
            person = new Person(username, beerType, "Lech");
        } else {
            person = new Person(username, beerType, "Desperados");
        }

        req.setAttribute("person", person);
        req.getRequestDispatcher("beerAnswer.jsp").forward(req, resp);
    }
}
