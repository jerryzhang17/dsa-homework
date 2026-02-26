import java.util.ArrayList;

public class GenericStack<T> {
    
    private ArrayList<T> items = new ArrayList<>();

    public void push(T item){
        items.add(item);
    }

    public T pop(){
        return items.remove(items.size() - 1);
    }

    public T peek(){
        return items.get(items.size() - 1);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

    public void clear(){
        items.clear();
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println(stack.pop());  // Second
    }
}