<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    <title>Register</title>
</head>
<body>
<h2>Register</h2>

<form action="register" method="post">
    Name: <input type="text" name="name"/><br/>
    Email: <input type="text" name="email"/><br/>
    Password: <input type="password" name="password"/><br/>
    <button type="submit">Register</button>
</form>
<a href="${pageContext.request.contextPath}/login">Login Account</a>

<p style="color:red;">
    ${error}
</p>
</body>
</html>