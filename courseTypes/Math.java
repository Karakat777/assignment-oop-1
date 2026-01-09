package courseTypes;
import models.Course;
import java.util.Objects;
public class Math extends Course{
    private int maxStudentCount;
    public Math(String courseName,String courseCode,int credits,int enrolledStudents,int maxStudentCount){
        super(courseName,courseCode,credits,enrolledStudents);
        this.maxStudentCount=maxStudentCount;
    }
    @Override
    public boolean isFull(){return enrolledStudents>=maxStudentCount;}
    @Override
    public void printInfo(){System.out.println(courseName+" math course");}
    @Override
    public int hashCode(){return Objects.hash(super.hashCode(),maxStudentCount);}
    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj))return false;
        Math math=(Math)obj;
        return maxStudentCount==math.maxStudentCount;
    }}