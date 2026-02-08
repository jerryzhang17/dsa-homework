public class Sorting {
    public static void main(String[] args) {
        // test cases
        int[] increasing = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] random = {7, 3, 9, 1, 5, 2, 8, 6, 4};
        int[] reverse = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        int[] test = random.clone();

        Metrics metrics = new Metrics();
        BubbleSort.sort(test, metrics);
        SelectionSort.sort(test, metrics);
        InsertionSort.sort(test, metrics);

        System.out.print("Sorted array: ");
        for (int num : test) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Comparisons: " + metrics.comparisons);
        System.out.println("Swaps: " + metrics.swaps);

    }

    static class BubbleSort {
        public static void sort(int[] arr, Metrics metrics) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++){
                    metrics.comparisons++;
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        metrics.swaps++;
                    }
                }
            }
        }
    }

    static class SelectionSort {
        public static void sort(int[] arr, Metrics metrics) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    metrics.comparisons++;
                    if(arr[j] < arr[min]){
                        min = j;
                    }
                }
                    if (min != i) {
                        int temp = arr[i];
                        arr[i] = arr[min];
                        arr[min] = temp;
                        metrics.swaps++;
                }   
            }
        }
    }

    static class InsertionSort {
        public static void sort(int[] arr, Metrics metrics) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                metrics.comparisons++;
                while(j >= 0 && arr[j] > key){
                    arr[j + 1] = arr[j];
                    j--;
                    metrics.swaps++;
                    if (j >= 0) {
                        metrics.comparisons++;
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