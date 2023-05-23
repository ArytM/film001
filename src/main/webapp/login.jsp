<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login-page</title>
    <%--    <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
     --%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css" />
</head>
<body>

<div class="center">
    <a class="font1" href="user-registration-form.jsp">Create new account</a>
</div>
<div class="center">
    <h2>Sign IN</h2>
</div>

<%-- action="<%=request.getContextPath()%>/login"
отвечает за валидацию email, password --%>

<form method="post" action="<%=request.getContextPath()%>/login" id="login-form">
    <dib  class="center">
        <div>
            <label for="email"></label>
            <input type="text" name="email" id="email" placeholder="email" required="required"/>
        </div>
        <div>
            <label for="password"></label> <input
                type="password" name="password" id="password"
                placeholder="Password" required="required"/>
        </div>

        <div>
            <input type="submit" name="signin" id="signin" value="Submit"/>
        </div>
    </dib>
</form>


</body>

</html>
