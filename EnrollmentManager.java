import java.util.ArrayList;

public class EnrollmentManager {

    private ArrayList<Enrollment> enrollments;

    public EnrollmentManager() {
        enrollments = new ArrayList<>();
    }

    public void enrollStudent(String studentId, String courseCode, String semester) {
        if(getEnrollmentCount(courseCode) <= enrollments.size()){
            Enrollment enrollment = new Enrollment(studentId, courseCode, semester, "", "");
            enrollments.add(enrollment);
        }
    }

    public boolean dropEnrollment(String enrollmentId){
        for(Enrollment e : enrollments){
            if(e.getEnrollmentId().equals(enrollmentId)){
                enrollments.remove(e);
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

    // Needs to handle cases for students with no enrollment.
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
            }
        }
    }

    public double calculateStudentGpa(String studentId){
        for(Enrollment e : enrollments){
            if(e.getStudentId().equals(studentId)){
                return e.getGradePoints();
            }
        }
        return 0.0;
    }

    public ArrayList<String> getStudentsInCourse(String courseCode){
        ArrayList<String> students = new ArrayList<>();
        for(Enrollment e : enrollments){
            if(e.getCourseCode().equals(courseCode)){
                students.add(e.getStudentId());
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
