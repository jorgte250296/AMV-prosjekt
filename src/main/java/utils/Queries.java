package utils;

import models.CategoryModel;
import models.OrderTableModel;
import models.ToolModel;
import models.UserModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* Klasse med metoder som inneholder  sql-spørringer. */
public class Queries extends HttpServlet {

    /* Metode for å hente ut verktøy.
     * Setter tilgjengelig verktøy i en ArrayList. */
    public static ArrayList<ToolModel> getTool(PrintWriter out) {
        Connection db = null;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);

            ArrayList<ToolModel> toolList = new ArrayList<>();

            PreparedStatement ps = db.prepareStatement("update tool join orderItem on tool.Tool_id = orderItem.Tool_id set tool.ToolStatus_id = 1 where current_date >= orderItem.DateTo");
            ps.executeUpdate();

            PreparedStatement statement = db.prepareStatement("select Tool_id, Tool_toolName, Tool_description, Tool_price, tool.ToolCategory_id, ToolCategory, ToolStatus_id from AMV.tool inner join AMV.toolCategory on tool.ToolCategory_id = toolCategory.ToolCategory_id where ToolStatus_id = 1");
            ResultSet rs = statement.executeQuery();
            ToolModel model = null;

            /* Hvis listen har et til verktøy, opprettet objektet og legg til i toolList (array-listen). */
            while (rs.next()) {
                CategoryModel categoryModel = new CategoryModel(rs.getString("ToolCategory"), rs.getInt("ToolCategory_id"));

                model = new ToolModel(rs.getInt("Tool_id"), rs.getString("Tool_toolName"), rs.getString("Tool_description"), rs.getBigDecimal("Tool_price"),
                        rs.getShort("ToolStatus_id"), categoryModel);

                toolList.add(model);
            }

            return toolList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* Metode for å hente alle ordre på en bruker. */
    public static ArrayList<OrderTableModel> listOrderTable(PrintWriter out, HttpServletRequest request) {
        HttpSession session = request.getSession();
        /* Setter databasetilkobling til null og forbereder sql-spørring. */
        Connection db = null;
        PreparedStatement ps = null;
        /* Oppretter arraylist for å kunne holde på ordre. */
        ArrayList<OrderTableModel> listOrderTable = new ArrayList<>();

        try {

            db = DBUtils.getINSTANCE().getConnection(out);
            /* Henter telefonnummer innlogget bruker. */
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            String query = "select orderTable.orderTable_id, user.User_id, orderItem.Tool_id, user.User_phoneNumber, orderTable.OrderTable_date from AMV.orderTable join AMV.user on user.User_id = orderTable.User_id join AMV.orderItem on orderItem.OrderTable_id = orderTable.OrderTable_id where User_phoneNumber = ? order by OrderTable_date desc";
            ps = db.prepareStatement(query);
            /* Setter telefonnummer inn i spørring. */
            ps.setString(1, phoneNumber);
            ResultSet rs;
            rs = ps.executeQuery();

            /* Lister alle ordre på en bruker, while sjekker om det er flere ordre.. */
            while (rs.next()) {
                UserModel userModel = new UserModel(rs.getInt("User_id"));
                ToolModel toolModel = new ToolModel(rs.getInt("Tool_id"));

                OrderTableModel order = new OrderTableModel(rs.getInt("OrderTable_id"), rs.getDate("OrderTable_date"), userModel, toolModel);
                listOrderTable.add(order);
            }
            rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            /* Lukker databasetilkobling. */
        } finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOrderTable;
    }

    public static ArrayList<CategoryModel> categoryList(PrintWriter out) {
        Connection db;
        PreparedStatement ps;

        ArrayList<CategoryModel> categoryList = new ArrayList<>();

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            ps = db.prepareStatement("select * from AMV.toolCategory");
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoryModel categoryModel = new CategoryModel(rs.getString("ToolCategory"), rs.getInt("ToolCategory_id"));
                categoryList.add(categoryModel);
            }

            rs.close();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categoryList;
    }


    /* Sjekker om brukeren har admin-tilgang ved å sjekke telefonnummer og User_isAdmin. */
    public static boolean checkUser(PrintWriter out, HttpSession session) {
        Connection db;
        PreparedStatement ps;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            ps = db.prepareStatement("select User_isAdmin from AMV.user where User_phoneNumber = ?");
            ps.setString(1, phoneNumber);
            ResultSet rs;
            rs = ps.executeQuery();
            rs.next();

            if (rs.getString("User_isAdmin").equals("1")) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    /* Henter bruker-id basert på telefonnummer. */
    public static int getUserID(PrintWriter out, HttpSession session) {
        Connection db;
        PreparedStatement ps;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            ps = db.prepareStatement("select User_id from AMV.user where User_phoneNumber = ?");
            ps.setString(1, phoneNumber);
            ResultSet rs;
            rs = ps.executeQuery();
            rs.next();

            /* Konverterer String til int. */
            return Integer.parseInt(rs.getString("User_id"));

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }

    /* Henter største OrderTable_id fra orderTable, metoden brukes i SendOrder. */
    public static int getLastID(PrintWriter out) {
        Connection db;
        PreparedStatement ps;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            ps = db.prepareStatement("select max(OrderTable_id) as id from AMV.orderTable");
            ResultSet rs;
            rs = ps.executeQuery();
            rs.next();

            return Integer.parseInt(rs.getString("id"));


        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }
}



