<%@ page import="java.util.List" %>
<%@ page import="model.Question" %>

<%
    if (session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Question> questions =
        (List<Question>) request.getAttribute("questions");

    Integer moduleId =
        (Integer) request.getAttribute("moduleId");

    if (questions == null) {
        response.sendRedirect("modules");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Take Quiz</title>
<link rel="stylesheet" href="css/common.css">
<style>

body {
    font-family: Arial, sans-serif;
    background: #f4f6f8;
    margin: 0;
}

.container {
    width: 800px;
    margin: 40px auto;
    background: white;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 3px 15px #ccc;
}

h2 {
    text-align: center;
    color: #333;
}

.question {
    margin-top: 25px;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
}

.question-text {
    font-weight: bold;
    font-size: 18px;
    margin-bottom: 15px;
}

.option {
    margin: 10px 0;
}

.option label {
    cursor: pointer;
}

.submit-btn {
    width: 100%;
    padding: 14px;
    margin-top: 30px;
    background: #007bff;
    color: white;
    border: none;
    border-radius: 6px;
    font-size: 17px;
    cursor: pointer;
}

.submit-btn:hover {
    background: #0056b3;
}

.back {
    display: block;
    text-align: center;
    margin-top: 20px;
}

.no-question {
    text-align: center;
    color: red;
    padding: 30px;
}

</style>

</head>

<body>

<div class="container">

<h2>Module Quiz</h2>

<%
    if (questions.isEmpty()) {
%>

    <div class="no-question">

        <h3>No Questions Available</h3>

        <p>
            Admin has not added questions for this module yet.
        </p>

        <a href="modules">← Back to Modules</a>

    </div>

<%
    } else {
%>

<form action="submitQuiz" method="post">

    <!-- Module ID -->
    <input type="hidden"
           name="moduleId"
           value="<%= moduleId %>">

<%
    int questionNumber = 1;

    for (Question question : questions) {
%>

    <div class="question">

        <div class="question-text">

            <%= questionNumber %>.
            <%= question.getQuestionText() %>

        </div>

        <div class="option">

            <label>

                <input type="radio"
                       name="question_<%= question.getQuestionId() %>"
                       value="A"
                       required>

                A. <%= question.getOptionA() %>

            </label>

        </div>

        <div class="option">

            <label>

                <input type="radio"
                       name="question_<%= question.getQuestionId() %>"
                       value="B">

                B. <%= question.getOptionB() %>

            </label>

        </div>

        <div class="option">

            <label>

                <input type="radio"
                       name="question_<%= question.getQuestionId() %>"
                       value="C">

                C. <%= question.getOptionC() %>

            </label>

        </div>

        <div class="option">

            <label>

                <input type="radio"
                       name="question_<%= question.getQuestionId() %>"
                       value="D">

                D. <%= question.getOptionD() %>

            </label>

        </div>

    </div>

<%
        questionNumber++;
    }
%>

    <button type="submit" class="submit-btn">
        Submit Quiz
    </button>

</form>

<%
    }
%>

<a class="back" href="modules">
    ← Back to Modules
</a>

</div>

</body>

</html>