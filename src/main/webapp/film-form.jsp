<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Form-create-film</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<a href="FilmServlet">FilmServlet</a><br>
<a href="film-form.jsp">Film-form</a><br>
<center>
    <a href="new">Add new Film</a><br>
    <a href="list">List all Film</a><br>

    <c:if test="${film !=null}">
        <form action="update" method="post">
    </c:if>
    <c:if test="${film == null}">
    <form action="insert" method="post">
        </c:if>

        <table border="2">
            <caption>
                <h2>
                    <c:if test="${film !=null}">
                        Edit Film
                    </c:if>
                    <c:if test="${film == null}">
                        Add new Film
                    </c:if>
                </h2>
            </caption>
            <c:if test="${film !=null}">
                <input type="hidden" name="id" value="<c:out value='${film.id}' />"/>
            </c:if>
            <tr>
                <th>Film name:</th>
                <td>
                    <input type="text" name="name" size="50"
                           value="<c:out value='${film.name}' />">
                </td>
            </tr>
            <tr>
                <th>Film year:</th>
                <td>
                    <input type="text" name="year" size="50"
                           value="<c:out value='${film.year}' />"/>
                </td>
            </tr>
            <tr>
                <th>Film rating:</th>
                <td>
                    <input type="text" name="rating" size="50"
                           value="<c:out value='${film.rating}' />"/>
                </td>
            </tr>
            <tr>
                <th>Film comment:</th>
                <td>
                    <input type="text" name="comment" size="50"
                           value="<c:out value='${film.comment}' />"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>



