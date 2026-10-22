package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModuleDAO;

@WebServlet("/deleteModule")
public class DeleteModuleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        int moduleId =
            Integer.parseInt(request.getParameter("moduleId"));

        ModuleDAO dao = new ModuleDAO();

        dao.deleteModule(moduleId);

        response.sendRedirect("manageModules");
    }
}