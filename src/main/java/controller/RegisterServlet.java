package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");

        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setPhone(phone);
        student.setCourse(course);

        StudentDAO studentDAO = new StudentDAO();

        boolean status = studentDAO.registerStudent(student);

        if (status) {

            response.sendRedirect("login.jsp");

        } else {

            response.sendRedirect("register.jsp?error=Registration+Failed");
        }
    }
}