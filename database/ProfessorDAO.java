package database;

import models.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IProfessorDAO {

    @Override
    public List<Professor> getTenuredProfessors() { // Проверь это имя
        List<Professor> list = new ArrayList<>();
        String sql = "SELECT * FROM professors";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Professor p = new Professor(
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getInt("years_of_experience"),
                        rs.getBoolean("is_tenured")
                );
                p.setId(rs.getInt("id"));
                list.add(p);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public boolean addProfessor(Professor p) { // Проверь это имя
        String sql = "INSERT INTO professors (name, specialty, years_of_experience, is_tenured) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getSpecialty());
            pstmt.setInt(3, p.getYearsOfExperience());
            pstmt.setBoolean(4, p.isTenured());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    public boolean updateProfessor(Professor p) { // Проверь это имя
        String sql = "UPDATE professors SET name = ?, specialty = ?, years_of_experience = ?, is_tenured = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getSpecialty());
            pstmt.setInt(3, p.getYearsOfExperience());
            pstmt.setBoolean(4, p.isTenured());
            pstmt.setInt(5, p.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    public boolean deleteProfessor(int id) { // Проверь это имя
        String sql = "DELETE FROM professors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
}