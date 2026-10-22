package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import model.Question;

@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        int moduleId =
            Integer.parseInt(request.getParameter("moduleId"));

        String questionText =
            request.getParameter("questionText");

        String optionA =
            request.getParameter("optionA");

        String optionB =
            request.getParameter("optionB");

        String optionC =
            request.getParameter("optionC");

        String optionD =
            request.getParameter("optionD");

        String correctAnswer =
            request.getParameter("correctAnswer");

        Question question = new Question();

        question.setModuleId(moduleId);
        question.setQuestionText(questionText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setCorrectAnswer(correctAnswer);

        QuestionDAO dao = new QuestionDAO();

        boolean status = dao.addQuestion(question);

        if (status) {
            response.sendRedirect("manageQuestions");
        } else {
            response.sendRedirect(
                "add-question.jsp?error=Question+Could+Not+Be+Added"
            );
        }
    }
}