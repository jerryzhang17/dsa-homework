public class StudentManagementSystemMain {
    public static void main(String[] args) {

        // Create StudentManager, CourseManager, EnrollmentManager
        // Add sample data:
        // At least 10 students
        // At least 5 courses
        // Multiple enrollments
        // Demonstrate all operations:
        // Student management
        // Course management
        // Enrollment operations
        // GPA calculations
        // Reporting
        // Use generic utility methods
        // Demonstrate generic data structures
        
        StudentManager s = new StudentManager();
        CourseManager c = new CourseManager();
        EnrollmentManager e = new EnrollmentManager();
        ReportGenerator r = new ReportGenerator();

        s.addStudent(new Student("S1", "Jerry", "Zhang", "jerry.zhang@gmail.com", 3, "CS", 2));
        s.addStudent(new Student("S2", "Alice", "Smith", "alice.smith@gmail.com", 0, "CS", 1));
        s.addStudent(new Student("S3", "Bob", "Johnson", "bob.johnson@gmail.com", 0, "Math", 2));
        s.addStudent(new Student("S4", "Emma", "Wilson", "emma.wilson@gmail.com", 0, "Physics", 3));
        s.addStudent(new Student("S5", "David", "Brown", "david.brown@gmail.com", 0, "CS", 3));
        s.addStudent(new Student("S6", "Sophia", "Davis", "sophia.davis@gmail.com", 0, "Biology", 1));
        s.addStudent(new Student("S7", "Michael", "Miller", "michael.miller@gmail.com", 0, "Economics", 2));
        s.addStudent(new Student("S8", "Olivia", "Garcia", "olivia.garcia@gmail.com", 0, "CS", 3));
        s.addStudent(new Student("S9", "Daniel", "Martinez", "daniel.martinez@gmail.com", 0, "History", 3));
        s.addStudent(new Student("S10", "Isabella", "Lee", "isabella.lee@gmail.com", 0, "Math", 2));

        c.addCourse(new Course("CS101", "Computer Science Intro", 4, "Hulk", 30));
        c.addCourse(new Course("CS201", "Data Structures", 4, "Dr. Banner", 40));
        c.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Strange", 35));
        c.addCourse(new Course("PHYS101", "Physics I", 4, "Dr. Foster", 30));
        c.addCourse(new Course("CS301", "Algorithms", 3, "Dr. Stark", 25));

        e.enrollStudent("S1", "CS101", "Fall");
        e.enrollStudent("S2", "MATH101", "Fall");
        e.enrollStudent("S3", "PHYS101", "Spring");
        e.enrollStudent("S4", "CS201", "Spring");
        e.enrollStudent("S5", "CS301", "Fall");

        s.printAllStudents();
        System.out.println("\nStudents by Major: " + s.getStudentsByMajor("CS"));

        System.out.println("\nCourses by Instructor: " + c.getCoursesByInstructor("Hulk"));
        System.out.println("\nAvailable Courses: " + c.getAvailableCourses("S2", s, e));

        System.out.println("\nGet Enrollment by Students: " + e.getEnrollmentsByStudent("S3"));
        System.out.println("Get Students in a Course: " + e.getStudentsInCourse("CS101"));

        e.assignGrade("S1", "A");
        System.out.println("\nStudent's GPA: " + e.calculateStudentGpa("S1"));

        r.generateStudentReport("S1", s, e);
        r.generateCourseReport("CS101", c, e);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("A");
        stack.push("B");
        System.out.println("\nStack Pop: " + stack.pop());
        System.out.println("Stack Peek: " + stack.peek());

        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("\nQueue Dequeue: " + queue.dequeue());
        System.out.println("Queue Peek: " + queue.peek());

        Pair<String, Integer> pair = new Pair<>("Credits to Graduate", 120);
        System.out.println("\nPair: " + pair);
    }
}
