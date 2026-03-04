import java.util.Enumeration;
import java.util.Vector;

public class ProductInventory {

    private Vector<Product> products;

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
                products.remove(i);
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
        System.out.println("ID | Name | Category | Price | Qty | Supplier");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public int getTotalProducts(){ 
        return products.size();
    }

    public void printCapacityInfo(){ 
        System.out.println("Size: " + products.size() + " Capacity: " + products.capacity());
    }

    public void optimizeCapacity(){
        products.trimToSize();
    }

    public void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }

    public void printCapacityReport(){
        System.out.println("Current Size: " + products.size());
        System.out.println("Current Capacity: " + products.capacity());
        System.out.println("Capacity Utilization Percentage: " + ((double)products.size() / products.capacity() * 100) + "%");
        System.out.println("How many elements can be added before resize: " + (products.capacity() - products.size()));
    }

    public void printProductsUsingEnumeration(){
        Enumeration<Product> enumeration = products.elements();
            while (enumeration.hasMoreElements()) {
                System.out.println(enumeration.nextElement());
            }
    }
    // Enumeration is a legacy interface only can be used with vectors and hashtables before Java 1.2.
    // Used with older codebases and older APIs.
    // Iterator can use the operation remove() and works with all collections.
}