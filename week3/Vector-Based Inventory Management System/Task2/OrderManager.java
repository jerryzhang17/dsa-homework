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
            if (orders.get(i).getOrderId().equals(orderId)) {
                return orders.get(i);
            }
        }
        return null;
    }

}