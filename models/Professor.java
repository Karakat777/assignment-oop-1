package models;
import printable.Printable;

import java.util.Objects;
public final class Professor implements Printable {
    private String name;
    private String specialty;
    private int yearsOfExperience;
    private boolean isTenured;
    public Professor(String name,String specialty,int yearsOfExperience,boolean isTenured){
        this.name=name;
        this.specialty=specialty;
        this.yearsOfExperience=yearsOfExperience;
        this.isTenured=isTenured;
    }
    public boolean isTenured(){return isTenured;}
    public void gainExperience(int years){yearsOfExperience+=years;}
    public void gainExperience(){yearsOfExperience++;}
    @Override
    public void printInfo(){System.out.println("Professor → "+name+", "+specialty);}
    @Override
    public int hashCode(){return Objects.hash(name,specialty,yearsOfExperience,isTenured);}
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Professor))return false;
        Professor p=(Professor)obj;
        return yearsOfExperience==p.yearsOfExperience&&isTenured==p.isTenured&&Objects.equals(name,p.name)&&Objects.equals(specialty,p.specialty);
    }}
