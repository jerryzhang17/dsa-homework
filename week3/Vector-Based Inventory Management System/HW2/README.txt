Student: Represents a student with an ID, name, email, major, GPA, and year.

StudentManager: Manages a collection of students. 
Methods: adding students, finding students, listing students by major, and calculating statistics.

Course: Represents a course with a course code, name, credit value, instructor, and capacity.

CourseManager: Manages all courses. 
Methods: adding courses, finding courses, listing courses by instructor, and determining available courses.

Enrollment: Represents a student’s enrollment in a course for specific semester, including grade information.

EnrollmentManager: Handles enrollments between students and courses.
Methods: enrolling students, dropping enrollments, assigning grades, calculating GPA, and retrieving enrollment data.

ReportGenerator: Generates formatted reports: Student report (courses and GPA), Course report (students enrolled and average grade), 
Major report (students and average GPA), Honor roll report.

GenericList<T>: A generic wrapper around ArrayList<T> that demonstrates custom generic collections.

GenericStack<T>: A generic stack implementation using ArrayList.

GenericQueue<T>: A generic queue implementation using ArrayList.

ArrayListUtils: Provides generic utility methods such as swap, filter, sum, average, merge, and reverse.

StudentManagementSystemMain: Main application.

I made fall backs for my constructor for example year and gpa. If it was out off the range such as a 5.0 gpa it would throw an argument and return back an error.
Made sure for the instance methods it would check if the parameter is null or is empty.

Challenges I encountered was designing the syntax of these fail cases. The logics of some instance methods especially task 2.2: Check if course is at capacity before enrolling,
Validate grades (A, B, C, D, F only), Handle cases where student has no enrollments. The instance method getStudentsInCourse in EnrollmentManager the logic had me confused for a bit.
Ensuring correct validation for semester values.
Avoiding hard coding.

ArrayList automatically resizes and simplifies add/remove operations and are way more flexible than arrays.
ArrayList and Vector are almost similar.

Arrays:
Fixed size
Faster direct access
Harder to insert or remove elements
Requires manual resizing (copying)

ArrayList
Dynamic size (flexible)
Easier to add and remove elements
Slightly slower due to calling methods
Better for real-world applications and data management (commonly used)