public class Professor {
    //Attributes
    private String name;
    private String specialty;
    private int yearsOfExperience;
    private boolean isTenured;
    //Constructors
    public Professor() {
    }
    public Professor(String name, String specialty, int yearsOfExperience, boolean isTenured) {
        this.name = name;
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.isTenured = isTenured;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public boolean isTenured() {
        return isTenured;
    }
    public void setTenured(boolean tenured) {
        isTenured = tenured;
    }
    //Methods
    public void gainExperience(int years) {
        this.yearsOfExperience += years;
    }
    public void printInfo() {
        String tenureStatus = isTenured ? "Tenured" : "Not Tenured";
        System.out.println("Professor → " + name + ", Specialty: " + specialty
                + ", Experience: " + yearsOfExperience + " years, Status: " + tenureStatus);
    }
}