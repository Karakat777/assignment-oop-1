package models;

import printable.Printable;
import java.util.Objects;

public final class Professor implements Printable {
    private int id;
    private String name;
    private String specialty;
    private int yearsOfExperience;
    private boolean isTenured;

    public Professor(String name, String specialty, int yearsOfExperience, boolean isTenured) {
        this.name = name;
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.isTenured = isTenured;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public boolean isTenured() { return isTenured; }
    public void setTenured(boolean tenured) { isTenured = tenured; }
    public void gainExperience() { yearsOfExperience++; }

    @Override
    public void printInfo() {
        System.out.println("Professor → " + name + ", " + specialty);
    }

    @Override
    public String toString() {
        return String.format("Professor[id=%d, name='%s', specialty='%s', years=%d, tenured=%b]",
                id, name, specialty, yearsOfExperience, isTenured);
    }

    @Override
    public int hashCode() { return Objects.hash(name, specialty, yearsOfExperience, isTenured); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Professor)) return false;
        Professor p = (Professor) obj;
        return yearsOfExperience == p.yearsOfExperience && isTenured == p.isTenured && Objects.equals(name, p.name) && Objects.equals(specialty, p.specialty);
    }
}