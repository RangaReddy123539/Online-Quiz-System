<%
    if (session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    Integer score =
        (Integer) request.getAttribute("score");

    Integer totalQuestions =
        (Integer) request.getAttribute("totalQuestions");

    Double percentage =
        (Double) request.getAttribute("percentage");

    Integer moduleId =
        (Integer) request.getAttribute("moduleId");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Quiz Result</title>
<link rel="stylesheet" href="css/common.css">

<style>

body {
    font-family: Arial, sans-serif;
    background: #f4f6f8;
}

.container {
    width: 500px;
    margin: 80px auto;
    background: white;
    padding: 35px;
    text-align: center;
    border-radius: 12px;
    box-shadow: 0 3px 15px #ccc;
}

.score {
    font-size: 42px;
    font-weight: bold;
    margin: 20px;
}

.percentage {
    font-size: 25px;
    margin: 20px;
}

.pass {
    color: green;
    font-weight: bold;
}

.fail {
    color: red;
    font-weight: bold;
}

.btn {
    display: inline-block;
    padding: 12px 20px;
    margin: 10px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 6px;
}

</style>

</head>

<body>

<div class="container">

<h2>Quiz Result</h2>

<div class="score">

    <%= score %> /
    <%= totalQuestions %>

</div>

<div class="percentage">

    <%= String.format("%.2f", percentage) %>%

</div>

<%
    if (percentage >= 40) {
%>

    <p class="pass">
        PASSED
    </p>

<%
    } else {
%>

    <p class="fail">
        FAILED
    </p>

<%
    }
%>

<a class="btn"
   href="modules">
   Take Another Quiz
</a>

<a class="btn"
   href="results">
   View Result History
</a>

<br>

<a class="btn"
   href="student-dashboard.jsp">
   Dashboard
</a>

</div>

</body>

</html>