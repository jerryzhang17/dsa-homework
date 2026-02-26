import java.util.ArrayList;

public class GenericList<T>{
    
    private ArrayList<T> items;

    public void add(T item){
        items.add(item);
    }

    public T get(int index){
        return items.get(index);
    }

    public boolean remove(T item){
        return items.remove(item);
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clear(){
        items.clear();
    }

    public boolean contains(T item){
        return items.contains(item);
    }

    public ArrayList<T> getAll(){
        ArrayList<T> copies = new ArrayList<>();
        copies.addAll(items);
        return copies;
    }

    public void addAll(ArrayList<T> other){
        items.addAll(other);
    }

    public <U extends T> void addAllFrom(GenericList<U> other){
        items.addAll(other.getAll());
    }
}
