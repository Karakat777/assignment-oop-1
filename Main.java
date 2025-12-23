import courseTypes.Math;
import courseTypes.Science;
import models.Course;
import models.Professor;
import models.University;

public class Main {
  public static void main(String[] args) {
    Course discrete = new Math("Discrete Mathematics", "DM", 20, 0, 20);
    Course chemistry = new Science("Chemistry", "CM", 20, 0, 12, 2, true);
    Professor prof1 = new Professor("Dr.John Smith", "Computer Science", 15, true);
    Professor prof2 = new Professor("Dr.Anna Lee", "Software Engineering", 8, false);
    University uni1 = new University("Stanford models.University", "California, USA", 3, 17000);
    System.out.println("UNIVERSITY SYSTEM INFO");
    uni1.printInfo();
    System.out.println();
    prof1.printInfo();
    prof2.printInfo();
    System.out.println();
    discrete.printInfo();
    System.out.println("\nCOUNT TENURED PROFESSORS");
    int tenuredCount = 0;
    if (prof1.isTenured()) {
      tenuredCount++;
    }
    if (prof2.isTenured()) {
      tenuredCount++;
    }
    System.out.println("Number of tenured professors: " + tenuredCount);
    //Java Basics
    System.out.println("\nCHECK COURSE CAPACITY");
    int maxCapacity = 40;
    boolean course1Full = discrete.isFull();
    if (course1Full) {
      System.out.println(discrete.getCourseName() + " is FULL (capacity: " + maxCapacity + ")");
    } else {
      System.out.println(discrete.getCourseName() + " has available seats.");
    }
    //Java Basics
    System.out.println("\nLOOP THROUGH COURSES");
    Course[] courses = { discrete }; // array of objects
    int totalCredits = 0;
    int maxEnrollment = 0;
    String mostPopularCourse = "";
    for (int i = 0; i < courses.length; i++) {
      int credits = courses[i].getCredits();
      int enrolled = courses[i].getEnrolledStudents();
      System.out.println("models.Course " + (i + 1) + ": " + courses[i].getCourseName()
              + " - " + credits + " credits, " + enrolled + " students");
      totalCredits += credits;
      if (enrolled > maxEnrollment) {
        maxEnrollment = enrolled;
        mostPopularCourse = courses[i].getCourseName();
      }
    }
    System.out.println("\nTotal credits for all courses: " + totalCredits);
    System.out.println("Most popular course: " + mostPopularCourse + " with " + maxEnrollment + " students");
    //Compare courses by credits
    System.out.println("\nCOURSE COMPARISON");

    if (discrete.getCredits() > chemistry.getCredits()) {
      System.out.println(discrete.getCourseName() + " has more credits than " + chemistry.getCourseName());
    } else if (chemistry.getCredits() > discrete.getCredits()) {
      System.out.println(chemistry.getCourseName() + " has more credits than " + discrete.getCourseName());
    } else {
      System.out.println("Both courses have the same number of credits.");
    }
  }

}
