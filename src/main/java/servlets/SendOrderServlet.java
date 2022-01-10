package servlets;

import utils.DBUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static utils.Queries.getLastID;
import static utils.Queries.getUserID;

/* Servlet for å leie et verktøy. */
@WebServlet("/sendOrder")
public class SendOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        /* Oppretter objektet con ut ifra Connection-klassen */
        Connection con;
        PreparedStatement ps;

        try {
            /* Oppretter database-tilkobling.
             * Sjekker hvilken bruker som er logget inn.
             * Forbereder database for å sql-spørring.
             * Binder verdier/henter id fra bruker i user-tabell. */
            con = DBUtils.getINSTANCE().getConnection(out);
            HttpSession session = request.getSession();
            ps = con.prepareStatement("insert into AMV.orderTable (User_id, OrderTable_date) values (?,?)");
            ps.setInt(1, getUserID(out, session));

            /* Oppretter et dato-objekt for å kunne sette dato for når en ordre blir opprettet. */
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date_joined = sdf.format(date);
            ps.setString(2, date_joined);

            /* Oppretter orderTable med bruker-id og dato. */
            ps.executeUpdate();

            /* Oppretter orderItem, hvilket verktøy som blir leid og tilhørende leieperiode. */
            ps = con.prepareStatement("insert into AMV.orderItem (tool_id, OrderTable_id, datefrom, dateTo) values (?,?,?,?)");
            ps.setString(1, request.getParameter("maskiner"));
            ps.setInt(2, getLastID(out));
            ps.setDate(3, java.sql.Date.valueOf(request.getParameter("fra")));
            ps.setDate(4, java.sql.Date.valueOf(request.getParameter("til")));
            /* Utfører sql-spørring. */
            ps.executeUpdate();

            /* Oppdaterer verktøy-status fra tilgjengelig til ikke tilgjengelig. */
            ps = con.prepareStatement("update tool set tool.ToolStatus_id = ? where tool.Tool_id = ?");
            ps.setString(1, "2");
            ps.setString(2, request.getParameter("maskiner"));
            ps.executeUpdate();

            /* Sender bruker til siden hvor man kan leie verktøy. */
            response.sendRedirect("GetToolServlet");
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}

