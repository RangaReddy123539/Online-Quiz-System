package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Module;
import util.DBConnection;

public class ModuleDAO {

    public List<Module> getAllModules() {

        List<Module> modules = new ArrayList<>();

        String sql = "SELECT MODULE_ID, MODULE_NAME, DESCRIPTION, "
                   + "CATEGORY, PDF_FILENAME, PDF_PATH, CREATED_DATE, ADMIN_ID "
                   + "FROM MODULE ORDER BY MODULE_ID DESC";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Module module = new Module();

                module.setModuleId(rs.getInt("MODULE_ID"));
                module.setModuleName(rs.getString("MODULE_NAME"));
                module.setDescription(rs.getString("DESCRIPTION"));
                module.setCategory(rs.getString("CATEGORY"));
                module.setPdfFilename(rs.getString("PDF_FILENAME"));
                module.setPdfPath(rs.getString("PDF_PATH"));
                module.setCreatedDate(rs.getDate("CREATED_DATE"));
                module.setAdminId(rs.getInt("ADMIN_ID"));

                modules.add(module);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modules;
    }

    public boolean addModule(Module module) {

        String sql = "INSERT INTO MODULE "
                   + "(MODULE_ID, MODULE_NAME, DESCRIPTION, CATEGORY, "
                   + "PDF_FILENAME, PDF_PATH, ADMIN_ID) "
                   + "VALUES (MODULE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, module.getModuleName());
            ps.setString(2, module.getDescription());
            ps.setString(3, module.getCategory());
            ps.setString(4, module.getPdfFilename());
            ps.setString(5, module.getPdfPath());
            ps.setInt(6, module.getAdminId());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteModule(int moduleId) {

        String sql = "DELETE FROM MODULE WHERE MODULE_ID = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, moduleId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}