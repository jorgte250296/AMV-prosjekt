<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/header.jsp"/>
<section class="hero">
            <form action='fileUpload' method='POST' enctype='multipart/form-data'>
                <label for='file'>Upload a file</label>
                <input type='file' name='file'/>
                <input type='submit' class="btn" value='Upload file'/>
            </form>
</section>

<jsp:include page="/footer.jsp"/>