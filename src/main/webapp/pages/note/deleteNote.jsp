<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/pages/common/meta.jsp"/>
    <title>Notes Manager App</title>
</head>
<body>
    <jsp:include page="/pages/common/header.jsp"/>
    <div>
        <h2>Delete Note</h2>
        <form action="deleteNoteServlet" method="post">
            <%
                String noteName = (String) request.getSession().getAttribute("index");
            %>

            <%
                if ("yes".equals(request.getParameter("option")))
                {
            %>
            <p><strong><%=noteName%></strong> is successfully deleted...</p>
            <% }
            else
            { %>
            <span>Do you want to delete <strong><%=noteName%></strong> ?&nbsp; &nbsp; </span>
            <input type="checkbox" name="option" id="yes" value="yes">
            <label for="yes">Yes&nbsp; </label>
            <input type="checkbox" name="option" id="no" value="no">
            <label for="no">No&nbsp; &nbsp; </label>
            <input type="submit" value="Submit">
            <% } %>
        </form>
        <form action="viewNoteServlet" method="post">
            <input type="submit" value="Back">
        </form>
    </div>
</body>
</html>
