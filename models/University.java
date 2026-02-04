package models;

public class University {
    private int id;
    private String universityName;
    private String location;
    private int worldRanking;
    private int totalStudents;

    public University(String universityName, String location, int worldRanking, int totalStudents) {
        this.universityName = universityName;
        this.location = location;
        this.worldRanking = worldRanking;
        this.totalStudents = totalStudents;
    }

    public static void printInfo(University u) {
        System.out.println("University: " + u.getUniversityName() + " | Rank: " + u.getWorldRanking());
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUniversityName() { return universityName; }
    public String getLocation() { return location; }
    public int getWorldRanking() { return worldRanking; }
    public int getTotalStudents() { return totalStudents; }
}