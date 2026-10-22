package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Student;
import util.DBConnection;

public class StudentDAO 
{

    public boolean registerStudent(Student student) {

        String sql = "INSERT INTO STUDENT "
                   + "(STUDENT_ID, NAME, EMAIL, PASSWORD, PHONE, COURSE) "
                   + "VALUES (STUDENT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try {

            System.out.println("=== REGISTRATION STARTED ===");

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("Database connection is NULL!");
                return false;
            }

            System.out.println("Database connection successful!");

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getCourse());

            System.out.println("Executing INSERT...");

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            ps.close();
            con.close();

            if (rows > 0) {
                System.out.println("=== REGISTRATION SUCCESSFUL ===");
                return true;
            }

        } catch (Exception e) {

            System.out.println("=== REGISTRATION ERROR ===");
            e.printStackTrace();
        }

        return false;
    }


public Student loginStudent(String email, String password) {

    Student student = null;

    String sql = "SELECT STUDENT_ID, NAME, EMAIL, PASSWORD, PHONE, COURSE "
               + "FROM STUDENT "
               + "WHERE EMAIL = ? AND PASSWORD = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);

        java.sql.ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            student = new Student();

            student.setStudentId(rs.getInt("STUDENT_ID"));
            student.setName(rs.getString("NAME"));
            student.setEmail(rs.getString("EMAIL"));
            student.setPassword(rs.getString("PASSWORD"));
            student.setPhone(rs.getString("PHONE"));
            student.setCourse(rs.getString("COURSE"));
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return student;
}
}