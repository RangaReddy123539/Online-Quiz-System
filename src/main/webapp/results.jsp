<%@ page import="java.util.List" %>
<%@ page import="model.Result" %>

<%
    if (session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Result> results =
        (List<Result>) request.getAttribute("results");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Results</title>
<link rel="stylesheet" href="css/common.css">

<style>

body {
    font-family: Arial, sans-serif;
    background: #f4f6f8;
}

.container {
    width: 900px;
    margin: 40px auto;
    background: white;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 3px 15px #ccc;
}

h2 {
    text-align: center;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 25px;
}

th, td {
    padding: 12px;
    border: 1px solid #ddd;
    text-align: center;
}

th {
    background: #007bff;
    color: white;
}

.back {
    display: inline-block;
    margin-top: 20px;
}

</style>

</head>

<body>

<div class="container">

<h2>My Quiz Results</h2>

<%
    if (results == null || results.isEmpty()) {
%>

    <p style="text-align:center;">
        You have not attempted any quiz yet.
    </p>

<%
    } else {
%>

<table>

<tr>
    <th>Student Name</th>
    <th>Student Id</th>
    <th>Module ID</th>
    <th>Score</th>
    <th>Total</th>
    <th>Percentage</th>
    <th>Date</th>
</tr>

<%
    for (Result result : results) {
%>

<tr>

    <td>
        <%= result.getResultId() %>
    </td>
        <td><%= result.getStudentName() %></td>

    <td>
        <%= result.getModuleId() %>
    </td>

    <td>
        <%= result.getScore() %>
    </td>

    <td>
        <%= result.getTotalQuestions() %>
    </td>

    <td>
        <%= String.format(
                "%.2f",
                result.getPercentage()) %>%
    </td>

    <td>
        <%= result.getAttemptDate() %>
    </td>

</tr>

<%
    }
%>

</table>

<%
    }
%>

<a class="back"
   href="student-dashboard.jsp">
   ← Back to Dashboard
</a>

</div>

</body>

</html>