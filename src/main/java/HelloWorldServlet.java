import java.io.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {


   long pageCounter = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        String searchName = request.getParameter("name");
        String resetCounter = request.getParameter("reset");

        if(searchName != null && !searchName.isEmpty()) {
            out.println("<h1>Hello, " + searchName + "! " + pageCounter +  " have visited this page...</h1>");
        } else {
            out.println("<h1>Hello, World!</h1>");
        }

        pageCounter++;

        if(Objects.equals(resetCounter, "reset")) {
            pageCounter = 0;
        }


    }
}
