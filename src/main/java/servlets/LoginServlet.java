package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static utils.Encryption.encrypt;
import static utils.Validation.validateUser;

/* Forsiden hvor vi sjekker om bruker er i databasen, se metode validateUser i Queries.
 * Oppretter sesstion på unik verdi, telefonnummer. */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String phoneNumber = request.getParameter("phoneNumber");
        String password = encrypt(request.getParameter("password"));
        System.out.println(password);

        /* Hvis bruker er i systemet sendes til GetToolServlet, ellers blir værende på siden. */
        boolean user = validateUser(phoneNumber, password, out);

        if (user) {
            HttpSession session = request.getSession();
            session.setAttribute("phoneNumber", phoneNumber);
            response.sendRedirect("GetToolServlet");
        } else {
            request.getRequestDispatcher("exception.jsp").forward(request, response);
        }
    }
}