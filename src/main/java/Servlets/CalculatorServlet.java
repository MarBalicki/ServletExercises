package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private final static String TOTAL_SUM = "totalSum";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double currentSum = calculateSumFromParam(req);
        double totalSum = updateTotalSum(req, currentSum);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p> Suma wszystkich liczb z żądania wynosi: " + totalSum);
        writer.println("</body>");
        writer.println("</html>");
    }

    private double updateTotalSum(HttpServletRequest req, double currentSum) {
        HttpSession session = req.getSession(true);
        Double totalSum = (Double) session.getAttribute(TOTAL_SUM);
        if (totalSum != null) {
            totalSum += currentSum;
            session.setAttribute(TOTAL_SUM, totalSum);
            return totalSum;
        }
        session.setAttribute(TOTAL_SUM, currentSum);
        return currentSum;
    }

    private double calculateSumFromParam(HttpServletRequest req) {
        double sum = 0;
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String[] value = entry.getValue();
            for (String s : value) {
                try {
                    sum += Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    System.out.printf("Wartość %s nie jest liczbą i zostanie pominięte.\n", s);
                }
            }
        }
        return sum;
    }
}
