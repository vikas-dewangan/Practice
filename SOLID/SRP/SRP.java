package SOLID.SRP;

import java.util.List;

public class SRP {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 100000);
        Product mouse =  new Product("Mouse", 1000);

        //SRP Violation Example
        SRPViolate srpViolate = new SRPViolate();
        ViolatedShoppingCart shoppingcart = srpViolate.getShoppingCart();
        shoppingcart.addProduct(laptop);
        shoppingcart.addProduct(mouse);
        shoppingcart.printInvoice();
        shoppingcart.saveToDB();

        //SRP Aware Example
        SRPFollowed srpFollowed = new SRPFollowed();
        SRPAwareShoppingCart newShoppingcart = srpFollowed.getShoppingCart();
        newShoppingcart.addProduct(laptop);
        newShoppingcart.addProduct(mouse);

        CartInvoicePrinter cartInvoicePrinter = srpFollowed.getCartInvoicePrinter(newShoppingcart);
        cartInvoicePrinter.printInvoice();

        CartDBStorage cartDBStorage = srpFollowed.getCartDBStorage(newShoppingcart);
        cartDBStorage.saveToDB();
    }
}

class Product{
    private final String name;
    private final double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
}
