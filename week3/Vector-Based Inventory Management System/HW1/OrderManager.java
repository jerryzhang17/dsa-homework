import java.util.Vector;

public class OrderManager {

    Vector<Order> orders;

    public OrderManager(){
        orders = new Vector<>();
    }

    public void addOrder(Order order){
        if(order != null){
            orders.add(order);
        }
    }

    public Order findOrder(String orderId){
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).orderId.equals(orderId)) {
                return orders.get(i);
            }
        }
        return null;
    }

    public Vector<Order> getOrdersByStatus(String status){
        Vector<Order> stats = new Vector<>();
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).orderStatus.equals(status)){
                stats.add(orders.get(i));
            }
        }
        return stats;
    }

    public Vector<Order> getOrdersByCustomer(String customerName){
        Vector<Order> names = new Vector<>();
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).customerName.equals(customerName)){
                names.add(orders.get(i));
            }
        }
        return names;
    }

    public double getTotalRevenue(){
        double total = 0;
        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).calculateTotal();
        }
        return total;
    }

    public void cancelOrder(String orderId){
        if(findOrder(orderId) != null){
            orders.remove(orderId);
        }
    }

    public void printAllOrders(){
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }
    }

    public Vector<Order> getPendingOrders(){
        Vector<Order> pending = new Vector<>();
            for (int i = 0; i < orders.size(); i++) {
                if(orders.get(i).orderStatus.equals("Pending")){
                    pending.add(orders.get(i));
                }
            }
            return pending;
        }

    public int getOrderCount(){
        return orders.size();
    }
}