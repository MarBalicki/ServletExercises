package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NumbersServlet", value = "/numbers")
public class NumbersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        printNumbersDividedBy3(out);
    }

    private void printNumbersDividedBy3(PrintWriter out) {
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                counter++;
                out.print(i + " ");
                if (counter % 3 == 0) {
                    out.println();
                }
            }
        }
    }
}
