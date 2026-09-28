package SOLID.OCP;

import java.util.ArrayList;
import java.util.List;

public class OCPViolate {
// this is not necessary this class is created just to keep everything clean in file

    public OCPShoppingCart getShoppingCart(){
        return new OCPShoppingCart();
    }

    public OCPViolatedCartDBStorage getCartDBStorage(OCPShoppingCart cart){
        return new OCPViolatedCartDBStorage(cart);
    }
}

//As per SRP made every class do only one thing
class OCPShoppingCart {
    
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


class OCPViolatedCartDBStorage{
    private final OCPShoppingCart cart;

    OCPViolatedCartDBStorage(OCPShoppingCart cart){
        this.cart = cart;
    }

    public void saveToDB(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in DB: " + product.getName());
        });
    }

    //modified the file and crated new methods

    public void saveToFile(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in Files: " + product.getName());
        });
    }

    public void saveToMongoDB(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in Mongo DB: " + product.getName());
        });
    }
}



