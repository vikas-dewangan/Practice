package SOLID.OCP;

import java.util.List;

public class OCP {
    public static void main(String[] args){
        Product laptop = new Product("Laptop", 100000);
        Product mouse =  new Product("Mouse", 1000);

        // OCP violated
        OCPViolate ocpViolate = new OCPViolate();
        OCPShoppingCart shoppingCart = ocpViolate.getShoppingCart();
        shoppingCart.addProduct(laptop);
        shoppingCart.addProduct(mouse);

        OCPViolatedCartDBStorage ocpViolatedCartDBStorage = ocpViolate.getCartDBStorage(shoppingCart);
        ocpViolatedCartDBStorage.saveToDB();
        ocpViolatedCartDBStorage.saveToFile();
        ocpViolatedCartDBStorage.saveToMongoDB();

        //OCP followed
        OCPFollowed ocpFollowed = new OCPFollowed();
        OCPAwareShoppingCart ocpAwareShoppingCart = ocpFollowed.getShoppingCart();
        ocpAwareShoppingCart.addProduct(laptop);
        ocpAwareShoppingCart.addProduct(mouse);

       DBPersistent db = ocpFollowed.getSQLStorage(ocpAwareShoppingCart);
       db.saveToStorage();

       db = ocpFollowed.getFileStorage(ocpAwareShoppingCart);
       db.saveToStorage();

       db = ocpFollowed.getMongoDBStorage(ocpAwareShoppingCart);
       db.saveToStorage();
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