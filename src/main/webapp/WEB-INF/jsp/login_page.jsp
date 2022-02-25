<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
${message}<br>
<form method ="post" action="/login">
    <input type="text" name="email"
    placeholder="email"/><br>
    <input type="text" name="password"
    placeholder="password"><br>
    <button>Login</button>
    <a href="/registration">registration</a>
</form>
</body>
</html>