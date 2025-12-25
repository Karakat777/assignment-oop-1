import courseTypes.Math;
import courseTypes.Science;
import models.Course;
import models.Professor;
import models.University;
import java.util.ArrayList;
import java.util.List;
public class Main {
  public static void main(String[] args) {

    Course discrete = new Math("Discrete Mathematics", "DM", 20, 5, 20);
    Course chemistry = new Science("Chemistry", "CM", 25, 10, 12, 2, true);
    Course calculus = new Math("Calculus", "CALC", 15, 12, 30);
    List<Course> courses = new ArrayList<>();
    courses.add(discrete);
    courses.add(chemistry);
    courses.add(calculus);
    System.out.println("UNIVERSITY SYSTEM INFO");
    University uni1 = new University("Stanford University", "California, USA", 3, 17000);
    uni1.printInfo();
    System.out.println();
    String searchCode = "CM";
    for (Course c : courses) {
      if (c.getCourseCode().equals(searchCode)) {
        System.out.println("Found: " + c.getCourseName() + " (Code: " + searchCode + ")");
      }
    }

    for (int i = 0; i < courses.size() - 1; i++) {
      for (int j = 0; j < courses.size() - i - 1; j++) {
        if (courses.get(j).getCredits() > courses.get(j + 1).getCredits()) {
          Course temp = courses.get(j);
          courses.set(j, courses.get(j + 1));
          courses.set(j + 1, temp);
        }
      }
    }
    for (Course c : courses) {
      System.out.println(c.getCourseName() + " - " + c.getCredits() + " credits");
    }
    for (Course c : courses) {
      if (!c.isFull()) {
        System.out.println(c.getCourseName() + " has available seats.");
      }
    }
    System.out.println("\nCOUNT TENURED PROFESSORS");
    Professor prof1 = new Professor("Dr.John Smith", "Computer Science", 15, true);
    Professor prof2 = new Professor("Dr.Anna Lee", "Software Engineering", 8, false);
    int tenuredCount = (prof1.isTenured() ? 1 : 0) + (prof2.isTenured() ? 1 : 0);
    System.out.println("Number of tenured professors: " + tenuredCount);
  }
}