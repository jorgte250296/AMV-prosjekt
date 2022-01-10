package utils;

import models.FileModel;

import javax.servlet.http.HttpServlet;
import javax.sql.rowset.serial.SerialBlob;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* Et objekt eller et grensesnitt som gir tilgang til en underliggende database eller annen varighetslagring. */
public class FileDAO extends HttpServlet {
    public void persistFile(FileModel file, PrintWriter out) throws SQLException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        con = DBUtils.getINSTANCE().getConnection(out);

        ps = con.prepareStatement("insert into files (File_name, File_content, File_contentType) values(?,?,?)");
        ps.setString(1, file.getName());
        ps.setBlob(2, new SerialBlob(file.getContents()));
        ps.setString(3, file.getContentType());
        ps.executeUpdate();
        con.close();
    }

    public static FileModel getFile(int id, PrintWriter out) throws SQLException, ClassNotFoundException {
        PreparedStatement ps;
        Connection con;
        con = DBUtils.getINSTANCE().getConnection(out);

        ps = con.prepareStatement("select File_name, File_content, File_contentType from files where File_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        FileModel model = null;

        if (rs.next()) {
            model = new FileModel(
                    rs.getString("File_name"),
                    rs.getBytes("File_content"),
                    rs.getString("File_contentType")
            );
        }

        con.close();
        return model;
    }
}
