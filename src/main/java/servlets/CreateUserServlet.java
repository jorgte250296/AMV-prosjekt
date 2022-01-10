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

import static utils.Encryption.encrypt;
import static utils.Queries.checkUser;

/* Servlet for å opprette en ny bruker. */
@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

    /* PrintWriter-klassen muligjør å skrive ut tekst istedenfor byte-kode.
     * doGet sjekker om bruker er administrator*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        if (checkUser(pw, session)) {
            getServletContext().getRequestDispatcher("/add-user.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("exception.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            PreparedStatement ps;
            Connection con;
            PrintWriter out = response.getWriter();
            con = DBUtils.getINSTANCE().getConnection(out);

            ps = con.prepareStatement("insert into AMV.user (User_firstName, User_lastName, User_phoneNumber, User_password, User_isAdmin) values (?,?,?,?,?)");

            if (request.getParameter("firstName").isEmpty() || request.getParameter("lastName").isEmpty() || request.getParameter("phoneNumber").isEmpty() || request.getParameter("password").isEmpty()) {
                return;
            }

            ps.setString(1, request.getParameter("firstName"));
            ps.setString(2, request.getParameter("lastName"));
            ps.setString(3, request.getParameter("phoneNumber"));
            ps.setString(4, encrypt(request.getParameter("password")));

            if (request.getParameterMap().containsKey("isAdmin")) {
                ps.setBoolean(5, true);
            } else {
                ps.setBoolean(5, false);
            }

            ps.executeUpdate();
            con.close();

            response.sendRedirect("success.jsp");

        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}
