<%@ page import="java.util.List" %>
<%@ page import="model.Module" %>

<%
    List<Module> modules =
        (List<Module>) request.getAttribute("modules");

    if (modules == null) {
        response.sendRedirect("modules");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Learning Modules</title>
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
            padding: 30px;
        }

        .module-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .module-card {
            background: white;
            width: 280px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px #ddd;
        }

        .module-card h3 {
            color: #007bff;
        }

        .category {
            color: #666;
        }

        .btn {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .empty {
            background: white;
            padding: 25px;
            border-radius: 10px;
        }
    </style>
</head>

<body>

<div class="navbar">
    <strong>Online Quiz System</strong>
    <a href="student-dashboard.jsp">Dashboard</a>
</div>

<div class="container">

    <h2>Learning Modules</h2>

    <div class="module-container">

        <%
            if (modules.isEmpty()) {
        %>

            <div class="empty">
                <h3>No modules available</h3>
                <p>Admin has not added any learning modules yet.</p>
            </div>

        <%
            } else {

                for (Module module : modules) {
        %>

            <div class="module-card">

                <h3>
                    <%= module.getModuleName() %>
                </h3>

                <p class="category">
                    <strong>Category:</strong>
                    <%= module.getCategory() %>
                </p>

                <p>
                    <%= module.getDescription() %>
                </p>

                <a class="btn"
   href="quiz?moduleId=<%= module.getModuleId() %>">
    Take Quiz
</a>

                <%
                    if (module.getPdfFilename() != null) {
                %>

                    <a class="btn"
                       href="uploads/modules/<%= module.getPdfFilename() %>"
                       target="_blank">
                        View PDF
                    </a>

                <%
                    }
                %>

            </div>

        <%
                }
            }
        %>

    </div>

</div>

</body>
</html>