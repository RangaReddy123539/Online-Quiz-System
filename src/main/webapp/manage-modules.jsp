<%@ page import="java.util.List" %>
<%@ page import="model.Module" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }

    List<Module> modules =
        (List<Module>) request.getAttribute("modules");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Modules</title>
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
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background: #343a40;
            color: white;
        }

        .delete {
            color: white;
            background: #dc3545;
            padding: 7px 10px;
            text-decoration: none;
            border-radius: 4px;
        }

        .pdf {
            color: white;
            background: #28a745;
            padding: 7px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Manage Modules</h2>

    <a href="admin-dashboard.jsp">← Dashboard</a>
    <br><br>

    <a href="add-module.jsp">+ Add New Module</a>

    <br><br>

    <table>

        <tr>
            <th>ID</th>
            <th>Module</th>
            <th>Category</th>
            <th>Description</th>
            <th>PDF</th>
            <th>Action</th>
        </tr>

        <%
            if (modules != null) {

                for (Module module : modules) {
        %>

        <tr>

            <td><%= module.getModuleId() %></td>

            <td><%= module.getModuleName() %></td>

            <td><%= module.getCategory() %></td>

            <td><%= module.getDescription() %></td>

            <td>
                <%
                    if (module.getPdfFilename() != null) {
                %>

                    <a class="pdf"
                       href="uploads/modules/<%= module.getPdfFilename() %>"
                       target="_blank">
                        View PDF
                    </a>

                <%
                    } else {
                %>

                    No PDF

                <%
                    }
                %>
            </td>

            <td>
                <a class="delete"
                   href="deleteModule?moduleId=<%= module.getModuleId() %>"
                   onclick="return confirm('Delete this module?');">
                    Delete
                </a>
            </td>

        </tr>

        <%
                }
            }
        %>

    </table>

</div>

</body>
</html>