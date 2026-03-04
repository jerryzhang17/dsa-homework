import java.util.ArrayList;
import java.util.Iterator;

public class Box<T> {
    private String name;
    private Integer id;

    public Box(String name){
        this.name = name;
    }

    public Box(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
    public static void main(String[] args) {
        ArrayList<Box<String>> names = new ArrayList<>();
        ArrayList<Box<Integer>> ids = new ArrayList<>();

        names.add(new Box<String>("N1"));
        names.add(new Box<String>("N2"));
        names.add(new Box<String>("N3"));
        names.add(new Box<String>("N4"));
        names.add(new Box<String>("N5"));

        ids.add(new Box<Integer>(10));
        ids.add(new Box<Integer>(20));
        ids.add(new Box<Integer>(30));
        ids.add(new Box<Integer>(40));
        ids.add(new Box<Integer>(50));

        Iterator<Box<String>> it = names.iterator();
        while(it.hasNext()){
            Box<String> name = it.next();
            System.out.println(name.getName());
        }

        System.out.println();

        Iterator<Box<Integer>> num = ids.iterator();
        while(num.hasNext()){
            Box<Integer> id = num.next();
            System.out.println(id.getId());
        }
    }
}