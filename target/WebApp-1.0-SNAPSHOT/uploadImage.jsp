<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="./meta.jsp"/>
  <title>Notes Manager App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div>
  <form action="/ImageUploading/UploadImage" method="post" enctype="multipart/form-data">
    Select Image to Upload:<input type="file" name="photo">
    <br>
    <input type="submit" value="Upload">
  </form>
</div>

</body>
</html>
