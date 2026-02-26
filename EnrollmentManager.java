import java.util.ArrayList;

public class EnrollmentManager {

    private final ArrayList<Enrollment> enrollments;

    public EnrollmentManager() {
        enrollments = new ArrayList<>();
    }

    public void enrollStudent(String studentId, String courseCode, String semester) {
        String enrollmentId = "S" + (enrollments.size() + 1);
        Enrollment enrollment = new Enrollment(studentId, courseCode, semester, enrollmentId, null);
        enrollments.add(enrollment);
    }

    public boolean dropEnrollment(String enrollmentId){
        for (int i = 0; i < enrollments.size(); i++) {
            if(enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
                enrollments.remove(i);
                return true;
            }
        }
        return false;
    }

    public Enrollment findEnrollment(String enrollmentId){
        for(Enrollment e : enrollments){
            if(e.getEnrollmentId().equals(enrollmentId)){
                return e;
            }
        }
        return null;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId){
        ArrayList<Enrollment> students = new ArrayList<>();
        for(Enrollment e : enrollments){
            if(e.getStudentId().equals(studentId)){
                students.add(e);
            }
        }
        return students;
    }

    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode){
        ArrayList<Enrollment> course = new ArrayList<>();
        for(Enrollment e : enrollments){
            if(e.getCourseCode().equals(courseCode)){
                course.add(e);
            }
        }
        return course;
    }

    public void assignGrade(String enrollmentId, String grade){
        for(Enrollment e : enrollments){
            if(e.getEnrollmentId().equals(enrollmentId)){
                e.setGrade(grade);
                return;
            }
        }
    }

    public double calculateStudentGpa(String studentId){
        double totalPoints = 0.0;
        int count = 0;

        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId) && e.getGrade() != null) {
                totalPoints += e.getGradePoints();
                count++;
            }
        }

        if (count == 0) return 0.0;
        return totalPoints / count;
    }

    public ArrayList<String> getStudentsInCourse(String courseCode){
        ArrayList<String> students = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                String studentId = e.getStudentId();
                if (!students.contains(studentId)) {
                    students.add(studentId);
                }
            }
        }
        return students;
    }

    public int getEnrollmentCount(String courseCode){
        int count = 0;
        for(Enrollment e : enrollments){
            if(e.getCourseCode().equals(courseCode)){
                count++;
            }
        }
        return count;
    }

    public void printAllEnrollments(){
        for(Enrollment e : enrollments){
            System.out.print(e + " ");
        }
    }
}
