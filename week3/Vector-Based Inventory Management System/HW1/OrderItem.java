public class OrderItem {
    
    String productId;
    String productName;
    int quantity;
    double unitPrice;
    double subtotal;

    public OrderItem(String productId, String productName, int quantity, double unitPrice){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = quantity * unitPrice;
    }

    public String getProductId() {return productId;}
    public String getProductName() {return productName;}
    public int getQuantity() {return quantity;}
    public double getUnitPrice() {return unitPrice;}
    public double getSubtotal() {return subtotal;}

    public void setProductId(String productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setQuantity(int quantity) {this.quantity = quantity; this.subtotal = this.quantity * this.unitPrice;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
    public void setSubtotal(double subtotal) {this.subtotal = this.quantity * this.unitPrice;}

    @Override
    public String toString() { 
        return "OrderItem {productId = " + productId + " , productName = " + productName + " , quantity = " + quantity + " , unitPrice = " + unitPrice + " , subtotal = " + subtotal + "}"; 
    }

    public double calculateSubtotal(){
        subtotal = this.quantity * this.unitPrice;
        return subtotal;
    }

}
