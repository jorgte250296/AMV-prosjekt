package servlets;

import models.FileModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import static utils.FileDAO.getFile;


@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);

        PrintWriter out = response.getWriter();

        try {
            FileModel fileModel = getFile(id, out);
            writeFileResult(response, fileModel);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    protected void writeFileResult(HttpServletResponse response, FileModel model) throws IOException {
        response.setContentType(model.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename=" + model.getName());
        OutputStream outStream = response.getOutputStream();
        outStream.write(model.getContents());
    }
}
