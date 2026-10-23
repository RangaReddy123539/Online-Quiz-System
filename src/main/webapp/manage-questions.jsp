<%@ page import="java.util.List" %>
<%@ page import="model.Question" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }

    List<Question> questions =
        (List<Question>) request.getAttribute("questions");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Questions</title>
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
            padding: 10px;
        }

        th {
            background: #343a40;
            color: white;
        }

        .delete {
            background: #dc3545;
            color: white;
            padding: 6px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Manage Questions</h2>

   
</a>
    |
    <a href="add-question.jsp"><button>Add Question</button></a>

    <br><br>

    <table>

        <tr>
            <th>ID</th>
            <th>Module ID</th>
            <th>Question</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>Correct</th>
            <th>Action</th>
        </tr>

        <%
            if (questions != null) {

                for (Question q : questions) {
        %>

        <tr>

            <td><%= q.getQuestionId() %></td>

            <td><%= q.getModuleId() %></td>

            <td><%= q.getQuestionText() %></td>

            <td><%= q.getOptionA() %></td>

            <td><%= q.getOptionB() %></td>

            <td><%= q.getOptionC() %></td>

            <td><%= q.getOptionD() %></td>

            <td><%= q.getCorrectAnswer() %></td>

            <td>
                <a class="delete"
                   href="deleteQuestion?questionId=<%= q.getQuestionId() %>"
                   onclick="return confirm('Delete this question?');">
                    Delete
                </a>
            </td>

        </tr>

        <%
                }
            }
        %>

    </table>
    
    <br>
    
     <a href="admin-dashboard.jsp">
    <button style="background-color: blue;
                   color: white;
                   padding: 10px 20px;
                   border: none;
                   border-radius: 5px;
                   cursor: pointer;">
        Back to Dashboard
    </button>

</div>

</body>
</html>