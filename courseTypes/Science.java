package courseTypes;

import models.Course;
import java.util.Objects;

public class Science extends Course {
    private int maxStudentCount;
    private int labHours;
    private boolean hasLaboratory;

    public Science(String courseCode, String courseName, int credits, int enrolledStudents,
                   int maxStudentCount, int labHours, boolean hasLaboratory) {
        super(courseCode, courseName, credits, enrolledStudents, "Science");
        this.maxStudentCount = maxStudentCount;
        this.labHours = labHours;
        this.hasLaboratory = hasLaboratory;
    }

    @Override
    public boolean isFull() {
        return getEnrolledStudents() >= maxStudentCount;
    }

    @Override
    public void printInfo() {
        System.out.println(getCourseName() + " (SCIENCE), Lab: " + labHours + "h");
    }

    // hashCode и equals оставляем как были
}