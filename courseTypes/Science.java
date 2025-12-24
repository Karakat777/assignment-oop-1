package courseTypes;
import models.Course;
import java.util.Objects;
public class Science extends Course {
    private int maxStudentCount;
    private int labHours;
    private boolean hasLaboratory;
    public Science(String courseName, String courseCode, int credits,
                   int enrolledStudents, int maxStudentCount,
                   int labHours, boolean hasLaboratory) {

        super(courseName, courseCode, credits, enrolledStudents);
        this.maxStudentCount = maxStudentCount;
        this.labHours = labHours;
        this.hasLaboratory = hasLaboratory;
    }
    public int getMaxStudentCount() {
        return maxStudentCount;
    }
    public void setMaxStudentCount(int maxStudentCount) {
        this.maxStudentCount = maxStudentCount;
    }
    public int getLabHours() {
        return labHours;
    }
    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }
    public boolean hasLaboratory() {
        return hasLaboratory;
    }
    public void setHasLaboratory(boolean hasLaboratory) {
        this.hasLaboratory = hasLaboratory;
    }
    @Override
    public boolean isFull() {
        return enrolledStudents >= maxStudentCount;
    }
    @Override
    public void printInfo() {
        System.out.println(courseName + " science course");
        System.out.println("Lab hours: " + labHours);
        System.out.println("Has laboratory: " + hasLaboratory);
    }
    @Override
    public String toString() {
        return "Science{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", credits=" + credits +
                ", enrolledStudents=" + enrolledStudents +
                ", maxStudentCount=" + maxStudentCount +
                ", labHours=" + labHours +
                ", hasLaboratory=" + hasLaboratory +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, credits, enrolledStudents,
                maxStudentCount, labHours, hasLaboratory);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Science science = (Science) obj;
        return maxStudentCount == science.maxStudentCount &&
                labHours == science.labHours &&
                hasLaboratory == science.hasLaboratory;}
}