<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Modify Note</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div>
  <h2>Modify Note</h2>
  <form action="#">
    <%
      String noteName = (String) request.getSession().getAttribute("index");
      List<String> contents = (List<String>) request.getAttribute(noteName);
    %>
    <h3><%=noteName%></h3>
<textarea name="modifiedContent" rows="30" cols="100">
<% for (String line : contents)
{ %><%=line%>
<% } %>
</textarea> <br> <br>
    <input type="submit" value="Save">
  </form>
  <form action="viewNote.html">
    <input type="submit" value="Back">
  </form>
</div>
</body>
</html>
