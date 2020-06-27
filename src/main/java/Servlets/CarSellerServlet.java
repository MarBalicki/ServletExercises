package Servlets;

import model.BodyStyle;
import model.Brand;
import model.Car;
import model.EngineType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarSellerServlet", value = "/carseller")
public class CarSellerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("carSeller.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Car car = getCarFromParam(req);
            req.setAttribute("car", car);
            req.getRequestDispatcher("carAdvertise.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("carAdvertiseError.jsp").forward(req, resp);
        }
    }

    private Car getCarFromParam(HttpServletRequest req) {
        return Car.builder()
                .brand(Brand.valueOf(req.getParameter("brand")))
                .model(req.getParameter("model"))
                .bodyStyle(BodyStyle.valueOf(req.getParameter("bodyStyle")))
                .productionYear(Integer.parseInt(req.getParameter("productionYear")))
                .engineType(EngineType.valueOf(req.getParameter("engineType")))
                .capacity(Double.parseDouble(req.getParameter("capacity")))
                .mileage(Integer.parseInt(req.getParameter("mileage")))
                .numberOfDoors(Integer.parseInt(req.getParameter("numberOfDoors")))
                .build();
    }

}
