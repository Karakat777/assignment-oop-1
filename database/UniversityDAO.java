package database;

import models.University;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO {
    public List<University> getAllUniversities() {
        List<University> list = new ArrayList<>();
        String sql = "SELECT * FROM universities";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new University(rs.getString("university_name"), rs.getString("location"), rs.getInt("world_ranking"), rs.getInt("total_students")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void updateRanking(String name, int newRanking) {
        String sql = "UPDATE universities SET world_ranking = ? WHERE university_name = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, newRanking);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}