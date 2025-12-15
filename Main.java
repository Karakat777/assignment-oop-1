//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    //Create objects (instances of classes)
    Course course1 = new Course("Object-Oriented Programming", "CS201", 4, 35);
    Course course2 = new Course("Data Structures", "CS202", 3, 28);
    Course course3 = new Course("Database Systems", "CS301", 4, 42);
    Professor prof1 = new Professor("Dr.John Smith", "Computer Science", 15, true);
    Professor prof2 = new Professor("Dr.Anna Lee", "Software Engineering", 8, false);
    University uni1 = new University("Stanford University", "California, USA", 3, 17000);
    //Print all objects info
    System.out.println("UNIVERSITY SYSTEM INFO");
    uni1.printInfo();
    System.out.println();
    prof1.printInfo();
    prof2.printInfo();
    System.out.println();
    course1.printInfo();
    course2.printInfo();
    course3.printInfo();

    System.out.println("\nCOUNT TENURED PROFESSORS");
    int tenuredCount = 0; // int variable
    if (prof1.isTenured()) {
      tenuredCount++;
    }
    if (prof2.isTenured()) {
      tenuredCount++;
    }
    System.out.println("Number of tenured professors: " + tenuredCount);
    //Java Basics—check course capacity
    System.out.println("\nCHECK COURSE CAPACITY");
    int maxCapacity = 40;
    boolean course1Full = course1.isFull(maxCapacity);
    if (course1Full) {
      System.out.println(course1.getCourseName() + " is FULL (capacity: " + maxCapacity + ")");
    } else {
      System.out.println(course1.getCourseName() + " has available seats.");
    }
    //Java Basics-array + for loop
    System.out.println("\nLOOP THROUGH COURSES");
    Course[] courses = { course1, course2, course3 }; // array of objects
    int totalCredits = 0;
    int maxEnrollment = 0;
    String mostPopularCourse = "";
    for (int i = 0; i < courses.length; i++) {
      int credits = courses[i].getCredits();
      int enrolled = courses[i].getEnrolledStudents();
      System.out.println("Course " + (i + 1) + ": " + courses[i].getCourseName()
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
    int courseComparison = course1.compareCredits(course2);
    if (courseComparison > 0) {
      System.out.println(course1.getCourseName() + " has more credits than " + course2.getCourseName());
    } else if (courseComparison <0) {
      System.out.println(course2.getCourseName() + " has more credits than " + course1.getCourseName());
    } else {
      System.out.println("Both courses have the same number of credits.");
    }
  }
}