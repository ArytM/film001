<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index-list</title>
</head>
<body>

<a href="FilmServlet">FilmServlet</a><br>
<a href="film-form.jsp">Film-form</a><br>
<center>
    <a href="new">Add new Film</a><br>
    <a href="list">List all Film</a><br>

    <table border="2">
        <caption><h2>Список фильмов</h2></caption>
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

</center>
</body>
</html>
