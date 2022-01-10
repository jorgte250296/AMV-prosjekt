package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static utils.Queries.listOrderTable;

/* Henter alle ordre. */
@WebServlet("/GetOrderTableServlet")
public class GetOrderTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /* listOrderTable-metoden inneholder en arraylist med ordre (ligger i Queries). */
        request.setAttribute("listOrderTable", listOrderTable(out, request));
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
