<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>index-list</title>
    <%--
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
          --%>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css" />

</head>
<body>

<a href="index.jsp">main page</a><br>
<div>Login: <%=session.getAttribute("name") %> </div>
<a href="logout">Logout</a><br>


<center>
    <a href="new">Add new Film</a><br>
    <a href="list">List all Film</a><br>


    <form action="index" method="post">
        <caption><h2>Список фильмов</h2></caption>
    <table border="2">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Year</th>
            <th>Rating</th>
            <th width="50%">Comment</th>

            <th>Action</th>
        </tr>
        <c:forEach var="film" items="${listFilm}">
            <tr>
                <td><c:out value="${film.id}"/></td>
                <td><c:out value="${film.name}"/></td>
                <td><c:out value="${film.year}"/></td>
                <td><c:out value="${film.rating}"/></td>
                <td><c:out value="${film.comment}"/></td>

                <td><a href="edit?id=<c:out value='${film.id}' />">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="delete?id=<c:out value='${film.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    </form>
</center>
</body>
</html>
