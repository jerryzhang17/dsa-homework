
import java.util.ArrayList;
import java.util.Iterator;

public class It {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("Andy");
        names.add("James");
        names.add("William");
        names.add("Kenneth");

        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }
    }
}
