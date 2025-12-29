package models;
import printable.Printable;

import java.util.Objects;
public abstract class Course implements Printable {
    protected String courseName;
    protected String courseCode;
    protected int credits;
    protected int enrolledStudents;
    public Course(){}
    public Course(String courseName, String courseCode,int credits,int enrolledStudents){
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.credits=credits;
        this.enrolledStudents=enrolledStudents;
    }
    public String getCourseName(){return courseName;}
    public String getCourseCode(){return courseCode;}
    public int getCredits(){return credits;}
    public int getEnrolledStudents(){return enrolledStudents;}
    public void addStudent(){enrolledStudents++;}
    public void addStudent(int count){enrolledStudents+=count;}
    public void removeStudent(){if(enrolledStudents>0)enrolledStudents--;}
    public abstract boolean isFull();
    @Override
    public int hashCode(){return Objects.hash(courseName,courseCode,credits,enrolledStudents);}
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(!(obj instanceof Course))return false;
        Course course=(Course)obj;
        return credits==course.credits&&enrolledStudents==course.enrolledStudents&&Objects.equals(courseName,course.courseName)&&Objects.equals(courseCode,course.courseCode);
    }}
