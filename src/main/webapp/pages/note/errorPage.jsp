<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/pages/common/meta.jsp"/>
    <title>Notes Manager App</title>
</head>
<body>
    <jsp:include page="/pages/common/header.jsp"/>
    <div>
        <form action="viewNoteServlet" method="post">
            <% String msg = (String) request.getSession().getAttribute("msg"); %>
            <label> <%=msg%> </label>
            <input type="submit" value="Back">
        </form>
    </div>
</body>
</html>
