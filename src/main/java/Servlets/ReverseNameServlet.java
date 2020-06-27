package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ReverseNameServlet", value = "/reverse")
public class ReverseNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reverseReq = reverse(req);
        resp.getWriter().println(reverseReq);
    }

    private String reverse(HttpServletRequest req) {
        StringBuilder reversed = new StringBuilder();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Collection<String[]> values = parameterMap.values();
        for (String[] value : values) {
            for (String s : value) {
                for (int i = s.toCharArray().length - 1; i >= 0; i--) {
                    reversed.append(s.charAt(i));
                }
            }
//            Collections.reverse(Arrays.asList(value)); // nie działa??!
//            reversed.append(Arrays.toString(value));
        }
        return reversed.toString();
    }
}
