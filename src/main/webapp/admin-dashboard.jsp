<%@ page import="model.Admin" %>

<%
    Admin admin = (Admin) session.getAttribute("admin");

    if (admin == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
<link rel="stylesheet" href="css/common.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background: #f4f6f8;
        }

        .navbar {
            background: #343a40;
            color: white;
            padding: 18px 30px;
        }

        .navbar a {
            float: right;
            color: white;
            text-decoration: none;
        }

        .container {
            padding: 30px;
        }

        .cards {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 30px;
        }

        .card {
            background: white;
            width: 250px;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 8px #ddd;
            text-align: center;
        }

        .card a {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<div class="navbar">
    <strong>Admin Panel - Online Quiz System</strong>
    <a href="admin-login.jsp">Logout</a>
</div>

<div class="container">

    <h2>Welcome, <%= admin.getUsername() %>!</h2>

    <div class="cards">

        <div class="card">
            <h3>Add Module</h3>
            <p>Create a new learning module.</p>
            <a href="add-module.jsp">Add Module</a>
        </div>

        <div class="card">
            <h3>Manage Modules</h3>
            <p>Update or delete modules.</p>
            <a href="manageModules">Manage</a>
        </div>

        <div class="card">
            <h3>Add Questions</h3>
            <p>Add questions to modules.</p>
            <a href="add-question.jsp">Add Questions</a>
        </div>

        <div class="card">
            <h3>Manage Questions</h3>
            <p>Update or delete questions.</p>
            <a href="manageQuestions">Manage</a>
        </div>

        <div class="card">
            <h3>Student Results</h3>
            <p>View student quiz results.</p>
            <a href="viewResults">View Results</a>
        </div>

    </div>

</div>

</body>
</html>