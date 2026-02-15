import java.util.Vector;

public class Order {
    
    String orderId;
    String customerName;
    String orderDate; // YYYY-MM-DD
    Vector<OrderItem> items;
    String orderStatus; // "Pending", "Processing", "Shipped", "Delivered", "Cancelled"

    public Order(String orderId, String customerName, String orderDate){
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.items = new Vector<>();
        this.orderStatus = orderStatus;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public boolean removeItem(String productId){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getProductId().equals(productId)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public OrderItem findItem(String productId){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getProductId().equals(productId)){
                return items.get(i);
            }
        }
        return null;
    }

    public double calculateTotal(){
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getUnitPrice();
        }
        return total;
    }

    public int getTotalItems(){
        return items.size();
    }

    public void updateStatus(String newStatus){
        this.orderStatus = newStatus;
    }

    public void printOrder(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Items: " + items.get(i));
        }
    }

    public Vector<OrderItem> getItems(){
        return new Vector<>(items);
    }
}
