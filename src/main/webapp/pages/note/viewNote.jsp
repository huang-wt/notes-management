<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="../common/meta.jsp"/>
    <title>Notes Manager App</title>
    <style>
        .main {
            height: 2000px;
            padding-top: 30px;
        }
        h2 {
            margin-top: 0;
        }
        .sidebar {
            float: left;
            height: 2000px;
        }
        button {
            background: white;
            text-decoration: underline;
            border: white;
            font-size: 16px;
            padding-bottom: 5px;
        }
        button:focus {
            font-weight: bold;
        }
        button:hover {
            font-weight: bold;
        }
        .displayNote {
            float: right;
            width: 80%;
            height: 2000px;
            background-color: azure;
        }
        .opBar {
            width: 100%;
            height: 30px;
            list-style: none;
            padding: 10px 0 0;
            margin-bottom: 0;
            margin-top: 0;
        }
        .opBar li {
            width: 16%;
            float: left;
            line-height: 45px;
            text-align: center;
        }
        .opBar button {
            text-align: center;
            font-size: 20px;
            font-family: Times;
            color: #000;
            margin: 0 auto;
            background: azure;
        }
        .note {
            margin-left: 30px;
            margin-right: 20px;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }
    </style>
</head>
<body>
    <jsp:include page="/pages/common/header.jsp"/>
    <div class="main">
        <div class="sidebar">
            <h2>Notes List:</h2>
            <form action="#">
                <button type="submit" name="order" value="sorted"> Sorted Order </button>
                <button type="submit" name="order" value="added"> Order Added </button>
            </form>
            <ul>
                <form action="#">
                    <%
                        List<String> notes = (List<String>) request.getAttribute("noteNames");
                        for (String note : notes)
                        {
                    %>
                    <li>
                        <button type="submit" name="index" value="<%=note%>"> <%=note%> </button>
                    </li>
                    <% } %>
                </form>
            </ul>
        </div>
        <div class="displayNote">
            <div>
                <ul class="opBar">
                    <li>
                        <form action="newNoteServlet" method="post">
                            <button type="submit" name="op" value="create"> New Note </button>
                        </form>
                    </li>
                    <li>
                        <form action="modifyNoteServlet" method="post">
                            <button type="submit" name="op" value="modify"> Modify </button>
                        </form>
                    </li>
                    <li>
                        <form action="deleteNoteServlet" method="post">
                            <button type="submit" name="op" value="delete"> Delete </button>
                        </form>
                    </li>
                    <li>
                        <form action="renameNoteServlet" method="post">
                            <button type="submit" name="op" value="rename"> Rename </button>
                        </form>
                    </li>
                    <li>
                        <form action="searchServlet" method="post">
                            <button type="submit" name="op" value="search"> Search </button>
                        </form>
                    </li>
                    <li>
                        <form action="../../index.jsp">
                            <button type="submit" name="op" value="home"> Home Page </button>
                        </form>
                    </li>
                </ul>
            </div>

            <div class="note">
                <%
                    String noteName;
                    if ((noteName = request.getParameter("index")) != null)
                    {
                        List<String> contents = (List<String>) request.getAttribute(noteName); %>
                <h3><%=noteName%></h3>
                <p>
                        <% for (String line : contents)
            {
              if (line.length() > 5 && "<img>".equals(line.substring(0, 5)))
              {
                String path = line.substring(5);
            %>
                <div>
                    <img src="<%=path%>" width="60%">
                </div>
                <% }
                else if (line.length() > 5 && "<url>".equals(line.substring(0, 5)))
                {
                    String path = line.substring(5);
                %>
                <p><a href="<%=path%>"><%=path%></a></p>
                <% }
                else
                { %>
                <%=line%> <br>
                <%}
                } %>
                </p>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
