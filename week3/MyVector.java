import java.util.Vector;

class MyVector<T> {
    private Vector<T> vector = new Vector<>();

    public MyVector() {
        vector = new Vector<>();
    }

    public void add(T element){
        vector.add(element);
    }

    public T get(int index){
        return vector.get(index);
    }

    public void set(int index, T element){
        vector.set(index, element);
    }

    public void remove(int index){
        vector.remove(index);
    }

    public int size(){
        return vector.size();
    }

    public void ensureCapacity(int minCapacity){
        vector.ensureCapacity(minCapacity);
    }
}
