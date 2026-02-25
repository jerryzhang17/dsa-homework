import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperationsDemo {

    public static void main(String[] args) {

        // Convert Array to ArrayList:
        System.out.println("Convert Array to ArrayList:");

        Student[] studentsArray = {
            new Student("3903490", "Jerry", "Zhang", "brooklyncollege@gmail.com", 4.0, "Computer Science", 2),
            new Student("3903491", "Alice", "Smith", "alice.smith@email.com", 3.7, "Mathematics", 3),
            new Student("3903492", "Bob", "Johnson", "bob.johnson@email.com", 3.2, "Physics", 1)
        };

        for (Student s : studentsArray) {
            System.out.println("Array: " + s);
        }

        ArrayList<Student> studentArrayList = new ArrayList<>(Arrays.asList(studentsArray));

        studentArrayList.remove(1);
        studentArrayList.add(
            new Student("3903493", "Eve", "Williams", "eve.williams@email.com", 3.9, "Biology", 4)
        );

        System.out.println("ArrayList: " + studentArrayList);


        // ArrayList to Array:
        System.out.println("\nArrayList to Array:");

        ArrayList<Student> studentArrayL = new ArrayList<>(Arrays.asList(
            new Student("3903495", "Sara", "Lee", "sara.lee@email.com", 3.5, "English", 1),
            new Student("3903496", "Mike", "Davis", "mike.davis@email.com", 3.0, "History", 2),
            new Student("3903497", "Linda", "Garcia", "linda.garcia@email.com", 3.8, "Art", 3)
        ));

        Student[] studentArray = studentArrayL.toArray(new Student[0]);

        System.out.println("ArrayList: " + studentArrayL);
        System.out.println("Array: " + Arrays.toString(studentArray));


        // SubList Operations:
        System.out.println("\nSubList Operations:");
        ArrayList<Student> arrayListSub = new ArrayList<>(Arrays.asList(
            new Student("3903500", "Tom", "Brown", "tom.brown@email.com", 3.6, "Chemistry", 2),
            new Student("3903501", "Emma", "Wilson", "emma.wilson@email.com", 3.4, "Philosophy", 1),
            new Student("3903502", "David", "Clark", "david.clark@email.com", 3.9, "Economics", 3)
        ));

        List<Student> sublist = arrayListSub.subList(0, 2);

        System.out.println("ArrayList: " + arrayListSub);
        System.out.println("Sublist: " + sublist);

        // ArrayList Sorting:
        System.out.println("\nArrayList Sorting:");
        ArrayList<Student> unsorted = new ArrayList<>(Arrays.asList(
            new Student("3903503", "Chris", "Evans", "chris.evans@email.com", 2.9, "Drama", 1),
            new Student("3903504", "Anna", "Taylor", "anna.taylor@email.com", 3.3, "Music", 2),
            new Student("3903505", "James", "Moore", "james.moore@email.com", 3.1, "Geography", 3)
        ));

        // Sort ArrayList by GPA
        Collections.sort(unsorted, (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Sorted ArrayList by GPA: " + unsorted);

        //Sort ArrayList by Last Name
        Collections.sort(unsorted, (s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
        System.out.println("Sorted ArrayList by Last Name: " + unsorted);

        // ArrayList Searching:
        System.out.println("\nArrayList Searching:");

        Student searchStudent = new Student("3903504", "Anna", "Taylor", "anna.taylor@email.com", 3.3, "Music", 2);
        System.out.println("Index of Anna: " + unsorted.indexOf(searchStudent));
        System.out.println(unsorted.contains(searchStudent));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("1", "Chris", "Evans", "", 2.9, "", 1));
        students.add(new Student("2", "Anna", "Taylor", "", 3.3, "", 2));
        students.add(new Student("3", "James", "Moore", "", 3.1, "", 3));

        Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
        Collections.sort(students, gpaComparator);
        Student key = new Student(null, null, null, null, 3.1, null, 0);
        int index = Collections.binarySearch(students, key, gpaComparator);

        System.out.println("Sorted list:");
        System.out.println(students);

        System.out.println("Binary search result index: " + index);
    }
}