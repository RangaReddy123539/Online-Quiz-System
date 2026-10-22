package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;
import util.DBConnection;

public class AdminDAO {

    public Admin loginAdmin(String username, String password) {

        Admin admin = null;

        String sql = "SELECT ADMIN_ID, USERNAME, PASSWORD "
                   + "FROM ADMIN "
                   + "WHERE USERNAME = ? AND PASSWORD = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                admin = new Admin();

                admin.setAdminId(rs.getInt("ADMIN_ID"));
                admin.setUsername(rs.getString("USERNAME"));
                admin.setPassword(rs.getString("PASSWORD"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }
}