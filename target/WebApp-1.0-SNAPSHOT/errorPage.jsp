<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes Manager App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div>
  <form action="viewNote.html">
    <% String msg = (String) request.getSession().getAttribute("msg"); %>
    <%=msg%>
    <input type="submit" value="Back">
  </form>
</div>
</body>
</html>
