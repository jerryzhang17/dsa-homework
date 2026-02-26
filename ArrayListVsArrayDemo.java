import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayListVsArrayDemo {
    public static void main(String[] args) {
        
        Student[] array = new Student[2];
        ArrayList<Student> arrayList = new ArrayList<>(Arrays.asList(
            new Student("3903500", "Tom", "Brown", "tom.brown@email.com", 3.6, "Chemistry", 2),
            new Student("3903501", "Emma", "Wilson", "emma.wilson@email.com", 3.4, "Philosophy", 1),
            new Student("3903502", "David", "Clark", "david.clark@email.com", 3.9, "Economics", 3)
        ));

        array[0] = new Student("1", "Alice", "Smith", "", 3.5, "", 1);
        array[1] = new Student("2", "Bob", "Jones", "", 3.2, "", 2);

        // When adding an element to the array out of its bounds, it will lead to an error.
        System.out.println("Array contents:");
        for (Student student : array) {
            System.out.println(student);
        }

        // Remove an element in the array
        int targetIndexRemove = 1;
        Student[] newArray = new Student[array.length - 1];

        System.arraycopy(array, 0, newArray, 0, targetIndexRemove);
        System.arraycopy(array, targetIndexRemove + 1, newArray, targetIndexRemove, array.length - targetIndexRemove - 1);
        System.out.println(Arrays.toString(newArray));

        // Arraylist auto adjusts to the new size when adding or removing.
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        arrayList.add(new Student("2132113", "James", "He", "james.he@email.com", 1.0, "Art", 2));
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        // Performance
        System.out.println("\nPerformance:");
        ArrayList<Student> timeArrayList = new ArrayList<>(10000);
        Student[] timeArray = new Student[10000];
        Student student = new Student("", "", "", "", 3.5, "Major", 4);
        
        long startAL = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            timeArrayList.add(student);
        }
        long endAL = System.nanoTime();
        long durationAL = endAL - startAL;
        System.out.println("ArrayList 10,000 add time: " + durationAL);

        long startA = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            timeArray[i] = student;
        }
        long endA = System.nanoTime();
        long durationA = endA - startA;
        System.out.println("Array 10,000 add time: " + durationA);

        // Random access time
        Random rand = new Random();

        long startALR = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            timeArrayList.get(rand.nextInt(timeArrayList.size()));
        }
        long endALR = System.nanoTime();
        long durationALR = endALR - startALR;
        System.out.println("\nArraylist 1,000 access time: " + durationALR);

        long startAR = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            Student temp = timeArray[rand.nextInt(timeArray.length)];
        }
        long endAR = System.nanoTime();
        long durationAR = endAR - startAR;
        System.out.println("Array 1,000 access time: " + durationAR);

        /* 
        Arrays are way faster than arraylist since array's access is direct, arrays are able to access its index without calling any methods.
        However, the tradeoff for Arraylist for it performing slower that its easier to manipulate the elements of the list.
        ArrayList are able to easily add or remove elements without the need of loops.
        */
    }
}
