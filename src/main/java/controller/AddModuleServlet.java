package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ModuleDAO;
import model.Admin;
import model.Module;

@WebServlet("/addModule")
@MultipartConfig(
    maxFileSize = 10 * 1024 * 1024,
    maxRequestSize = 20 * 1024 * 1024
)
public class AddModuleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Admin admin = (Admin) session.getAttribute("admin");

        if (admin == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }

        String moduleName = request.getParameter("moduleName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Part pdfPart = request.getPart("pdf");

        String fileName = null;

        if (pdfPart != null && pdfPart.getSize() > 0) {

            fileName = new File(
                pdfPart.getSubmittedFileName()
            ).getName();

            String uploadPath =
                getServletContext().getRealPath("/uploads/modules");

            File uploadFolder = new File(uploadPath);

            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }

            pdfPart.write(
                uploadFolder.getAbsolutePath()
                + File.separator
                + fileName
            );
        }

        Module module = new Module();

        module.setModuleName(moduleName);
        module.setDescription(description);
        module.setCategory(category);
        module.setPdfFilename(fileName);

        if (fileName != null) {
            module.setPdfPath(
                "uploads/modules/" + fileName
            );
        } else {
            module.setPdfPath(null);
        }

        module.setAdminId(admin.getAdminId());

        ModuleDAO dao = new ModuleDAO();

        boolean status = dao.addModule(module);

        if (status) {

            response.sendRedirect("manageModules");

        } else {

            response.sendRedirect(
                "add-module.jsp?error=Module+Not+Added"
            );
        }
    }
}