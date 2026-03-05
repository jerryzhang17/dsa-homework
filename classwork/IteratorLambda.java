import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorLambda {
	public static void main(String[] args) {

        // Lambda Methods
        // 1
        Run greet = () -> System.out.println("Hello!");
        greet.sayHello();

        // 2
        Addition numbers = (x, y) -> x + y;
        System.out.println(numbers.sum(4, 5));

        // 3
        Multiply nums = (x, y) -> {
            System.out.println(x * y);
            return 0;
        };
        nums.product(10, 5);

        // 4
        Length len = (String s) -> s.length();
        System.out.println(len.len("This is a lambda"));

        // 5
        Even even = (int n) -> n % 2 == 0;
        System.out.println((boolean)even.isEven(16));

        // Iterators Methods
        // 1
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        Iterator<String> i1 = fruits.iterator();
        while (i1.hasNext()){
            String fruit =  i1.next();
            System.out.println(fruit);
        }

        // 2
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(4);
        ints.add(20);
        ints.add(11);

        Iterator<Integer> i2 = ints.iterator();
        while(i2.hasNext()){
            Integer n = i2.next();
            if(n % 4 == 0){
                System.out.println(n);
            }
        }

        // 3
        ArrayList<Integer> numbersCopy = new ArrayList<>(ints);
        Iterator<Integer> i3 = numbersCopy.iterator();
        while(i3.hasNext()){
            Integer n = i3.next();
            if(n % 5 == 0){
                i3.remove();
            } else {
                System.out.println(n);
            }
        }

        // 4
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Fox");
        Iterator<String> it = animals.iterator();
        while(it.hasNext()){
            String animal = it.next();
            if(animal.equals("Cat")){
                System.out.println("Found it!");
                break;
            }
        }

        // 5
        ArrayList<Integer> numsList = new ArrayList<>(List.of(10, 20, 30, 40));
        Iterator<Integer> it5 = numsList.iterator();
        int sum = 0;
        while(it5.hasNext()){
            sum += it5.next();
        }
        System.out.println("Sum: " + sum);
    }
}

// Interfaces for Lambdas
interface Run{
    void sayHello();
}
interface Addition{
    int sum(int a, int b);
}
interface Multiply{
    int product(int a, int b);
}
interface Length{
    int len(String s);
}
interface Even{
    boolean isEven(int n);
}