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

@WebServlet("/viewResults")
public class ViewResultsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
  

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        ResultDAO dao = new ResultDAO();

        List<Result> results =
            dao.getAllResults();
      

        request.setAttribute("results", results);

        request.getRequestDispatcher("view-results.jsp")
               .forward(request, response);
    }
}