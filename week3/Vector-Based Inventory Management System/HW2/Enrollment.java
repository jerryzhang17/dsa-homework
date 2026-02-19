public class Enrollment {
    
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String grade; // A, B, C, D, F, null
    private String semester; // Fall/Spring Year

    public Enrollment(String studentId, String courseCode, String semester, String enrollmentId, String grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.enrollmentId = enrollmentId;
        this.grade = grade;
    }

    public String getEnrollmentId() { return enrollmentId; }
    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public String getGrade() { return grade; }
    public String getSemester() { return semester; }

    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setSemester(String semester) { this.semester = semester; }

    @Override
    public String toString(){
        return enrollmentId + " " + studentId + " " + courseCode + " " + grade + " " + semester;
    }

    public double getGradePoints(){
    if (grade == null) return 0.0;
        return switch (grade) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            default -> 0.0;
        };
    }

    public boolean isPassing(){
        if(grade == null) return false;
        return !grade.equals("F");
    }
}