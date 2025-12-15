public class Course {
    //Attributes
    private String courseName;
    private String courseCode;
    private int credits;
    private int enrolledStudents;
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
    //Methods
    public void addStudent() {
        this.enrolledStudents++;
    }
    public void removeStudent() {
        if (this.enrolledStudents > 0) {
            this.enrolledStudents--;
        }
    }
    public boolean isFull(int maxCapacity) {
        return this.enrolledStudents >= maxCapacity;
    }

    public void printInfo() {
        System.out.println("Course → " + courseName + " (" + courseCode + "), Credits: "
                + credits + ", Enrolled: " + enrolledStudents);
    }
    //Compare two courses by credits
    public int compareCredits(Course other) {
        return Integer.compare(this.credits, other.credits);
    }
}