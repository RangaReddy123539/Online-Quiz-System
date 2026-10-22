package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import util.DBConnection;

public class QuestionDAO {

    public boolean addQuestion(Question question) {

        String sql = "INSERT INTO QUESTION "
                   + "(QUESTION_ID, MODULE_ID, QUESTION_TEXT, "
                   + "OPTION_A, OPTION_B, OPTION_C, OPTION_D, "
                   + "CORRECT_ANSWER) "
                   + "VALUES (QUESTION_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, question.getModuleId());
            ps.setString(2, question.getQuestionText());
            ps.setString(3, question.getOptionA());
            ps.setString(4, question.getOptionB());
            ps.setString(5, question.getOptionC());
            ps.setString(6, question.getOptionD());
            ps.setString(7, question.getCorrectAnswer());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Question> getAllQuestions() {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT QUESTION_ID, MODULE_ID, QUESTION_TEXT, "
                   + "OPTION_A, OPTION_B, OPTION_C, OPTION_D, "
                   + "CORRECT_ANSWER "
                   + "FROM QUESTION ORDER BY QUESTION_ID DESC";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Question q = new Question();

                q.setQuestionId(rs.getInt("QUESTION_ID"));
                q.setModuleId(rs.getInt("MODULE_ID"));
                q.setQuestionText(rs.getString("QUESTION_TEXT"));
                q.setOptionA(rs.getString("OPTION_A"));
                q.setOptionB(rs.getString("OPTION_B"));
                q.setOptionC(rs.getString("OPTION_C"));
                q.setOptionD(rs.getString("OPTION_D"));
                q.setCorrectAnswer(rs.getString("CORRECT_ANSWER"));

                questions.add(q);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public List<Question> getQuestionsByModule(int moduleId) {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT QUESTION_ID, MODULE_ID, QUESTION_TEXT, "
                   + "OPTION_A, OPTION_B, OPTION_C, OPTION_D, "
                   + "CORRECT_ANSWER "
                   + "FROM QUESTION "
                   + "WHERE MODULE_ID = ? "
                   + "ORDER BY QUESTION_ID";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, moduleId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Question q = new Question();

                q.setQuestionId(rs.getInt("QUESTION_ID"));
                q.setModuleId(rs.getInt("MODULE_ID"));
                q.setQuestionText(rs.getString("QUESTION_TEXT"));
                q.setOptionA(rs.getString("OPTION_A"));
                q.setOptionB(rs.getString("OPTION_B"));
                q.setOptionC(rs.getString("OPTION_C"));
                q.setOptionD(rs.getString("OPTION_D"));
                q.setCorrectAnswer(rs.getString("CORRECT_ANSWER"));

                questions.add(q);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public boolean deleteQuestion(int questionId) {

        String sql = "DELETE FROM QUESTION WHERE QUESTION_ID = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, questionId);

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