package models;
import printable.Printable;
import java.util.Objects;
public class University implements Printable {
    private String universityName;
    private String location;
    private int worldRanking;
    private int totalStudents;
    public University(String universityName,String location,int worldRanking,int totalStudents){
        this.universityName=universityName;
        this.location=location;
        this.worldRanking=worldRanking;
        this.totalStudents=totalStudents;
    }
    public void improveRanking(int positions){
        worldRanking-=positions;
        if(worldRanking<1)worldRanking=1;
    }
    public void improveRanking(){improveRanking(1);}
    @Override
    public final void printInfo(){
        System.out.println("University → "+universityName+", "+location+", Ranking #"+worldRanking+", Students: "+totalStudents);
    }
    @Override
    public int hashCode(){return Objects.hash(universityName,location,worldRanking,totalStudents);}
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof University))return false;
        University u=(University)obj;
        return worldRanking==u.worldRanking&&totalStudents==u.totalStudents&&Objects.equals(universityName,u.universityName)&&Objects.equals(location,u.location);
    }}