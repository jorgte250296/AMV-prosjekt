package servlets;

import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static utils.Queries.checkUser;

/* doGet for å sjekke tilgangen til brukeren som er logget inn.
 *  Dersom brukeren ikke er admin i tilfelle bil det printes ut "Ikke tilgang". */
@WebServlet("/create-tool")
public class CreateToolServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        if (checkUser(pw, session)) {
            getServletContext().getRequestDispatcher("/add-tool.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("exception.jsp").forward(request, response);
        }
    }

    /* doPost for å opprette verktøy i databasen. Vi bruker sql-insert-funksjonen og oppgir riktige verdier.
     * setString og setBoolean setter verdi etter paramenterindeks og informasjon fra getParameter.
     * Sjekker boolsk-verdi for om et verktøy skal være gratis første dag. */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PreparedStatement ps;
        Connection con;
        PrintWriter out = response.getWriter();

        try {
            con = DBUtils.getINSTANCE().getConnection(out);
            ps = con.prepareStatement("insert into tool (Tool_toolName, Tool_description, Tool_price, ToolCategory_id, Tool_freeDayOne) values (?,?,?,?,?)");
            ps.setString(1, request.getParameter("toolName"));
            ps.setString(2, request.getParameter("toolDescription"));
            ps.setString(3, request.getParameter("toolPrice"));
            ps.setString(4, request.getParameter("toolCategory_id"));

            if (request.getParameterMap().containsKey("freeDayOne")) {
                ps.setBoolean(5, true);
            } else {
                ps.setBoolean(5, false);
            }

            /* Kjører den SQL-spørringene. */
            ps.executeUpdate();
            /* For sikkerhetssskyld lukker vi databasetilkoblingen. */
            con.close();
            /* Sender brukeren videre. */

            response.sendRedirect("success.jsp");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}

