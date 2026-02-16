import java.util.Vector;

public class InventorySystemMain {

    public static void main(String[] args) {

        ProductInventory inventory = new ProductInventory();

        Product p1 = new Product("P100", "Laptop", "Electronics", 1200.0, 5, "Dell");
        Product p2 = new Product("P200", "Phone", "Electronics", 800.0, 2, "Samsung");
        Product p3 = new Product("P300", "Shirt", "Clothing", 40.0, 20, "H&M");

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        inventory.printAllProducts();
        inventory.printCapacityInfo();

        System.out.println("Find product P200:");
        System.out.println(inventory.findProduct("P200"));

        System.out.println("Low stock products (< 5):");
        for (Product p : inventory.getLowStockProducts(5)) {
            System.out.println(p);
        }

        System.out.println("Total inventory value:");
        System.out.println(inventory.getTotalInventoryValue());

        inventory.removeProduct("P300");
        System.out.println("After removing P300:");
        inventory.printAllProducts();


        OrderManager orderManager = new OrderManager();

        Order order1 = new Order("O001", "Alice", "2026-02-16", "Pending");
        order1.addItem(new OrderItem("P100", "Laptop", 1, 1200.0));
        order1.addItem(new OrderItem("P200", "Phone", 2, 800.0));

        orderManager.addOrder(order1);

        System.out.println("Order details:");
        order1.printOrder();

        System.out.println("Order total:");
        System.out.println(order1.calculateTotal());

        order1.updateStatus("Processing");
        System.out.println("Updated order status.");

        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(30);

        System.out.println("Max number: " + VectorUtils.findMax(numbers));

        Vector<String> words = new Vector<>();
        words.add("apple");
        words.add("zebra");
        words.add("banana");

        System.out.println("Max word: " + VectorUtils.findMax(words));
    }
}
