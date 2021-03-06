<%@ page import="models.ToolModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.CategoryModel" %>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<jsp:include page="/header.jsp"/>
<section class="hero">
    <form method="post" action="create-tool">
        <h2 class="title">Opprett verktøy</h2>
        <div>
            <label>Navn</label>
            <input type="text" name="toolName" required autofocus>
        </div>

        <div>
            <label>Beskrivelse</label>
            <input type="text" name="toolDescription" required>
        </div>

        <div>
            <label>Kategori</label>
                <%
                    ArrayList<CategoryModel> categoryModel = (ArrayList<CategoryModel>) request.getAttribute("categoryList");
                    out.println("<select name=\"toolCategory_id\" required id=\"categoryList\">");

                    for (CategoryModel i : categoryModel) {
                        out.print("<option value=\"" + i.getCategoryID() + "\">" +  i.getCategory() + "</option>");
                    }

                    out.print("</select>");
                %>
        </div>

        <div>
            <label>Pris</label>
            <input type="number" name="toolPrice" required>
        </div>

        <div>
            <label>Gratis første dag?</label>
            <input type="checkbox" name="freeDayOne">
        </div>

        <button type="submit" class="btn">Opprett verktøy</button>
    </form>

    <jsp:include page="/footer.jsp"/>
