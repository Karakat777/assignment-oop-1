package database;

import models.University;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO {

    public List<University> getAllUniversities() {
        List<University> list = new ArrayList<>();
        String sql = "SELECT * FROM universities";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                University uni = new University(
                        rs.getString("university_name"),
                        rs.getString("location"),
                        rs.getInt("world_ranking"),
                        rs.getInt("total_students")
                );
                uni.setId(rs.getInt("id"));
                list.add(uni);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addUniversity(University u) {
        String sql = "INSERT INTO universities (university_name, location, world_ranking, total_students) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getUniversityName());
            pstmt.setString(2, u.getLocation());
            pstmt.setInt(3, u.getWorldRanking());
            pstmt.setInt(4, u.getTotalStudents());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUniversity(University u) {
        String sql = "UPDATE universities SET university_name = ?, location = ?, world_ranking = ?, total_students = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getUniversityName());
            pstmt.setString(2, u.getLocation());
            pstmt.setInt(3, u.getWorldRanking());
            pstmt.setInt(4, u.getTotalStudents());
            pstmt.setInt(5, u.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateRanking(String name, int newRanking) {
        String sql = "UPDATE universities SET world_ranking = ? WHERE university_name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newRanking);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUniversity(String name) {
        String sql = "DELETE FROM universities WHERE university_name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}