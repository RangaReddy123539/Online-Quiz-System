<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Online Quiz System</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: white;
            width: 500px;
            padding: 40px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0,0,0,0.25);
        }

        h1 {
            margin-bottom: 10px;
            color: #333;
        }

        .subtitle {
            color: #666;
            margin-bottom: 35px;
        }

        .options {
            display: flex;
            gap: 20px;
            justify-content: center;
        }

        .card {
            width: 190px;
            padding: 25px 15px;
            border: 1px solid #ddd;
            border-radius: 12px;
            text-decoration: none;
            color: #333;
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }

        .icon {
            font-size: 45px;
            margin-bottom: 15px;
        }

        .card h2 {
            margin: 10px 0;
        }

        .card p {
            color: #777;
            font-size: 14px;
        }

        .student {
            border-top: 5px solid #007bff;
        }

        .admin {
            border-top: 5px solid #28a745;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>Online Quiz System</h1>

    <p class="subtitle">
        Please select your role to continue
    </p>

    <div class="options">

        <!-- Student -->

        <a href="login.jsp" class="card student">

            <div class="icon">🎓</div>

            <h2>Student</h2>

            <p>
                Login or register to access
                modules and quizzes.
            </p>

        </a>


        <!-- Admin -->

        <a href="admin-login.jsp" class="card admin">

            <div class="icon">👨‍💼</div>

            <h2>Admin</h2>

            <p>
                Login to manage modules,
                questions and results.
            </p>

        </a>

    </div>

</div>

</body>

</html>