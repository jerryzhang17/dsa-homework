import java.util.Vector;

public class ProductInventory {

    private Vector<Product> products;

    public ProductInventory(){
        products = new Vector<>();
    }

    public void addProduct(Product product){
        if(findProduct(product.getProductId()) != null){
            System.out.println("Duplicate Found");
            return;
        }
        products.add(product);
    }

    public boolean removeProduct(String productId){
    }

    public Product findProduct(String productId){
        ;
    }

    public Vector<Product> getProductsByCategory(String category){

    }

    public Vector<Product> getLowStockProducts(int threshold){

    }

    public double getTotalInventoryValue(){ return }

    public void updateStock(String productId, int quantityChange){
        products.contains(productId).get
    }

    public void printAllProducts(){

    }

    public int getTotalProducts(){ 
        return products.size();
    }

    public void printCapacityInfo(){ 
        System.out.print(products.size() + " " + products.capacity());
    }

}