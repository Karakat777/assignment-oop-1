package database;

import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements ICourseDAO {

    @Override
    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Course c = new Course(
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        rs.getInt("credits"),
                        rs.getInt("enrolled_students"),
                        rs.getString("course_type")
                );
                c.setId(rs.getInt("id"));
                list.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO courses (course_code, course_name, credits, enrolled_students, course_type) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.getCourseCode());
            pstmt.setString(2, course.getCourseName());
            pstmt.setInt(3, course.getCredits());
            pstmt.setInt(4, course.getEnrolledStudents());
            pstmt.setString(5, course.getCourseType() != null ? course.getCourseType() : "General");
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    @Override
    public boolean deleteCourse(String code) {
        String sql = "DELETE FROM courses WHERE course_code = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}