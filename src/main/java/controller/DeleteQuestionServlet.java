package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;

@WebServlet("/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        int questionId =
            Integer.parseInt(request.getParameter("questionId"));

        QuestionDAO dao = new QuestionDAO();

        dao.deleteQuestion(questionId);

        response.sendRedirect("manageQuestions");
    }
}