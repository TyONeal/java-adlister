import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/viewcolor")
public class ColorDisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String color = request.getParameter("color");
       request.setAttribute("color", color);
       request.getRequestDispatcher("/color-view.jsp").forward(request,response);
    }
}
