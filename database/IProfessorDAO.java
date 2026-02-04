package database;

import models.Professor;
import java.util.List;

public interface IProfessorDAO {
    List<Professor> getTenuredProfessors();
    boolean addProfessor(Professor professor);
}