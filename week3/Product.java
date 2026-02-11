public class Product {

    private String productID;
    private String name;
    private String category;
    private double price;
    private int quantityInStock;
    private String supplier;

    public Product(String productID, String name, String category, double price, int quantityInStock, String supplier) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    public String getProductID() {return productID;}

    public String getName() {return name;}

    public String getCategory() {return category;}

    public double getPrice() {return price;}

    public int getQuantityInStock() {return quantityInStock;}

    public String getSupplier() {return supplier;}

    public void setPrice(double price) {this.price = price;}

    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}

    public void setSupplier(String supplier) {this.supplier = supplier;}

    public void setName(String name) {this.name = name;}

    public void setCategory(String category) {this.category = category;}

    public void setProductID(String productID) {this.productID = productID;}
    
    

}
