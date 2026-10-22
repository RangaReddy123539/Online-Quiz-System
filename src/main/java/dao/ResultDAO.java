package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import util.DBConnection;

public class ResultDAO {

	public List<Result> getAllResults() {

	    List<Result> results = new ArrayList<>();

	    String sql =
	        "SELECT r.RESULT_ID, "
	      + "r.STUDENT_ID, "
	      + "s.NAME AS STUDENT_NAME, "
	      + "r.MODULE_ID, "
	      + "r.SCORE, "
	      + "r.TOTAL_QUESTIONS, "
	      + "r.PERCENTAGE, "
	      + "r.ATTEMPT_DATE "
	      + "FROM RESULT r "
	      + "JOIN STUDENT s "
	      + "ON r.STUDENT_ID = s.STUDENT_ID "
	      + "ORDER BY r.ATTEMPT_DATE DESC";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Result result = new Result();

	            result.setResultId(
	                    rs.getInt("RESULT_ID"));

	            result.setStudentId(
	                    rs.getInt("STUDENT_ID"));

	            result.setStudentName(
	                    rs.getString("STUDENT_NAME"));

	            result.setModuleId(
	                    rs.getInt("MODULE_ID"));

	            result.setScore(
	                    rs.getInt("SCORE"));

	            result.setTotalQuestions(
	                    rs.getInt("TOTAL_QUESTIONS"));

	            result.setPercentage(
	                    rs.getDouble("PERCENTAGE"));

	            result.setAttemptDate(
	                    rs.getDate("ATTEMPT_DATE"));

	            results.add(result);
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return results;
	}
    public List<Result> getResultsByStudent(int studentId) {

        List<Result> results = new ArrayList<>();

        String sql =
            "SELECT r.RESULT_ID, r.STUDENT_ID, s.NAME, "
          + "r.MODULE_ID, r.SCORE, r.TOTAL_QUESTIONS, "
          + "r.PERCENTAGE, r.ATTEMPT_DATE "
          + "FROM RESULT r "
          + "JOIN STUDENT s ON r.STUDENT_ID = s.STUDENT_ID "
          + "WHERE r.STUDENT_ID = ? "
          + "ORDER BY r.ATTEMPT_DATE DESC";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Result result = new Result();

                result.setResultId(
                        rs.getInt("RESULT_ID"));

                result.setStudentId(
                        rs.getInt("STUDENT_ID"));

                result.setStudentName(
                        rs.getString("NAME"));

                result.setModuleId(
                        rs.getInt("MODULE_ID"));

                result.setScore(
                        rs.getInt("SCORE"));

                result.setTotalQuestions(
                        rs.getInt("TOTAL_QUESTIONS"));

                result.setPercentage(
                        rs.getDouble("PERCENTAGE"));

                result.setAttemptDate(
                        rs.getDate("ATTEMPT_DATE"));

                results.add(result);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
    
    public boolean addResult(Result result) {

        String sql =
            "INSERT INTO RESULT "
          + "(RESULT_ID, STUDENT_ID, MODULE_ID, SCORE, "
          + "TOTAL_QUESTIONS, PERCENTAGE) "
          + "VALUES "
          + "(RESULT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, result.getStudentId());
            ps.setInt(2, result.getModuleId());
            ps.setInt(3, result.getScore());
            ps.setInt(4, result.getTotalQuestions());
            ps.setDouble(5, result.getPercentage());

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