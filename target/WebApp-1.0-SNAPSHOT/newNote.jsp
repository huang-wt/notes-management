<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes Manager App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div>
  <h2>Create New Note</h2>
  <form action="#">
    <label for="noteName">Name the note: </label>
    <%
      String noteName;
      if ((noteName = (String) request.getSession().getAttribute("newIndex")) != null)
      { %>
        <input type="text" name="noteName" id="noteName" value="<%=noteName%>"> <br> <br>
      <% }
      else
      { %>
        <input type="text" name="noteName" id="noteName"> <br> <br>
      <% } %>
<textarea name="noteContent" rows="30" cols="100">
<%List<String> contents;
if (noteName != null && !"".equals(noteName) && (contents = (List<String>) request.getAttribute(noteName)) != null)
{for (String line : contents)
{ %><%=line%>
<% } } %>
</textarea> <br> <br>
    <input type="submit" value="Save">
  </form>
  <form action="viewNote.html">
    <input type="submit" value="Back">
  </form>
</div>
</body>
</html>
