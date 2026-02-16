import java.util.Vector;

public class VectorUtils {
    public static <T> void swap(Vector<T> vec, int index1, int index2){
        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(Vector<T> vec){
        T max = vec.get(0);

        for (int i = 0; i < vec.size(); i++) {
            if(vec.get(i).compareTo(max) > 0){
                max = vec.get(i);
            }
        }
        return max;
    }

    public static <T> int countMatches(Vector<T> vec, T target){
        int counter = 0;
        
        for (int i = 0; i < vec.size(); i++) {
            if(vec.get(i).equals(target)){
                counter++;
            }
        }
        return counter;
    }

    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition){
        Vector<T> test = new Vector<>();

        for (int i = 0; i < vec.size(); i++) {
            if(condition.test(vec.get(i))){
                test.add(vec.get(i));
            }
        }
        return test;
    }

    public interface Predicate<T> {
        boolean test(T value);
    }

    public static <T extends Number> double sumNumbers(Vector<T> numbers){
        double sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i).doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double averageNumbers(Vector<T> numbers){
        double total = 0;

        if(numbers.isEmpty()) return 0.0;

        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i).doubleValue();
        }
        return total / numbers.size();
    }

    public static void main(String[] args) {
        Vector<Integer> ints = new Vector<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
        System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0
    }

}