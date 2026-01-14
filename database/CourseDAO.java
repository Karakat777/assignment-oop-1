package database;

import courseTypes.Math;
import courseTypes.Science;
import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("course_type");
                if ("MATH".equals(type)) {
                    courses.add(new Math(rs.getString("course_name"), rs.getString("course_code"), rs.getInt("credits"), rs.getInt("enrolled_students"), rs.getInt("max_student_count")));
                } else {
                    courses.add(new Science(rs.getString("course_name"), rs.getString("course_code"), rs.getInt("credits"), rs.getInt("enrolled_students"), rs.getInt("max_student_count"), rs.getInt("lab_hours"), rs.getBoolean("has_laboratory")));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return courses;
    }
}