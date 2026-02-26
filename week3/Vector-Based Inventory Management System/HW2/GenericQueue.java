import java.util.ArrayList;

public class GenericQueue<T> {
    
    ArrayList<T> items = new ArrayList<>();

    public void enqueue(T item){
        items.add(item);
    }

    public T dequeue(){
        T item = items.get(0);
        items.remove(0);
        return item;
    }

    public T peek(){
        T item = items.get(0);
        return item;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());  // 10
    }
}
