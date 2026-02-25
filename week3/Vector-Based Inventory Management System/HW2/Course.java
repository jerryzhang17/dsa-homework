import java.util.ArrayList;

public class Course {
    
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;
    private int maxEnrollment;
    private ArrayList<String> prerequisites;

    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        if (credits <= 0) throw new IllegalArgumentException("Credits must be greater than 0");
        this.credits = credits;
        this.instructor = instructor;
        if (maxEnrollment <= 0) throw new IllegalArgumentException("Max enrollment must be greater than 0");
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
    public void setCredits(int credits) {
        if (credits <= 0) throw new IllegalArgumentException("Credits must be greater than 0");
            this.credits = credits; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setMaxEnrollment(int maxEnrollment) {
        if (maxEnrollment <= 0) throw new IllegalArgumentException("Max enrollment must be greater than 0");
            this.maxEnrollment = maxEnrollment;}

    @Override
    public String toString() { return "Course {" + "courseCode='" + courseCode + '\'' + ", courseName='" + courseName + '\'' + ", credits=" + credits + 
                ", instructor='" + instructor + '\'' + ", maxEnrollment=" + maxEnrollment + '}';}

    public void addPrerequisite(String courseCode) {
        if(courseCode != null) prerequisites.add(courseCode);
    }

    public boolean hasPrerequisite(String courseCode){
        return prerequisites.contains(courseCode);
    }

    public ArrayList<String> getPrerequisites(){
        return new ArrayList<>(prerequisites);
    }
}
