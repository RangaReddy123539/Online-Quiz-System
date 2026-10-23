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
    <title>Add Module</title>
    <link rel="stylesheet" href="css/common.css">

    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
        }

        .container {
            width: 500px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            color: white;
            border: none;
        }

        .error {
            color: red;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Add Learning Module</h2>

    <%
        String error = request.getParameter("error");

        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <%
        }
    %>

    <form action="addModule"
          method="post"
          enctype="multipart/form-data">

        <label>Module Name</label>
        <input type="text"
               name="moduleName"
               required>

        <label>Description</label>
        <textarea name="description"
                  rows="5"
                  required></textarea>

        <label>Category</label>
        <input type="text"
               name="category"
               required>

        <label>Module PDF</label>
        <input type="file"
               name="pdf"
               accept=".pdf"
               required>

        <button type="submit">
            Add Module
        </button>

    </form>

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