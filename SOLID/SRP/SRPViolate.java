package SOLID.SRP;

import java.util.ArrayList;
import java.util.List;

public class SRPViolate {
// this is not necessary this class is created just to keep everything clean in file

    public ViolatedShoppingCart getShoppingCart(){
        return new ViolatedShoppingCart();
    }
}

// ShoppingCart is handelling so many responsibilities which violates SRP principle
class ViolatedShoppingCart {
    
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void printInvoice(){
        products.forEach((product)->{
            System.out.println("Printing Invoice for: " + product.getName() + " Price: " + product.getPrice());
        });
    }

    public void saveToDB(){
        products.forEach((product)->{
            System.out.println("Saving in DB: " + product.getName());
        });
    }
}

