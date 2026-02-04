package courseTypes;
import models.Course;
public class Math extends Course {
    private int maxStudentCount;
    public Math(String courseCode, String courseName, int credits, int enrolledStudents, int maxStudentCount) {
        super(courseCode, courseName, credits, enrolledStudents, "Math");
        this.maxStudentCount = maxStudentCount;
    }
    @Override
    public boolean isFull() {
        return getEnrolledStudents() >= maxStudentCount;
    }
    @Override
    public void printInfo() {
        System.out.println(getCourseName() + " (MATH)");
    }
}