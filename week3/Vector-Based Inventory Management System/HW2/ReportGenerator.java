public class ReportGenerator {
    
    public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
        Student student = sm.findStudent(studentId);
        if (student == null) { System.out.println("Student not found."); return; }

        System.out.println("Student Report");
        System.out.println(student);
        System.out.println("Enrollments:");
        for (Enrollment e : em.getEnrollmentsByStudent(studentId)) {
            System.out.println(e);
        }
        double gpa = em.calculateStudentGpa(studentId);
        System.out.println("Calculated GPA: " + gpa);
        System.out.println();
    }

    public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        Course course = cm.findCourse(courseCode);
        if (course == null) { System.out.println("Course not found."); return; }

        System.out.println("Course Report");
        System.out.println(course);
        System.out.println("Enrolled Students:");

        double total = 0;
        int count = 0;

        for (Enrollment e : em.getEnrollmentsByCourse(courseCode)) {
            System.out.println(e.getStudentId());
            if (e.getGrade() != null) {
                total += e.getGradePoints();
                count++;
            }
        }

        System.out.println("Average Grade: " + (count == 0 ? 0.0 : total / count));
        System.out.println();
    }

    public void generateMajorReport(String major, StudentManager sm) {
        System.out.println("Major Report: " + major);

        double total = 0;
        int count = 0;

        for (Student s : sm.getStudentsByMajor(major)) {
            System.out.println(s);
            total += s.getGpa();
            count++;
        }

        System.out.println("Average GPA: " + (count == 0 ? 0.0 : total / count));
        System.out.println();
    }

    public void generateHonorRollReport(StudentManager sm, double minGpa) {
        System.out.println("Honor Roll (GPA >= " + minGpa + ")");

        for (Student s : sm.getHonorStudents(minGpa)) {
            System.out.println(s);
        }

        System.out.println();
    }
}
