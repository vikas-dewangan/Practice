package SOLID.SRP;

import java.util.ArrayList;
import java.util.List;

public class SRPFollowed {
// this is not necessary this class is created just to keep everything clean in file

    public SRPAwareShoppingCart getShoppingCart(){
        return new SRPAwareShoppingCart();
    }

    public CartInvoicePrinter getCartInvoicePrinter(SRPAwareShoppingCart cart){
        return new CartInvoicePrinter(cart);
    }

    public CartDBStorage getCartDBStorage(SRPAwareShoppingCart cart){
        return new CartDBStorage(cart);
    }
}

//As per SRP made every class do only one thing
class SRPAwareShoppingCart {
    
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

class CartInvoicePrinter{
    private final SRPAwareShoppingCart cart;

    CartInvoicePrinter(SRPAwareShoppingCart cart){
        this.cart = cart;
    }
    public void printInvoice(){
        cart.getProducts().forEach((product)->{
            System.out.println("Printing Invoice for: " + product.getName() + " Price: " + product.getPrice());
        });
    }

}


class CartDBStorage{
   private final SRPAwareShoppingCart cart;

    CartDBStorage(SRPAwareShoppingCart cart){
        this.cart = cart;
    }

    public void saveToDB(){
        cart.getProducts().forEach((product)->{
            System.out.println("Saving in DB: " + product.getName());
        });
    }
}


