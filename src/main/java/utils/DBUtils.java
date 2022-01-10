package utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Klasse for databasetilkobling.
 *  MariaDB Connector brukes til å koble applikasjonen i Java til MariaDB- og MySQL-databaser ved å bruke standard JDBC (Java Database Connectivity) API. */
public class DBUtils {
    private static final DBUtils INSTANCE = new DBUtils();
    public static Connection connection;

    public static DBUtils getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection(PrintWriter out) throws SQLException, ClassNotFoundException {
        Connection toReturn = null;
        Class.forName("org.mariadb.jdbc.Driver");
        try {
            toReturn = (connection != null)
                    ? connection
                    : DriverManager.getConnection(
                    "jdbc:mariadb://172.17.0.1:3308/AMV",
                    "root",
                    "12345");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("SQL Exception " + e);
        }
        return toReturn;
    }
}



