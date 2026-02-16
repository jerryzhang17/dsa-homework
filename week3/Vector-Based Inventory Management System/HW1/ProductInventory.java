import java.util.Enumeration;
import java.util.Vector;

public class ProductInventory {

    Vector<Product> products;

    public ProductInventory(){
        products = new Vector<>();
    }

    public void addProduct(Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(product.getProductId())) {
                System.out.println("Duplicate Found");
                return;
            }
        }
    products.add(product);
}

    public boolean removeProduct(String productId){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId().equals(productId)){
                products.remove(products.get(i));
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productId){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(productId)){
                return products.get(i);
            }
        }
        return null;
    }

    public Vector<Product> getProductsByCategory(String category){
        Vector<Product> groups = new Vector<>();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCategory().equals(category)){
                groups.add(products.get(i));
            }
        }
        return groups;
    }

    public Vector<Product> getLowStockProducts(int threshold){
        Vector<Product> lowStock = new Vector<>();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getQuantityInStock() < threshold){
                lowStock.add(products.get(i));
            }
        }
        return lowStock;
    }

    public double getTotalInventoryValue(){
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice() * products.get(i).getQuantityInStock();
        }
        return total;
    }

    public void updateStock(String productId, int quantityChange){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId().equals(productId)){
                products.get(i).setQuantityInStock(products.get(i).getQuantityInStock() + quantityChange);
                return;
            }
        }
    }

    public void printAllProducts(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i) + " | ");
        }
    }

    public int getTotalProducts(){ 
        return products.size();
    }

    public void printCapacityInfo(){ 
        System.out.print(products.size() + " " + products.capacity());
    }

    public void optimizeCapacity(){
        products.trimToSize();
    }

    public void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }

    public void printCapacityReport(){
        System.out.println("Current Size: " + products.size() + " | " + 
                        "Current Capacity: " + products.capacity() + " | " + 
                        "Capacity Utilization Percentage: " + ((double)products.size() / products.capacity() * 100) + " | " + 
                        "Elements Left: " + (products.capacity() - products.size()));
    }

    public void printProductsUsingEnumeration(){
        Enumeration<Product> e = products.elements();
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement());
            }
    }
    // Enumeration is a legacy interface which vectors were able to use before Java 1.2.
}