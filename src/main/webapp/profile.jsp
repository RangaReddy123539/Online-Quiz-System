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
    <title>My Profile</title>
    <link rel="stylesheet" href="css/common.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            margin: 0;
        }

        .navbar {
            background: #007bff;
            color: white;
            padding: 18px 30px;
        }

        .navbar a {
            float: right;
            color: white;
            text-decoration: none;
        }

        .container {
            width: 500px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ddd;
        }

        h2 {
            text-align: center;
        }

        .profile-item {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        .label {
            font-weight: bold;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 25px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>

<body>

<div class="navbar">
    <strong>Online Quiz System</strong>
    <a href="student-dashboard.jsp">Dashboard</a>
</div>

<div class="container">

    <h2>My Profile</h2>

    <div class="profile-item">
        <span class="label">Student ID:</span>
        <%= student.getStudentId() %>
    </div>

    <div class="profile-item">
        <span class="label">Name:</span>
        <%= student.getName() %>
    </div>

    <div class="profile-item">
        <span class="label">Email:</span>
        <%= student.getEmail() %>
    </div>

    <div class="profile-item">
        <span class="label">Phone:</span>
        <%= student.getPhone() %>
    </div>

    <div class="profile-item">
        <span class="label">Course:</span>
        <%= student.getCourse() %>
    </div>

    <a href="student-dashboard.jsp">
    <button style="background-color: blue;
                   color: white;
                   padding: 10px 20px;
                   border: none;
                   border-radius: 5px;
                   cursor: pointer;">
        Back to Dashboard
    </button>
</a>
</div>

</body>
</html>