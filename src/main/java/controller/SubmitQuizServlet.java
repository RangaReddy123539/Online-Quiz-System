package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDAO;
import dao.ResultDAO;
import model.Question;
import model.Result;
import model.Student;

@WebServlet("/submitQuiz")
public class SubmitQuizServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Check student login
        Student student =
                (Student) session.getAttribute("student");

        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String moduleIdString =
                request.getParameter("moduleId");

        if (moduleIdString == null ||
            moduleIdString.isEmpty()) {

            response.sendRedirect("modules");
            return;
        }

        int moduleId =
                Integer.parseInt(moduleIdString);

        // Get questions
        QuestionDAO questionDAO =
                new QuestionDAO();

        List<Question> questions =
                questionDAO.getQuestionsByModule(moduleId);

        int score = 0;

        // Compare answers
        for (Question question : questions) {

            String parameterName =
                    "question_" +
                    question.getQuestionId();

            String studentAnswer =
                    request.getParameter(parameterName);

            if (studentAnswer != null &&
                studentAnswer.equalsIgnoreCase(
                    question.getCorrectAnswer())) {

                score++;
            }
        }

        int totalQuestions =
                questions.size();

        double percentage = 0;

        if (totalQuestions > 0) {

            percentage =
                ((double) score /
                 totalQuestions) * 100;
        }

        // Create Result object
        Result result = new Result();

        result.setStudentId(
                student.getStudentId());

        result.setModuleId(moduleId);

        result.setScore(score);

        result.setTotalQuestions(
                totalQuestions);

        result.setPercentage(percentage);

        // Save result
        ResultDAO resultDAO =
                new ResultDAO();

        boolean saved =
                resultDAO.addResult(result);

        if (saved) {

            request.setAttribute(
                    "score", score);

            request.setAttribute(
                    "totalQuestions",
                    totalQuestions);

            request.setAttribute(
                    "percentage",
                    percentage);

            request.setAttribute(
                    "moduleId",
                    moduleId);

            request.getRequestDispatcher(
                    "result.jsp")
                   .forward(request, response);

        } else {

            response.sendRedirect(
                    "quiz?moduleId=" + moduleId);
        }
    }
}