import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class Pirate {
	String name;
	String role;
	int bounty;

    Pirate(String name, String role, int bounty) {
        this.name = name;
        this.role = role;
        this.bounty = bounty;
    }

    public static void main(String[] args) {
        List<Pirate> crew = new ArrayList<>(List.of(
            new Pirate("Luffy", "Captain", 300),
            new Pirate("Zoro", "Swordsman", 120),
            new Pirate("Nami", "Navigator", 66),
            new Pirate("Sanji", "Cook", 130),
            new Pirate("Chopper", "Doctor", 50),
            new Pirate("Apprentice A", "Apprentice", 10)
        ));

        Predicate<Pirate> highBounty = p -> p.bounty >= 100;

        // 1
        List<Pirate> bigShots = crew.stream()
            .filter(highBounty)
            .sorted((p1, p2) -> Integer.compare(p2.bounty, p1.bounty))
            .toList();

        System.out.println("Highest Bounty:");
        bigShots.forEach(p -> System.out.println(p.name + " - " + p.bounty));

        Iterator<Pirate> it = crew.iterator();
        while (it.hasNext()) {
            Pirate p = it.next();
            if (p.role.contains("Apprentice")) {
                it.remove();
            }
        }

        crew.forEach(p -> System.out.println(p.name + " - " + p.role));

        // 4
        

        // 5
        int sum = 0;
        Iterator<Pirate> add = crew.iterator();
        while (add.hasNext()) {
            sum += add.next().bounty;
        }
        System.out.println("\n" + sum);

        // 6
        boolean overTwo = crew.stream().anyMatch(p -> p.bounty > 200);
        System.out.println("\n" + overTwo);
    }
}