public class Product {

    String productId;
    String name;
    String category;
    double price;
    int quantityInStock;
    String supplier;

    public Product(String productId, String name, String category, double price, int quantityInStock, String supplier) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    public double getPrice() {return price;}
    public int getQuantityInStock() {return quantityInStock;}
    public String getSupplier() {return supplier;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public String getProductId() {return productId;}

    public void setPrice(double price) {this.price = price;}
    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}
    public void setSupplier(String supplier) {this.supplier = supplier;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setProductID(String productID, String productId) {this.productId = productId;}
    
    @Override
    public String toString() {
        return "Product {" + "productId='" + productId + '\'' + ", name='" + name + '\'' + ", category='" + category + '\'' + ", price=" + price + ", quantityInStock=" + quantityInStock + ", supplier='" + supplier + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Product)) return false;
        Product that = (Product) obj;
        return this.productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return productId == null ? 0 : productId.hashCode();
    }
}
