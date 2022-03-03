<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration
    </title>
</head>
<body>
${message}<br>
<form method="post" action="/registration">
    <input type="text" name="email"
    placeholder="email"/><br>
    <input type="password" name="password"
           placeholder="password"/><br>
    <input type="password" name="repassword"
           placeholder="repassword"/><br>
    <input type="text" name="firstname"
    placeholder="firstname"/><br>
    <input type="text" name="secondname"
    placeholder="secondname"/><br>
    <button>Registration</button>
    <a href="/login">login</a>
</form>
</body>
</html>