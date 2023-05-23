<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>user-registration</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row text-center">
        <h2>User Registration with JSP, Servlet and Hibernate</h2>
    </div>
    <br>
    <div class="row col-md-10 col-md-offset-3">

        <div class="card card-body">

            <h2>User Register Form</h2>
            <div class="col-md-8 col-md-offset-3">

                <form action="register" method="post">

                    <div class="form-group">
                        <label for="uname">First Name:</label>
                        <input type="text" class="form-control" id="uname" placeholder="First Name" name="firstName"
                               required="required">
                    </div>

                    <div class="form-group">
                        <label for="uname">Last Name:</label>
                        <input type="text" class="form-control" id="lastname" placeholder="last Name" name="lastName"
                               required="required">
                    </div>

                    <div class="form-group">
                        <label for="uname">User email:</label>
                        <input type="text"
                               class="form-control" id="username" placeholder="User email" name="userEmail"
                               required="required">
                    </div>

                    <div class="form-group">
                        <label for="uname">Password:</label>
                        <input type="password"
                               class="form-control" id="password" placeholder="Password" name="password"
                               required="required">
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>
        </div>
    </div>
</div>
<br><br>
<div>
    <h2>
        <a href="login.jsp"> I`am have account, go login </a>
    </h2>
</div>
</body>
</html>