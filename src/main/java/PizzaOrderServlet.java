import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizza-order")
public class PizzaOrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza-order.jsp").forward(req,rep);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String crust = req.getParameter("crustSelect");
        String sauce = req.getParameter("sauceSelect");
        String size = req.getParameter("sizeSelect");

        String[] toppingsArray = req.getParameterValues("toppings");

        String address = req.getParameter("address-select");

        System.out.println("Selected Crust: " + crust);
        System.out.println("Selected Sauce: " + sauce);
        System.out.println("Selected Size: " + size);
        if (toppingsArray != null) {
            System.out.println("Selected Toppings: " + String.join(", ", toppingsArray));
        } else {
            System.out.println("No Toppings Selected");
        }
        System.out.println("Selected Address: " + address);


        req.getRequestDispatcher("/pizza-order.jsp").forward(req, rep);
    }
}
