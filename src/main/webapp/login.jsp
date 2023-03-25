<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login-page</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<a href="user-registration.jsp" class="signup-image-link">Create new account</a><br>

<h2 class="form-title">Sign IN</h2>

<%-- action="<%=request.getContextPath()%>/login"
отвечает за валидацию email, password --%>

<form method="post" action="<%=request.getContextPath()%>/login" class="register-form" id="login-form">
    <div class="form-group">
        <label for="email"></label>
        <input type="text" name="email" id="email" placeholder="email" required="required"/>
    </div>
    <div class="form-group">
        <label for="password"></label> <input
            type="password" name="password" id="password"
            placeholder="Password" required="required"/>
    </div>

    <div>
        <input type="submit" name="signin" id="signin"
               class="form-submit" value="Submit"/>
    </div>
</form>


</body>

</html>
