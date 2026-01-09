package courseTypes;
import models.Course;
import java.util.Objects;
public class Science extends Course{
    private int maxStudentCount;
    private int labHours;
    private boolean hasLaboratory;
    public Science(String courseName,String courseCode,int credits,int enrolledStudents,int maxStudentCount,int labHours,boolean hasLaboratory){
        super(courseName,courseCode,credits,enrolledStudents);
        this.maxStudentCount=maxStudentCount;
        this.labHours=labHours;
        this.hasLaboratory=hasLaboratory;
    }
    @Override
    public boolean isFull(){return enrolledStudents>=maxStudentCount;}
    @Override
    public void printInfo(){
        System.out.println(courseName+" science course");
        System.out.println("Lab hours: "+labHours);
        System.out.println("Has laboratory: "+hasLaboratory);
    }
    @Override
    public int hashCode(){return Objects.hash(super.hashCode(),maxStudentCount,labHours,hasLaboratory);}
    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj))return false;
        Science science=(Science)obj;
        return maxStudentCount==science.maxStudentCount&&labHours==science.labHours&&hasLaboratory==science.hasLaboratory;
    }}