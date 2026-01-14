package database;

import models.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public boolean addProfessor(Professor professor) {
        String sql = "INSERT INTO professors (name, specialty, years_of_experience, is_tenured) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, professor.getName());
            pstmt.setString(2, professor.getSpecialty());
            pstmt.setInt(3, professor.getYearsOfExperience());
            pstmt.setBoolean(4, professor.isTenured());
            if (pstmt.executeUpdate() > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) professor.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public Professor getProfessorById(int id) {
        String sql = "SELECT * FROM professors WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return extract(rs);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Professor> getTenuredProfessors() {
        List<Professor> list = new ArrayList<>();
        String sql = "SELECT * FROM professors WHERE is_tenured = true";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) list.add(extract(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateProfessor(Professor p) {
        String sql = "UPDATE professors SET name=?, specialty=?, years_of_experience=?, is_tenured=? WHERE id=?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getSpecialty());
            pstmt.setInt(3, p.getYearsOfExperience());
            pstmt.setBoolean(4, p.isTenured());
            pstmt.setInt(5, p.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    private Professor extract(ResultSet rs) throws SQLException {
        Professor p = new Professor(rs.getString("name"), rs.getString("specialty"), rs.getInt("years_of_experience"), rs.getBoolean("is_tenured"));
        p.setId(rs.getInt("id"));
        return p;
    }
}