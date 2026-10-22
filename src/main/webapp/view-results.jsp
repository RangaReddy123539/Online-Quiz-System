<%@ page import="java.util.List" %>
<%@ page import="model.Result" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }

    List<Result> results =
        (List<Result>) request.getAttribute("results");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Results</title>
    <link rel="stylesheet" href="css/common.css">

    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            margin: 0;
        }

        .container {
            padding: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background: #343a40;
            color: white;
        }

        .score {
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Student Quiz Results</h2>

    <a href="admin-dashboard.jsp">← Dashboard</a>

    <br><br>

   <table border="1" cellpadding="10" cellspacing="0" width="100%">

    <tr>
        <th>Result ID</th>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Module ID</th>
        <th>Score</th>
        <th>Total Questions</th>
        <th>Percentage</th>
        <th>Attempt Date</th>
    </tr>

    <%
        if (results != null && !results.isEmpty()) {

            for (Result result : results) {
    %>

    <tr>

        <td>
            <%= result.getResultId() %>
        </td>

        <td>
            <%= result.getStudentId() %>
        </td>

        <td>
            <%= result.getStudentName() %>
        </td>

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
            <%= String.format("%.2f",
                    result.getPercentage()) %>%
        </td>

        <td>
            <%= result.getAttemptDate() %>
        </td>

    </tr>

    <%
            }

        } else {
    %>

    <tr>
        <td colspan="8" style="text-align:center;">
            No student results available.
        </td>
    </tr>

    <%
        }
    %>

</table>

</div>

</body>
</html>