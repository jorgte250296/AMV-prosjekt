package servlets;

/* Importerer java-klasser */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* @WebServlet definerer bruk av servlets, se andre import-linje
 * Definerer en klasse (CategoryServlet) som bygger på HttpServlet-klassen */

@WebServlet("/category-servlet")
public class CategoryServlet extends HttpServlet {

    /* Metodeerklæring er ment å overstyre doGet-metoden i HttpServlet-klassen.
     *  doGet er en av mange klasser i HttpServlet: doGet, doPost, doDelete, doPut.. */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*  Linjen blir kjørt når man forespør /category-servlet */
        request.getRequestDispatcher("tools.jsp").forward(request, response);
    }
}
