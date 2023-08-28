import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean isLoggedIn = (Boolean) request.getSession().getAttribute("validAttempt");
        if(isLoggedIn != null && isLoggedIn) {
            request.getSession().invalidate();
            response.sendRedirect("/login");
        }
    }
}
