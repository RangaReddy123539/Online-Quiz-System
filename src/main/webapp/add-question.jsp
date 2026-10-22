<%@ page import="java.util.List" %>
<%@ page import="model.Module" %>
<%@ page import="dao.ModuleDAO" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }

    ModuleDAO moduleDAO = new ModuleDAO();

    List<Module> modules = moduleDAO.getAllModules();
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Add Question</title>
    <link rel="stylesheet" href="css/common.css">

    <style>

        body {
            font-family: Arial;
            background: #f4f6f8;
        }

        .container {
            width: 550px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ddd;
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, textarea, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .warning {
            color: red;
            text-align: center;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Add Question</h2>

    <%
        if (modules == null || modules.isEmpty()) {
    %>

        <p class="warning">
            No modules available.
        </p>

        <p>
            Please add a module first.
        </p>

        <a href="add-module.jsp">
            Add Module
        </a>

    <%
        } else {
    %>

    <form action="addQuestion" method="post">

        <label>Select Module</label>

        <select name="moduleId" required>

            <option value="">
                -- Select Module --
            </option>

            <%
                for (Module module : modules) {
            %>

                <option value="<%= module.getModuleId() %>">

                    <%= module.getModuleName() %>

                </option>

            <%
                }
            %>

        </select>


        <label>Question</label>

        <textarea
            name="questionText"
            rows="4"
            placeholder="Enter question"
            required>
        </textarea>


        <label>Option A</label>

        <input
            type="text"
            name="optionA"
            required>


        <label>Option B</label>

        <input
            type="text"
            name="optionB"
            required>


        <label>Option C</label>

        <input
            type="text"
            name="optionC"
            required>


        <label>Option D</label>

        <input
            type="text"
            name="optionD"
            required>


        <label>Correct Answer</label>

        <select name="correctAnswer" required>

            <option value="">
                -- Select Correct Answer --
            </option>

            <option value="A">A</option>

            <option value="B">B</option>

            <option value="C">C</option>

            <option value="D">D</option>

        </select>


        <button type="submit">
            Add Question
        </button>

    </form>

    <%
        }
    %>

    <br>

    <a href="admin-dashboard.jsp">
        ← Back to Dashboard
    </a>

</div>

</body>

</html>