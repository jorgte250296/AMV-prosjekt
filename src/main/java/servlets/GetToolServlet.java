package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import static utils.Queries.getTool;

/* Henter ut et verktøy */
@WebServlet("/GetToolServlet")
public class GetToolServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /* getTool-metoden inneholder en arraylist med verktøy (ligger i Queries). */
        try {
            request.setAttribute("toolsList", getTool(out));
            request.getRequestDispatcher("tools.jsp").forward(request, response);
        } catch (java.lang.Exception throwable) {
            throwable.printStackTrace();
        }
    }
}
