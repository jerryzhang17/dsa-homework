import java.util.ArrayList;

public class Food {
    public static void main(String[] args) {
        
        ArrayList<String> foods = new ArrayList<>();

        foods.add("Lobster");
        foods.add("Cheesecake");
        foods.add("Steak");

        for(String s : foods){
            System.out.println(s);
        }
    }
}
