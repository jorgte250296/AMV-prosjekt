package utils;

import models.UserModel;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {
    /* Denne metoden sjekker om brukern finnes i systemet og brukes derfor på login-siden. */
    public static boolean validateUser(String phoneNumber, String password, PrintWriter out) {
        Connection db = null;
        PreparedStatement ps;

        UserModel userModel = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            ResultSet rs;
            ps = db.prepareStatement("SELECT User_phoneNumber, User_password FROM user WHERE User_phoneNumber = ? AND User_password = ?");
            /* Henter verdier fra html-form og setter dem inn i spørringen. */
            ps.setString(1, phoneNumber);
            ps.setString(2, password);
            rs = ps.executeQuery();

            /* Oppretter et objekt ut i fra UserModel-klassen. */
            while (rs.next()) {
                userModel = new UserModel();
                userModel.setPhoneNumber(rs.getString("User_phoneNumber"));
                userModel.setPassword(rs.getString("User_password"));
            }

            if (userModel != null) {
                if (userModel.getPhoneNumber().equals(phoneNumber)) {
                    return userModel.getPassword().equals(password);
                } else {
                    return false;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}


