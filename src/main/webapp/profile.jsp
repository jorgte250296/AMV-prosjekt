<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="models.OrderTableModel" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="/header.jsp"/>
<section class="content min-side hero">
    <h2 class="title">Bestillinger</h2>
    <table>
        <tr>
            <th>Ordrenummer</th>
            <th>Dato</th>
        </tr>
        <%
            ArrayList<OrderTableModel> orderList = (ArrayList<OrderTableModel>) request.getAttribute("listOrderTable");

            for (OrderTableModel i : orderList) {
                out.println("<tr>");
                out.println("<td>" + i.getOrderTableID() + "</td>");
                out.println("<td>" + i.getOrderTable_date() + "</td>");
                out.println("</tr>");
            }
        %>
    </table>

<jsp:include page="/footer.jsp"/>
