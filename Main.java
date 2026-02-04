import database.DatabaseConnection;
import database.ProfessorDAO;
import database.CourseDAO;
import database.UniversityDAO;
import models.Course;
import models.Professor;
import models.University;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (!DatabaseConnection.testConnection()) return;

    UniversityDAO uniDAO = new UniversityDAO();
    uniDAO.getAllUniversities().forEach(University::printInfo);
    uniDAO.updateRanking("Stanford University", 2);

    ProfessorDAO profDAO = new ProfessorDAO();
    Professor newProf = new Professor("Dr. Alan Turing", "Cryptography", 20, true);
    if (profDAO.addProfessor(newProf)) {
      System.out.println("Professor added successfully");
    } else {
      System.out.println("Professor already exists");
    }
    profDAO.getTenuredProfessors().forEach(System.out::println);

    CourseDAO courseDAO = new CourseDAO();
    List<Course> courses = courseDAO.getAllCourses();
    for (Course c : courses) {
      c.printInfo();
      System.out.println("Full: " + c.isFull());
    }
  }
}