package models;
public class Course {
    private int id;
    private String courseCode;
    private String courseName;
    private int credits;
    private int enrolledStudents;
    private String courseType;
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = 0;
        this.courseType = "General";
    }
    public Course(String courseCode, String courseName, int credits, int enrolledStudents, String courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.enrolledStudents = enrolledStudents;
        this.courseType = courseType;
    }
    public boolean isFull() {
        return false;
    }
    public void printInfo() {
        System.out.println("Course: " + courseName);
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public int getEnrolledStudents() { return enrolledStudents; }
    public String getCourseType() { return courseType; }
}