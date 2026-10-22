package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import model.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.loginStudent(email, password);

        if (student != null) {

            HttpSession session = request.getSession();

            session.setAttribute("student", student);

            response.sendRedirect("student-dashboard.jsp");

        } else {

            response.sendRedirect("login.jsp?error=Invalid+Email+or+Password");
        }
    }
}