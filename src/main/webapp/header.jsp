<%@ page import="java.io.PrintWriter" %>
<%@ page import="static utils.Queries.checkUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/main.css">
    <title>AMV</title>
</head>
<body>
<main>
    <header>
        <nav>
            <a href="GetToolServlet">AMV</a>
            <div>
                <%
                    PrintWriter pw = response.getWriter();
                    if (checkUser(pw, session)) {
                        out.print("<a href=\"create-user\"><img src=\"media/add-person.svg\" alt=\"create-user\">Opprett bruker</a>");
                    }
                %>
                <a href="GetToolServlet"><img src="media/tool.svg" alt="tool-logo">Verktøy</a>
                <a href="rental-information.jsp"><img src="media/article.svg" alt="article-logo">Om utleie</a>
                <a href="GetOrderTableServlet"><img src="media/profile.svg" alt="profile-logo">Min side</a>
                <a href="logout"><img src="media/logout.svg" alt="logout-logo">Logg ut</a>
                <a href="menu.jsp"><img src="media/menu.svg" alt="menu-logo"></a>
            </div>
        </nav>
    </header>

