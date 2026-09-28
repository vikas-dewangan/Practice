package SOLID.OCP;

import java.util.ArrayList;
import java.util.List;

public class OCPFollowed {
// this is not necessary this class is created just to keep everything clean in file

    public OCPAwareShoppingCart getShoppingCart(){
        return new OCPAwareShoppingCart();
    }

    public DBPersistent getSQLStorage(OCPAwareShoppingCart cart){
        return new SQLStorage(cart);
    }

    public DBPersistent getFileStorage(OCPAwareShoppingCart cart){
        return new FileStorage(cart);
    }

    public DBPersistent getMongoDBStorage(OCPAwareShoppingCart cart){
        return new MongoDBStorage(cart);
    }
}

//As per SRP made every class do only one thing
class OCPAwareShoppingCart {
    
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (product != null) {
            products.add(product);
        }
    }

    // Defensive copying: Prevents outside code from modifying the internal list
    public List<Product> getProducts(){
        return List.copyOf(products); 
    }

}

//As per OCP closed classes for modification and handelling via DBPersistent
class SQLStorage implements DBPersistent{
    private final OCPAwareShoppingCart cart;

    SQLStorage(OCPAwareShoppingCart cart){
        this.cart = cart;
    }

    @Override
    public void saveToStorage(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in SQL: " + product.getName());
        });
    }
}

class FileStorage implements DBPersistent{
    private final OCPAwareShoppingCart cart;

    FileStorage(OCPAwareShoppingCart cart){
        this.cart = cart;
    }

    @Override
    public void saveToStorage(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in Files: " + product.getName());
        });
    }
}

class MongoDBStorage implements DBPersistent{
    private final OCPAwareShoppingCart cart;

    MongoDBStorage(OCPAwareShoppingCart cart){
        this.cart = cart;
    }

    @Override
    public void saveToStorage(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in MongoDB: " + product.getName());
        });
    }
}


