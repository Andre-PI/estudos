<html>
<body>
    <h1>Welcome to the jungle</h1>
    <%
        String email = (String)session.getAttribute("email");
        String name = (String)session.getAttribute("username");
        out.println(email + " | " + name);
    %>
</body>
</html>