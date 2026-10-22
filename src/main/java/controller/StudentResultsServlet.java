package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultDAO;
import model.Result;
import model.Student;

@WebServlet("/results")
public class StudentResultsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Student student =
                (Student) request.getSession()
                                 .getAttribute("student");

        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        ResultDAO dao =
                new ResultDAO();

        List<Result> results =
                dao.getResultsByStudent(
                        student.getStudentId());

        request.setAttribute(
                "results",
                results);

        request.getRequestDispatcher(
                "results.jsp")
               .forward(request, response);
    }
}