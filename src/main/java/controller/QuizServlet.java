package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import model.Question;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Check student login
        if (request.getSession().getAttribute("student") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String moduleIdString = request.getParameter("moduleId");

        if (moduleIdString == null || moduleIdString.isEmpty()) {
            response.sendRedirect("modules");
            return;
        }

        int moduleId = Integer.parseInt(moduleIdString);

        QuestionDAO dao = new QuestionDAO();

        List<Question> questions =
                dao.getQuestionsByModule(moduleId);

        request.setAttribute("questions", questions);
        request.setAttribute("moduleId", moduleId);

        request.getRequestDispatcher("quiz.jsp")
               .forward(request, response);
    }
}