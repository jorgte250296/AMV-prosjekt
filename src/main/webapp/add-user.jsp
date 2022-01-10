<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/header.jsp"/>
<section class="hero">
    <form method="post" action="create-user">
        <h2 class="title">Opprett bruker</h2>
        <div>
            <label>Fornavn</label>
            <input type="text" name="firstName" required autofocus>
        </div>
        <div>
            <label>Etternavn</label>
            <input type="text" name="lastName" required>
        </div>
        <div>
            <label>Telefonnummer</label>
            <input type="tel" name="phoneNumber" required>
        </div>
        <div>
            <label>Passord</label>
            <input type="password" name="password" required>
        </div>
        <div>
            <label>Admin?</label>
            <input type="checkbox" name="isAdmin">
        </div>
        <button type="submit" class="btn">Opprett bruker</button>
    </form>

    <jsp:include page="/footer.jsp"/>
