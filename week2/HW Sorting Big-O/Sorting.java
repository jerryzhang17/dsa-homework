import java.util.Random;

public class Sorting {
    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {

        int[] increasing = new int[size];
        int[] random = new int[size];
        int[] reverse = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            increasing[i] = i;
            random[i] = rand.nextInt(size);
            reverse[i] = size - i;
        }

        // Change the first parameter to test other arrays.
        // Bubble
        Metrics m1 = new Metrics();
        BubbleSort.sort(random.clone(), m1);

        // Selection
        Metrics m2 = new Metrics();
        SelectionSort.sort(random.clone(), m2);

        // Insertion
        Metrics m3 = new Metrics();
        InsertionSort.sort(random.clone(), m3);

        System.out.println("Size: " + size + " | Input: Random | Algorithm: Bubble");
        System.out.println("Comparisons: " + m1.comparisons);
        System.out.println("Swaps: " + m1.swaps);

        System.out.println("Size: " + size + " | Input: Random | Algorithm: Selection");
        System.out.println("Comparisons: " + m2.comparisons);
        System.out.println("Swaps: " + m2.swaps);

        System.out.println("Size: " + size + " | Input: Random | Algorithm: Insertion");
        System.out.println("Comparisons: " + m3.comparisons);
        System.out.println("Swaps: " + m3.swaps);
        }
    }

    static class BubbleSort {
        public static void sort(int[] arr, Metrics m) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++){
                    m.comparisons++;
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        m.swaps++;
                    }
                }
            }
        }
    }

    static class SelectionSort {
        public static void sort(int[] arr, Metrics m) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    m.comparisons++;
                    if(arr[j] < arr[min]){
                        min = j;
                    }
                }
                    if (min != i) {
                        int temp = arr[i];
                        arr[i] = arr[min];
                        arr[min] = temp;
                        m.swaps++;
                }   
            }
        }
    }

    static class InsertionSort {
        public static void sort(int[] arr, Metrics m) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                m.comparisons++;
                while(j >= 0 && arr[j] > key){
                    arr[j + 1] = arr[j];
                    j--;
                    m.swaps++;
                    if (j >= 0) {
                        m.comparisons++;
                    }
                }
                arr[j + 1] = key;
            }
        }
    }

    static class Metrics {
        int comparisons;
        int swaps;
    }
}