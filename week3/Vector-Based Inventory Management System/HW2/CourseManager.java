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

    public ArrayList<Course> getCoursesByInstructor(String instructor){
        for(Course c : courses){
            if(c.getInstructor().equals(instructor)){
                return c.getCourseName();
            }
        }
        return null;
    }
}
