package courseTypes;
import models.Course;
import java.util.Objects;
public class Math extends Course {
    private int maxStudentCount;
    public Math(String courseName, String courseCode, int credits, int enrolledStudents, int maxStudentCount) {
        super(courseName, courseCode, credits, enrolledStudents);
        this.maxStudentCount = maxStudentCount;
    }
    public int getMaxStudentCount() {
        return maxStudentCount;
    }
    public void setMaxStudentCount(int maxStudentCount) {
        this.maxStudentCount = maxStudentCount;
    }
    @Override
    public boolean isFull() {
        return this.enrolledStudents >= maxStudentCount;
    }
    @Override
    public void printInfo() {
        System.out.println(this.courseName + " course");
    }
    @Override
    public String toString() {
        return "Math{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", credits=" + credits +
                ", enrolledStudents=" + enrolledStudents +
                ", maxStudentCount=" + maxStudentCount +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, credits, enrolledStudents, maxStudentCount);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Math math = (Math) obj;
        return maxStudentCount == math.maxStudentCount;
    }
}