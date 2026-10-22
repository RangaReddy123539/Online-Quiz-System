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

@WebServlet("/modules")
public class ModuleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        ModuleDAO moduleDAO = new ModuleDAO();

        List<Module> modules = moduleDAO.getAllModules();

        request.setAttribute("modules", modules);

        request.getRequestDispatcher("modules.jsp")
               .forward(request, response);
    }
}