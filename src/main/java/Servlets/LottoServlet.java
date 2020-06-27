package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "LottoServlet", value = "/lotto")
public class LottoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<div><h1>LOTTO</h1></div>");
        out.println("<div>Wybierz liczbę od 1 do 6</div>");
        out.println("<form method=get>");
        out.println("<div>" +
                "<label>liczba</label>" +
                "<input name=number></input>" +
                "</div>");
        out.println("<div><input type=submit value=Wyślij></input></div>");
        didYouWin(req, out);
        out.println("</body>");
        out.println("</html>");
    }

    private void didYouWin(HttpServletRequest req, PrintWriter out) {
        int randomNumber = new Random().nextInt(6) + 1;
        String parameter = req.getParameter("number");
        out.println("<div>Twoja liczba to: " + parameter + "</div>");
        if (same(parameter, randomNumber)) {
            out.println("<br><div><h1>HURRAAA! WYGRALES!!!</h1></div>");
            out.println("<img src='/images/money.gif' align=top-right width=1000 height=500></img>");
        } else {
            out.println("<br><div><h1>Wylosowana liczba to: " + randomNumber + "</h1></div>");
        }
    }

    private boolean same(String parameter, int randomNumber) {
        return Integer.parseInt(parameter) == randomNumber;
    }

}
