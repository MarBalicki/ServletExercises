package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "RandomServlet", value = "/random")
public class RandomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<div>Random numbers list:</div>");
        out.println("<div><ul>");
        printRandomNumbers(out);
        out.println("</ul></div>");
        out.println("</body");
        out.println("</html>");
    }

    private void printRandomNumbers(PrintWriter out) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            out.println("<li>" + (random.nextInt(251) + 50) + "</li>");
        }
    }
}
