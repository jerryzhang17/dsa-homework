import java.util.ArrayList;

public class ArrayListUtils {
    
    public static <T> void swap(ArrayList<T> list, int index1, int index2){
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list){
        T max =  list.get(0);
        for(T s : list){
            if(s.compareTo(max) > 0){
                max = s;
            }
        }
        return max;
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition){
        ArrayList<T> test = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(condition.test(list.get(i))){
                test.add(list.get(i));
            }
        }
        return test;
    }

    public interface Predicate<T> {
        boolean test(T value);
    }

    public static <T> void reverse(ArrayList<T> list){
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2){
        ArrayList<T> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        return merged;
    }

    public static <T extends Number> double sum(ArrayList<T> numbers){
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i).doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double average(ArrayList<T> numbers){
        double total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i).doubleValue();
        }
        return total / numbers.size();
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold){
        ArrayList<T> nums = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i).compareTo(threshold) > 0){
                nums.add(numbers.get(i));
            }
        }
        return nums;
    }

    public static double sumNumbers(ArrayList<? extends Number> numbers){
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i).doubleValue();
        }
        return sum;
    }

    public static void addNumbers(ArrayList<? super Integer> list){
        list.add(0);
    }

    public static void printList(ArrayList<?> list){
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + ArrayListUtils.sum(ints));
        System.out.println("Average: " + ArrayListUtils.average(ints));
    }
}
