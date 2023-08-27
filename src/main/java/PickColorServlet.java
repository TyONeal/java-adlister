import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/pickcolor")
public class PickColorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
        req.getRequestDispatcher("/pick-color.jsp").forward(req,rep);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String color = req.getParameter("colorInput");
        rep.sendRedirect("/viewcolor?color=" + color);
    }

}
