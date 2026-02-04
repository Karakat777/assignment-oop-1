package models;

import printable.Printable;

public final class Professor implements Printable {
    private int id;
    private String name;
    private String specialty;
    private int yearsOfExperience;
    private boolean isTenured;

    // Required for JSON (Jackson)
    public Professor() {}

    public Professor(String name, String specialty, int yearsOfExperience, boolean isTenured) {
        this.name = name;
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.isTenured = isTenured;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int years) { this.yearsOfExperience = years; }
    public boolean isTenured() { return isTenured; }
    public void setTenured(boolean tenured) { isTenured = tenured; }

    @Override
    public void printInfo() {
        System.out.println("Professor: " + name + ", Specialty: " + specialty);
    }

    @Override
    public String toString() {
        return String.format("Professor[id=%d, name='%s', specialty='%s', years=%d, tenured=%b]",
                id, name, specialty, yearsOfExperience, isTenured);
    }
}