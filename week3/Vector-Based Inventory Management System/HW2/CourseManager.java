import java.util.ArrayList;

public class CourseManager {
    ArrayList<Course> courses;

    public CourseManager(){
        courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public Course findCourse(String courseCode){
        for(Course c : courses){
            if(c.getCourseCode().equals(courseCode)){
                return c;
            }
        }
        return null;
    }

    // public ArrayList<Course> getCoursesByInstructor(String instructor){
    //     for(Course c : courses){
    //         if(c.getInstructor().equals(instructor)){
    //             return c.getCourseName();
    //         }
    //     }
    //     return null;
    // }

    // help.
    public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager){
        ArrayList<Course> available = new ArrayList<>();
        Student student = studentManager.findStudent(studentId);
        if(student == null) return available;

        ArrayList<Enrollment> enrollments = enrollmentManager.getEnrollmentsByStudent(studentId);
        return available;
    }

    public void printAllCourses(){
        for(Course c : courses){
            System.out.println(c.getCourseName());
        }
    }

    public int getTotalCourses(){
        return courses.size();
    }
}
