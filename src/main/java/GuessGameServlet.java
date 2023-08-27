import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/guess")
public class GuessGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/guess-game.jsp").forward(request, response);
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guess = Integer.parseInt(request.getParameter("playerGuess"));

        if(guess < 1 || guess > 3) {
            response.sendRedirect("/guess");
        } else if (guess == 1 || guess == 3) {
            response.sendRedirect("/incorrect?guess=" + guess);
        } else {
            response.sendRedirect("/correct?guess=" + guess);
        }
    }
}
