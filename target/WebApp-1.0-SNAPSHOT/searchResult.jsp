<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes Manager App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<String> noteNames = (List<String>) request.getAttribute("result");
    if (noteNames.size() !=0)
    {
    %>
    <ul>
      <%
        for (String noteName : noteNames)
        {
      %>
      <li><a href="viewNote.html?index=<%=noteName%>#"><%=noteName%></a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
</div>
</body>
</html>