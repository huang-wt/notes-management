<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes Manager App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div>
  <h2>Delete Note</h2>
  <form action="#">
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
        <span>Do you want to delete <strong><%=noteName%></strong> ?</span>
        &nbsp; &nbsp; <input type="checkbox" name="option" id="yes" value="yes">
        <label for="yes">Yes</label>
        &nbsp; <input type="checkbox" name="option" id="no" value="no">
        <label for="no">No</label>
        &nbsp; &nbsp; <input type="submit" value="Submit">
      <% } %>
  </form>
  <form action="viewNote.html">
    <input type="submit" value="Back">
  </form>
</div>
</body>
</html>
