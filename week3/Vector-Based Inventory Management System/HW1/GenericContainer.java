import java.util.Vector;

public class GenericContainer<T> {

    private Vector<T> items;

    public GenericContainer(){
        items = new Vector<>();
    }

    public void add(T item){
        items.add(item);
    }

    public T get(int index){
        return items.get(index);
    }

    public boolean remove(T item){
        if(items.contains(item)){
            items.remove(item);
            return true;
        }
        return false;
    }

    public int size(){
        return items.size();
    }

    public Vector<T> getAll(){
        return new Vector<>(items);
    }

    public void clear(){
        items.clear();;
    }

    public boolean contains(T item){
        if(items.contains(item)); return true;
    }

    public void addAll(Vector<T> other){
        items.addAll(other);
    }
}