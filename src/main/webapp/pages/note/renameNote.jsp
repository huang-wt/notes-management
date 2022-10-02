<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/pages/common/meta.jsp"/>
    <title>Notes Manager App</title>
</head>
<body>
    <jsp:include page="/pages/common/header.jsp"/>
    <div>
        <h2>Rename Note</h2>
        <form action="renameNoteServlet" method="post">
            <%
                String noteName = (String) request.getSession().getAttribute("index");
            %>
            <%
                String newName;
                if ((newName = request.getParameter("newName")) != null && !"".equals(newName))
                {
            %>
            <p>Note name is successfully changed to <%=newName%>...</p>
            <% }
            else
            { %>
            <label for="rename">Enter a new name for <%=noteName%>: </label> &nbsp;
            <input type="text" name="newName" id="rename"> &nbsp;
            <input type="submit" value="Submit">
            <% } %>
        </form>
        <form action="viewNoteServlet" method="post">
            <input type="submit" value="Back">
        </form>
    </div>
</body>
</html>