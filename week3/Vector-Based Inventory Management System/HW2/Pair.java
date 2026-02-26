import java.util.ArrayList;

public class Pair<K, V> {
    
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() { return first; }
    public V getSecond() { return second; }

    public void setFirst(K first) { this.first = first; }
    public void setSecond(V second) { this.second = second;}

    @Override
    public String toString(){
        return first + " " + second;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Pair)) return false;
        Pair<?, ?> that = (Pair<?, ?>) obj;
        return this.first.equals(that.first) && this.second.equals(that.second);
    }

    @Override
    public int hashCode(){
        return first == null || second == null? 0 : first.hashCode() + second.hashCode();
    }

    public static void main(String[] args) {
        ArrayList<Pair<String, Double>> pairs = new ArrayList<>();
        pairs.add(new Pair<>("DSA", 4.0));
        ArrayList<Pair<Student, Course>> enrollments = new ArrayList<>();
        enrollments.add(new Pair<>(new Student("", "", "", "", 0.0, "", 3), new Course("DSA", "Data Structures", 3, "CS", 4)));
        System.out.println(pairs);
        System.out.println(enrollments);
    }
}
