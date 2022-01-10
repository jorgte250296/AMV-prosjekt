package servlets;

import models.FileModel;
import utils.FileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static utils.Queries.checkUser;


/* fileSizeThreshold = 1mb */
/* maxFileSize = 5mb */
/* maxRequestSize = 25mb */

@WebServlet("/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        if (checkUser(pw, session)) {
            request.getRequestDispatcher("tool-details.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("exception.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        byte[] fileBytes = fileContent.readAllBytes();

        FileModel fileModel = new FileModel(
                fileName,
                fileBytes,
                filePart.getContentType());

        FileDAO dao = new FileDAO();

        try {
            dao.persistFile(fileModel, out);
            response.sendRedirect("success.jsp");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        logger.info("Received file with name: "+fileModel.getName()+ "with the length of: "+fileModel.getContents().length+" bytes");
    }
}
