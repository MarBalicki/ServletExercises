package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "TableServlet", value = "/table")
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");
//        String table = table(req);
//        req.setAttribute("table", table);
        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }

    private String table(HttpServletRequest req) {
        String rows = req.getParameter("rows");
        String cols = req.getParameter("cols");
        Random random = new Random();
        StringBuilder table = new StringBuilder();
        table.append("<table>");
        for (int i = 0; i < Integer.parseInt(rows); i++) {
            table.append("<tr>");
            for (int j = 0; j < Integer.parseInt(cols); j++) {
                int randomNumber = random.nextInt(186) + 20;
                int maxRndNumbLength = 3;
                String rndNumb = String.valueOf(randomNumber);
                table.append("<td>");
                for (int k = 0; k < maxRndNumbLength - rndNumb.length(); k++) {
                    table.append("&nbsp;&nbsp");
                }
                table.append(rndNumb).append("</td>");
            }
            table.append("</tr>");
        }
        table.append("</table");
        return table.toString();
    }

}
