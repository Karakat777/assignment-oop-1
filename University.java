public class University {
    //Attributes
    private String universityName;
    private String location;
    private int worldRanking;
    private int totalStudents;
    //Constructors
    public University() {
    }
    public University(String universityName, String location, int worldRanking, int totalStudents) {
        this.universityName = universityName;
        this.location = location;
        this.worldRanking = worldRanking;
        this.totalStudents = totalStudents;
    }
    //Getters and Setters
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getWorldRanking() {
        return worldRanking;
    }
    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }
    public int getTotalStudents() {
        return totalStudents;
    }
    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
    //Methods
    public void improveRanking(int positions) {
        this.worldRanking -= positions; // Lower ranking number is better
        if (this.worldRanking < 1) {
            this.worldRanking = 1;
        }
    }
    public void printInfo() {
        System.out.println("University → " + universityName + ", Location: " + location
                + ", Ranking: #" + worldRanking + ", Students: " + totalStudents);
    }
    //Compare two universities by ranking
    public int compareRanking(University other) {
        return Integer.compare(this.worldRanking, other.worldRanking); // Lower is better
    }
}
