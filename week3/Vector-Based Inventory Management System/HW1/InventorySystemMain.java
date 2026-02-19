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

        System.out.println("Find product P200:");
        System.out.println(inventory.findProduct("P200"));

        inventory.removeProduct("P300");
        System.out.println("After removing P300:");

        System.out.println("Inventory Report");
        inventory.printAllProducts();

        System.out.println("Vector Capacity Management:");

        inventory.printCapacityReport();
        inventory.optimizeCapacity();
        inventory.printCapacityReport();

        OrderManager orderManager = new OrderManager();

        Order order1 = new Order("O001", "Alice", "2026-02-16", "Pending");
        order1.addItem(new OrderItem("P100", "Laptop", 1, 1200.0));
        order1.addItem(new OrderItem("P200", "Phone", 2, 800.0));

        orderManager.addOrder(order1);

        System.out.println("Order Report:");
        order1.printOrder();

        order1.updateStatus("Processing");
        System.out.println("Updated order status.");

        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Generic Utility Methods:");
        System.out.println("Sum: " + VectorUtils.sumNumbers(numbers));
        System.out.println("Average: " + VectorUtils.averageNumbers(numbers));

        VectorUtils.swap(numbers, 0, 2);
        System.out.println("After swap: " + numbers);

        System.out.println("Max value: " + VectorUtils.findMax(numbers));
    }
}
