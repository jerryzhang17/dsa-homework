import java.util.ArrayList;

public class Course {
    
    String courseCode;
    String courseName;
    int credits;
    String instructor;
    int maxEnrollment;
    ArrayList<String> prerequisites;

    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        prerequisites = new ArrayList<>();
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }
    public int getMaxEnrollment() { return maxEnrollment; }

    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setMaxEnrollment(int maxEnrollment) { this.maxEnrollment = maxEnrollment; }

    public String toString() { return courseCode + " " + courseName + " " + credits + " " + instructor + " " + maxEnrollment + " " + prerequisites; }

    public void addPrerequisites(String courseCode) {
        if(courseCode != null) prerequisites.add(courseCode);
    }

    public boolean hasPrerequisites(String courseCode){
        if(prerequisites.contains(courseCode)) return true;
        return false;
    }

    public ArrayList<String> getPrerequisites(){
        return new ArrayList<>(prerequisites);
    }
}
