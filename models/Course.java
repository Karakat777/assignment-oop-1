package models;
import java.util.Objects;
public abstract class Course {
    //Attributes
    protected String courseName;
    protected String courseCode;
    protected int credits;
    protected int enrolledStudents;
    //Constructors
    public Course() {
    }
    public Course(String courseName, String courseCode, int credits, int enrolledStudents) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.enrolledStudents = enrolledStudents;
    }
    //Getters and Setters
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public int getEnrolledStudents() {
        return enrolledStudents;
    }
    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    //Concrete methods
    public void addStudent() {
        enrolledStudents++;
    }
    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }
    //Abstract methods
    public abstract void printInfo();
    public abstract boolean isFull();
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", credits=" + credits +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, credits, enrolledStudents);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return credits == course.credits &&
                enrolledStudents == course.enrolledStudents &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseCode, course.courseCode);
    }
}