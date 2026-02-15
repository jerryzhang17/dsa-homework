public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

    Order order1 = new Order("O001", "Alice", "2024-01-15");
    order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
    order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
    orderManager.addOrder(order1);

    Order order2 = new Order("O002", "Bob", "2024-01-16");
    order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
    orderManager.addOrder(order2);

    orderManager.printAllOrders();
    System.out.println("Total revenue: $" + orderManager.getTotalRevenue());
    }
}
