package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModuleDAO;
import model.Module;

@WebServlet("/manageModules")
public class ManageModulesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        ModuleDAO dao = new ModuleDAO();

        List<Module> modules = dao.getAllModules();

        request.setAttribute("modules", modules);

        request.getRequestDispatcher("manage-modules.jsp")
               .forward(request, response);
    }
}