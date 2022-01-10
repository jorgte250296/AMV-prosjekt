<jsp:include page="/header.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.ToolModel" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="static utils.Queries.checkUser" %>

<section class="content maskiner">
    <form action="sendOrder" method="post">
        <div class="flex">
            <div class="item">
                <h2 class="title">Verktøy</h2>
                <p>Oversikt over verktøy</p>
                <%
                    ArrayList<ToolModel> toolsList = (ArrayList<ToolModel>) request.getAttribute("toolsList");
                    out.println("<select name=\"maskiner\" id=\"maskiner\">");

                    for (ToolModel i : toolsList) {
                        if (i.getToolPrice() != null) {
                            out.print("<option value=" + i.getTool_id() + ">" + i.getToolName() + " (" + i.getToolPrice() + ",-)</option>");
                        } else {
                            out.print("<option value=" + i.getTool_id() + ">" + i.getToolName() + " (0,-)" + "</option>");
                        }
                    }
                %>
                </select>
                <br>
                <br>
                <div class="flex">
                <div class="item">
                    <a href="fileDownload?id=1" class="btn">Utvidet maskinoversikt</a>
                </div>
                <div class="item">
                    <%
                        PrintWriter pw = response.getWriter();
                        if (checkUser(pw, session)) {
                            out.print("<a href=\"getCategoryServlet\" class=\"btn-ghost create-tool\"><img src=\"media/plus.svg\" alt=\"create-tool\">Opprett verktøy</a>");
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="item">
            <h2 class="title">Ordre</h2>
            <div class="flex">
                <div class="item">
                    <p>Periode fra</p>
                    <input type="date" class="calendar mono" name="fra">
                </div>
                <div class="item">
                    <p>Periode til</p>
                    <input type="date" class="calendar mono" name="til">
                </div>
            </div>

            <div class="flex betaling">
                <div class="item">
                    <div>
                        <b>Vipps</b>
                        <br>
                        <input type="checkbox" class="checkbox" checked onchange="cbChange(this)">
                    </div>
                    <div>
                        <b>Kontant</b>
                        <br>
                        <input type="checkbox" class="checkbox" onchange="cbChange(this)">
                    </div>
                </div>
                <div class="item"></div>
            </div>

            <div class="flex">
                <div class="item">
                    <button class="btn-ghost"><img src="media/add-to-cart.svg" alt="add-to-cart-icon">
                    </button>
                </div>
                <div class="item">
                    <button type="submit" class="btn"><img src="media/cart.svg  " alt="cart-icon"></button>
                </div>
            </div>
        </div>
        </div>
    </form>
</section>

<script>
    function cbChange(obj) {
        const cbs = document.getElementsByClassName("checkbox");
        for (let i = 0; i < cbs.length; i++) {
            cbs[i].checked = false;
        }
        obj.checked = true;
    }
</script>

<jsp:include page="/footer.jsp"/>