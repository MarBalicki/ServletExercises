package Servlets;

import model.Customer;
import model.Gender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private final static String CUSTOMER = "customer";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(10);
        String error = "";
        try {
            if (req.getParameter("username").equals("")
                    || req.getParameter("password").equals("")
                    || req.getParameter("email").equals("")
                    || req.getParameter("phone").equals("")) {
                error = printError(req);
                session.setAttribute("errorStatement", error);
                req.getRequestDispatcher("registerError.jsp").forward(req, resp);
            } else {
                Customer customer = getCustomerFromParams(req);
                session.setAttribute(CUSTOMER, customer);
                req.getRequestDispatcher("registerSuccess.jsp").include(req, resp);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            error = "Phone number is wrong! Have to be numbers";
            session.setAttribute("errorStatement", error);
            req.getRequestDispatcher("registerError.jsp").forward(req, resp);
        }
    }

    private String printError(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();
        builder.append("Field: ");
        if (req.getParameter("username").equals("")) {
            builder.append(" username");
        }
        if (req.getParameter("password").equals("")) {
            builder.append(" password");
        }
        if (req.getParameter("email").equals("")) {
            builder.append(" email");
        }
        if (req.getParameter("phone").equals("")) {
            builder.append(" phone");
        }
        builder.append(" can`t be empty!");
        return builder.toString();
    }

    private Customer getCustomerFromParams(HttpServletRequest req) {
        Customer customer = new Customer();
        customer.setUsername(req.getParameter("username"));
        customer.setPassword(req.getParameter("password"));
        customer.setGender(Gender.valueOf(req.getParameter("gender")));
        customer.setEmail(req.getParameter("email"));
        customer.setPhone(Long.parseLong(req.getParameter("phone")));
        return customer;
    }
}
