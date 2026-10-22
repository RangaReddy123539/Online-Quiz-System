<%@ page import="model.Student" %>

<%
    Student student = (Student) session.getAttribute("student");

    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/common.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background: #f4f6f8;
        }

        .navbar {
            background: #007bff;
            color: white;
            padding: 18px 30px;
        }

        .navbar h2 {
            display: inline;
        }

        .logout {
            float: right;
            color: white;
            text-decoration: none;
        }

        .container {
            padding: 30px;
        }

        .welcome {
            background: white;
            padding: 25px;
            border-radius: 10px;
        }

        .cards {
            display: flex;
            gap: 20px;
            margin-top: 25px;
        }

        .card {
            background: white;
            padding: 25px;
            width: 200px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 2px 8px #ddd;
        }

        .card a {
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>

<body>

<div class="navbar">
    <h2>Online Quiz System</h2>
    <a class="logout" href="login.jsp">Logout</a>
</div>

<div class="container">

    <div class="welcome">
        <h2>Welcome, <%= student.getName() %>!</h2>

        <p><strong>Email:</strong> <%= student.getEmail() %></p>
        <p><strong>Course:</strong> <%= student.getCourse() %></p>
    </div>

    <div class="cards">

        <div class="card">
            <h3>Modules</h3>
            <p>View learning modules</p>
            <a href="modules">View Modules</a>
        </div>

        <div class="card">
            <h3>Profile</h3>
            <p>View your profile</p>
            <a href="profile.jsp">Profile</a>
        </div>

        <div class="card">
            <h3>Results</h3>
            <p>View quiz results</p>
            <a href="results">My Results</a>
        </div>

    </div>

</div>

</body>
</html>