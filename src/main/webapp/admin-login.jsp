<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="css/common.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
        }

        .container {
            width: 350px;
            margin: 80px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
            text-align: center;
        }

        .home {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Admin Login</h2>

    <%
        String error = request.getParameter("error");

        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <%
        }
    %>

    <form action="adminLogin" method="post">

        <label>Username</label>

        <input type="text"
               name="username"
               placeholder="Enter username"
               required>

        <label>Password</label>

        <input type="password"
               name="password"
               placeholder="Enter password"
               required>

        <button type="submit">
            Login
        </button>

    </form>

    <div class="home">
        <a href="index.jsp">Back to Home</a>
    </div>

</div>

</body>
</html>