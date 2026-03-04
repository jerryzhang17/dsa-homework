import java.util.*;

public class VectorComparisonDemo {
    public static void main(String[] args) {

        Vector<Product> vector = new Vector<>();
        ArrayList<Product> arraylist = new ArrayList<>();

        Product product = new Product("0000", "Product", "Product", 1, 10, "Product");


        // Add time
        long startVector = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vector.add(product);
        }
        long endVector = System.nanoTime();
        long durationVector = endVector - startVector;
        System.out.println("Vector 10,000 add time: " + durationVector);
        System.out.println("");

        long startArray = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arraylist.add(product);
        }
        long endArray = System.nanoTime();
        long durationArray = endArray - startArray;
        System.out.println("ArrayList 10,000 add time: " + durationArray);
        System.out.println("");


        // Random access time
        Random rand = new Random();

        long startVectorRandom = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            vector.get(rand.nextInt(vector.size()));
        }
        long endVectorRandom = System.nanoTime();
        long durationVectorRandom = endVectorRandom - startVectorRandom;
        System.out.println("Vector 1,000 access time: " + durationVectorRandom);
        System.out.println("");

        long startArrayRandom = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arraylist.get(rand.nextInt(arraylist.size()));
        }
        long endArrayRandom = System.nanoTime();
        long durationArrayRandom = endArrayRandom - startArrayRandom;
        System.out.println("ArrayList 1,000 access time: " + durationArrayRandom);
        System.out.println("");


        // Remove time (from end)
        long startVectorRemove = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vector.remove(vector.size() - 1);
        }
        long endVectorRemove = System.nanoTime();
        long durationVectorRemove = endVectorRemove - startVectorRemove;
        System.out.println("Vector 10,000 remove time: " + durationVectorRemove);
        System.out.println("");

        long startArrayRemove = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arraylist.remove(arraylist.size() - 1);
        }
        long endArrayRemove = System.nanoTime();
        long durationArrayRemove = endArrayRemove - startArrayRemove;
        System.out.println("ArrayList 10,000 remove time: " + durationArrayRemove);
        System.out.println("");

        // Memory usage, had to be searched up did not know how to do this part.
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        Vector<Product> vectorMemory = new Vector<>();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int i = 0; i < 10000; i++) {
            vectorMemory.add(product);
        }
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long vectorMemoryUsed = memoryAfter - memoryBefore;
        System.out.println("Vector Memory: " + vectorMemoryUsed);
        System.out.println("");

        runtime.gc();

        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<Product> arrayMemory = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayMemory.add(product);
        }
        long memoryAfterArr = runtime.totalMemory() - runtime.freeMemory();
        long arrayMemUsed = memoryAfterArr - memoryBefore;
        System.out.println("ArrayList Memory: " + arrayMemUsed);
    }

    // When it comes to adding products in vector is slower than array list, as well as accessing vector is longer than array list.
    // Vector uses more memory than arraylist

    // Vector over Arraylist
    // Vector is recommended if thread safety is required.

    // Arraylist over Vector
    // Better performance in speed and memory, thread safety also not required.

}