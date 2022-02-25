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
    <input type="text" name="password"
           placeholder="password"/><br>
    <input type="text" name="firstname"
           placeholder="firstname"/><br>
    <input type="text" name="secondname"
           placeholder="secondname"/><br>
    <input type="text" name="repassword"
    placeholder="repassword"/><br>
    <button>Registration</button>
    <a href="/login">login</a>
</form>
</body>
</html>