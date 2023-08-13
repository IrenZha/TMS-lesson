package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        req.setAttribute("firstName", firstName);
        String secondName = req.getParameter("secondName");
        req.setAttribute("secondName",secondName);
        String city = req.getParameter("city");
        req.setAttribute("city", city);
        String product = req.getParameter("product");
        req.setAttribute("product",product);

      if (firstName.isBlank() || secondName.isBlank() || city.isBlank() || product.isBlank()) {
            req.getRequestDispatcher("save-request.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);
    }
}

