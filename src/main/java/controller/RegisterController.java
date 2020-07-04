package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    private UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = validateRequest(req);
        if (errorMessage != null) {
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = User.builder()
                .name(name)
                .surname(surname)
                .login(login)
                .password(password)
                .build();
        service.save(user);
        resp.sendRedirect("/login");
    }

    private String validateRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            return "Invalid user name!";
        }
        String surname = req.getParameter("surname");
        if (surname == null || surname.isBlank()) {
            return "Invalid surname name!";
        }
        String login = req.getParameter("login");
        if (login == null || login.isBlank()) {
            return "Invalid login name!";
        }
        boolean exists = service.existByLogin(login);
        if (exists) {
            return "Login is already in use!";
        }
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        if (password == null || password.isBlank() || !password.equals(password2)) {
            return "Invalid user password";
        }
        return null;
    }
}
